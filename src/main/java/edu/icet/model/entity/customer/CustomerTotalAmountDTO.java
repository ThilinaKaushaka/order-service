package edu.icet.model.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTotalAmountDTO {
    private CustomerEntity customer;
    private Double totalAmount;
}
