package edu.icet.model.entity.customer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@NoArgsConstructor
@Data
@ToString
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(unique = true,nullable = false)
    private String address;
    @Column(unique = true,nullable = false)
    private String tpNo;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(unique = true,nullable = false)
    private String nic;

    private Date registeredDate;

    public CustomerEntity(Integer customerId, Object o, Object o1, Object o2, Object o3, Object o4) {
    }
}
