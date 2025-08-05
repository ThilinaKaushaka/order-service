package edu.icet.repository.custom;


import edu.icet.model.entity.customer.CustomerEntity;
import edu.icet.model.entity.customer.CustomerTotalAmountDTO;
import edu.icet.model.entity.order.OrderEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    @Query(value = "SELECT * FROM `orders` WHERE date = :date",nativeQuery = true)
    List<OrderEntity> getByDate(@Param("date")LocalDate date);

    @Query(value = "SELECT * FROM `orders` WHERE customer_id= :id",nativeQuery = true)
    List<OrderEntity> getOrdersByCusId(@Param("id") Integer id);
    @Query(value = "SELECT * FROM `orders` WHERE date BETWEEN :startDate AND :endDate",nativeQuery = true)
    List<OrderEntity> getByDateRange(@Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate);

    @Query(value = "SELECT * FROM `orders` WHERE date = :date AND customer_id = :customerId",nativeQuery = true)
    List<OrderEntity> getByDateAndCustomer(@Param("date")LocalDate date,@Param("customerId")Integer customerId);

    @Query(value = "SELECT * FROM `orders` WHERE date BETWEEN :startDate AND :endDate AND customer_id = :customerId",nativeQuery = true)
    List<OrderEntity> getByDateRangeAndCustomer(@Param("startDate")LocalDate startDate,@Param("endDate")LocalDate endDate,@Param("customerId")Integer customerId);

    @Query(value = "SELECT * FROM `orders` ORDER BY id DESC LIMIT 10",nativeQuery = true)
    List<OrderEntity> getLastTenOrders();

    @Query(value ="SELECT id FROM `orders` ORDER BY id DESC LIMIT 1" ,nativeQuery = true)
    Long getLastOrderId();

    @Query(value ="SELECT * FROM `orders` ORDER BY id DESC LIMIT 1" ,nativeQuery = true)
    OrderEntity getLastOrder();

    // In OrderRepository.java
    @Query("SELECT new edu.icet.model.entity.customer.CustomerTotalAmountDTO(o.customerId, SUM(o.total)) " + // <-- Use your real package path
            "FROM OrderEntity o " +
            "WHERE o.date >= :startDate " +
            "GROUP BY o.customerId " +
            "ORDER BY SUM(o.total) DESC")
    List<CustomerTotalAmountDTO> findTopCustomersByTotalAmountSince(
            @Param("startDate") LocalDate startDate,
            Pageable pageable
    );
}
