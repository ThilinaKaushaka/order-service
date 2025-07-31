package edu.icet.repository.custom;


import edu.icet.model.entity.order_detail.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity,Integer> {

    @Query(value = "SELECT * FROM order_details WHERE order_id = :order_id",nativeQuery = true)
    List<OrderDetailsEntity> findByOrderId(@Param("order_id") Integer orderId);
}
