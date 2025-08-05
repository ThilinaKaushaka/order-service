package edu.icet.repository.custom;


import edu.icet.model.entity.item.ItemEntity;
import edu.icet.model.entity.order_detail.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity,Integer> {

    @Query(value = "SELECT * FROM order_details WHERE order_id = :order_id",nativeQuery = true)
    List<OrderDetailsEntity> findByOrderId(@Param("order_id") Integer orderId);

    @Query("SELECT od.item " +
            "FROM OrderDetailsEntity od " +
            "JOIN od.order o " +
            "WHERE o.date BETWEEN :startDate AND :endDate " +
            "GROUP BY od.item " +
            "ORDER BY SUM(od.quantity) DESC")
    List<ItemEntity> findTopSellingItems(@Param("startDate") LocalDate startDate,
                                         @Param("endDate") LocalDate endDate,
                                         Pageable pageable);


    @Query("SELECT od " +
            "FROM OrderDetailsEntity od " +
            "JOIN od.order o " +
            "WHERE od.item IN :topItems AND o.date BETWEEN :startDate AND :endDate")
    List<OrderDetailsEntity> findAllByItemsAndDateRange(@Param("topItems") List<ItemEntity> topItems,
                                                        @Param("startDate") LocalDate startDate,
                                                        @Param("endDate") LocalDate endDate);



}
