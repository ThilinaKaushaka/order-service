package edu.icet.model.dto.order;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDto {
    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private Double total;
    private Integer customerId;
    private List<OrderDetailsDto> orderDetails;
}
