package edu.icet.model.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class CustomerDto {
    private Integer id;
    private String name;
    private String address;
    private String tpNo;
    private String email;
    private String nic;
    private Date registeredDate;
}
