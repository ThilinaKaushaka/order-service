package edu.icet.model.dto.employee;

import edu.icet.util.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class EmployeeDto {
    private Integer id;
    private String name;
    private Date birthDay;
    private String address;
    private String tpNo;
    private UserRole role;
    private String passWord;
    private String email;
    private Boolean isDisable;
    private Date connectedDate;
    private Date resignationDate;
    private Double salary;
}
