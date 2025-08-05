package edu.icet.service.custom.impl;



import edu.icet.model.dto.order.OrderDetailsDto;
import edu.icet.model.dto.order.OrderDto;
import edu.icet.model.entity.customer.CustomerEntity;
import edu.icet.model.entity.customer.CustomerTotalAmountDTO;
import edu.icet.model.entity.item.ItemEntity;
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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
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


        orderRepository.save(new OrderEntity(order.getId(),LocalDate.now(), LocalTime.now(), order.getTotal(), customerRepository.findById(order.getCustomerId()).get()));
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

        list.forEach(orderDetailsEntity ->
            itemRepository.minItemQty(orderDetailsEntity.getItem().getId(),orderDetailsEntity.getQuantity())
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
    public List<OrderDto> searchByCustomer(Integer id) {
        return getOrderDtoList(orderRepository.getOrdersByCusId(id));
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

    @Override
    public List<OrderDetailsEntity> getTopSellingItem(Integer time) {
        if (time == 1) {

            LocalDate aDateInLastWeek = LocalDate.now().minusWeeks(1);
            LocalDate startDate = aDateInLastWeek.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
            LocalDate endDate = aDateInLastWeek.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
            Pageable topThree = PageRequest.of(0, 3);


            List<ItemEntity> topItems = orderDetailsRepository.findTopSellingItems(startDate, endDate, topThree);

            if (topItems.isEmpty()) {
                return Collections.emptyList();
            }


            return orderDetailsRepository.findAllByItemsAndDateRange(topItems, startDate, endDate);

        } else if (time == 2) {

            YearMonth lastMonth = YearMonth.now().minusMonths(1);
            LocalDate startDate = lastMonth.atDay(1);
            LocalDate endDate = lastMonth.atEndOfMonth();
            Pageable topThree = PageRequest.of(0, 3);


            List<ItemEntity> topItems = orderDetailsRepository.findTopSellingItems(startDate, endDate, topThree);


            if (topItems.isEmpty()) {
                return Collections.emptyList();
            }


            return orderDetailsRepository.findAllByItemsAndDateRange(topItems, startDate, endDate);


        } else if (time == 3) {
            LocalDate aDateInLastYear = LocalDate.now().minusYears(1);
            LocalDate startDate = aDateInLastYear.with(TemporalAdjusters.firstDayOfYear());
            LocalDate endDate = aDateInLastYear.with(TemporalAdjusters.lastDayOfYear());
            Pageable topThree = PageRequest.of(0, 3);


            List<ItemEntity> topItems = orderDetailsRepository.findTopSellingItems(startDate, endDate, topThree);

            if (topItems.isEmpty()) {
                return Collections.emptyList();
            }


            return orderDetailsRepository.findAllByItemsAndDateRange(topItems, startDate, endDate);


        }else {
            return null;
        }

    }

    @Override
    public List<CustomerTotalAmountDTO> getTopTenSpenders(Integer periodType) {
        LocalDate now = LocalDate.now();
        LocalDate startDate;

        switch (periodType) {
            case 1:
                startDate = now.minusWeeks(1);
                break;
            case 2:
                startDate = now.minusMonths(1);
                break;
            case 3:
                startDate = now.minusYears(1);
                break;
            default:

                throw new IllegalArgumentException("Invalid period type: " + periodType);
        }


        Pageable topTen = PageRequest.of(0, 10);
        return orderRepository.findTopCustomersByTotalAmountSince(startDate, topTen);
    }


}
