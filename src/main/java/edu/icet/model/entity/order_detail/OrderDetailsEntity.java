package edu.icet.model.entity.order_detail;

import edu.icet.model.entity.item.ItemEntity;
import edu.icet.model.entity.order.OrderDetailsKey;
import edu.icet.model.entity.order.OrderEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "order_details")

public class OrderDetailsEntity {

    @EmbeddedId
    private OrderDetailsKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private OrderEntity order;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id",referencedColumnName = "id")
    private ItemEntity item;

    private Integer quantity;
    private Double unitPrice;



}
