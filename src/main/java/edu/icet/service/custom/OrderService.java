package edu.icet.service.custom;



import edu.icet.model.dto.order.OrderDto;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    void addOrder(OrderDto order);
    OrderDto searchById(Integer id);
    void updateOrder(OrderDto order);

    List<OrderDto> getByDate(LocalDate date);
    List<OrderDto> getByDateRange(LocalDate startDate, LocalDate endDate);
    List<OrderDto> getByDateAndCustomer(LocalDate date, Integer customerId);
    List<OrderDto> getByDateRangeAndCustomer(LocalDate startDate, LocalDate endDate, Integer customerId);
    List<OrderDto> getLastTenOrders();
}
