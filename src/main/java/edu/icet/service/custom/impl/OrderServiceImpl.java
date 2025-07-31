package edu.icet.service.custom.impl;



import edu.icet.model.dto.order.OrderDetailsDto;
import edu.icet.model.dto.order.OrderDto;
import edu.icet.model.entity.order.OrderDetailsKey;
import edu.icet.model.entity.order.OrderEntity;
import edu.icet.model.entity.order_detail.OrderDetailsEntity;
import edu.icet.repository.custom.CustomerDao;
import edu.icet.repository.custom.ItemDao;
import edu.icet.repository.custom.OrderDetailsRepository;
import edu.icet.repository.custom.OrderRepository;
import edu.icet.service.custom.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CustomerDao customerRepository;
    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;
    private final ModelMapper mapper;
    private final ItemDao itemRepository;
    @Override
    public void addOrder(OrderDto order) {


        orderRepository.save(new OrderEntity(order.getId(), order.getDate(), order.getTime(), order.getTotal(), customerRepository.findById(order.getCustomerId()).get()));
        List<OrderDetailsEntity>list=new ArrayList<>();
        order.getOrderDetails().forEach(orderDetailsDto -> {
            OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();

            orderDetailsEntity.setOrder(orderRepository.getLastOrder());
            orderDetailsEntity.setItem(itemRepository.findById(orderDetailsDto.getItemId()).get());

            orderDetailsEntity.setId(new OrderDetailsKey(orderDetailsEntity.getOrder().getId(),orderDetailsEntity.getItem().getId()));

            orderDetailsEntity.setQuantity(orderDetailsDto.getQuantity());
            orderDetailsEntity.setUnitPrice(orderDetailsDto.getUnitPrice());
            list.add(orderDetailsEntity);
        });


        saveOrderDetails(list);

    }

    private void saveOrderDetails(List<OrderDetailsEntity> list){
        list.forEach(orderDetailsRepository::save
        );
    }

    @Override
    public OrderDto searchById(Integer id) {
        OrderEntity orderEntity=orderRepository.findById(id).get();
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderEntity.getId());
        orderDto.setDate(orderEntity.getDate());
        orderDto.setTime(orderEntity.getTime());
        orderDto.setTotal(orderEntity.getTotal());
        orderDto.setCustomerId(orderEntity.getCustomerId().getId());
        orderDto.setOrderDetails(getOrderDetailsList(orderEntity.getId()));
        return orderDto;
    }

    private List<OrderDetailsDto> getOrderDetailsList(Integer orderId){
        List<OrderDetailsDto> list = new ArrayList<>();
        orderDetailsRepository.findByOrderId(orderId).forEach(orderDetailsEntity -> {
            OrderDetailsDto orderDetailsDto=new OrderDetailsDto();
            orderDetailsDto.setOrderId(orderDetailsEntity.getOrder().getId());
            orderDetailsDto.setItemId(orderDetailsEntity.getItem().getId());
            orderDetailsDto.setQuantity(orderDetailsEntity.getQuantity());
            orderDetailsDto.setUnitPrice(orderDetailsEntity.getUnitPrice());
            list.add(orderDetailsDto);
        });
        return list;
    }




    @Override
    public void updateOrder(OrderDto order) {
        addOrder(order);
    }


    @Override
    public List<OrderDto> getByDate(LocalDate date) {
        List<OrderEntity> byDate = orderRepository.getByDate(date);

        return getOrderDtoList(orderRepository.getByDate(date));
    }

    private List<OrderDto> getOrderDtoList(List<OrderEntity> orderEntityList){
        List<OrderDto>orderDtoList=new ArrayList<>();
        orderEntityList.forEach(orderEntity -> {
            OrderDto orderDto = new OrderDto();
            orderDto.setId(orderEntity.getId());
            orderDto.setDate(orderEntity.getDate());
            orderDto.setTime(orderEntity.getTime());
            orderDto.setTotal(orderEntity.getTotal());
            orderDto.setCustomerId(orderEntity.getCustomerId().getId());
            orderDto.setOrderDetails(getOrderDetailsList(orderEntity.getId()));
            orderDtoList.add(orderDto);
        });
        
        return orderDtoList;
    }

    @Override
    public List<OrderDto> getByDateRange(LocalDate startDate, LocalDate endDate) {
        return getOrderDtoList(orderRepository.getByDateRange(startDate, endDate));
    }

    @Override
    public List<OrderDto> getByDateAndCustomer(LocalDate date, Integer customerId) {
        return getOrderDtoList(orderRepository.getByDateAndCustomer(date, customerId));
    }

    @Override
    public List<OrderDto> getByDateRangeAndCustomer(LocalDate startDate, LocalDate endDate, Integer customerId) {
        return getOrderDtoList(orderRepository.getByDateRangeAndCustomer(startDate, endDate, customerId));
    }

    @Override
    public List<OrderDto> getLastTenOrders() {
        return getOrderDtoList(orderRepository.getLastTenOrders());
    }


}
