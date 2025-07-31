package edu.icet.model.entity.employee;

import edu.icet.util.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Date birthDay;
    private String address;

    @Column(unique = true,nullable = false)
    private String tpNo;

    private UserRole role;
    private String passWord;
    @Column(unique = true,nullable = false)
    private String email;

    private Boolean isDisable;
    private Date connectedDate;
    private Date resignationDate;
    private Double salary;
}
