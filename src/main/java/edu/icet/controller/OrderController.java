package edu.icet.controller;


import edu.icet.model.dto.order.OrderDto;
import edu.icet.model.entity.customer.CustomerEntity;
import edu.icet.model.entity.customer.CustomerTotalAmountDTO;
import edu.icet.model.entity.item.ItemEntity;
import edu.icet.model.entity.order.OrderEntity;
import edu.icet.model.entity.order_detail.OrderDetailsEntity;
import edu.icet.service.custom.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/add")
    public void addOrder(@RequestBody OrderDto order){
        orderService.addOrder(order);
    }

    @GetMapping("/search/{id}")
    public OrderDto searchById(@PathVariable Integer id){
        return orderService.searchById(id);
    }

    @PutMapping("/update")
    public void updateOrder(@RequestBody OrderDto order){
        orderService.updateOrder(order);
    }

    @GetMapping("/date")
    List<OrderDto> getByDate(@RequestParam("date") LocalDate date){
        return orderService.getByDate(date);
    }

    @GetMapping("/date-range")
    List<OrderDto> getByDateRange(@RequestParam("startDate") LocalDate startDate,@RequestParam("endDate") LocalDate endDate) {
        return orderService.getByDateRange(startDate, endDate);
    }

    @GetMapping("/date-customer")
    List<OrderDto> getByDateAndCustomer(@RequestParam("date") LocalDate date,@RequestParam("customerId") Integer customerId) {
        return orderService.getByDateAndCustomer(date, customerId);
    }

    @GetMapping("/date-range-customer")
    List<OrderDto> getByDateRangeAndCustomer(@RequestParam("startDate") LocalDate startDate,@RequestParam("endDate") LocalDate endDate, Integer customerId) {
        return orderService.getByDateRangeAndCustomer(startDate, endDate, customerId);
    }

    @GetMapping("/last-ten")
    List<OrderDto> getLastTenOrders() {
        return orderService.getLastTenOrders();
    }

    @GetMapping("/search-by-customer-id")
    List<OrderDto> getByCustomerId(@RequestParam("cus")Integer id){
        return orderService.searchByCustomer(id);
    }

    @GetMapping("/top-three-selling-item/{num}")
    List<OrderDetailsEntity> getTopThreeSellingProduct(@PathVariable Integer num){
        return orderService.getTopSellingItem(num);
    }

    @GetMapping("/top-customers/{num}")
    List<CustomerTotalAmountDTO> getTopOrderingCustomers(@PathVariable Integer num) {
        return orderService.getTopTenSpenders(num);
    }
}
