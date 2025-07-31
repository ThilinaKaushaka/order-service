package edu.icet.model.dto.order;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailsDto {
    private Integer orderId;
    private Integer itemId;
    private Integer quantity;
    private Double unitPrice;

}
