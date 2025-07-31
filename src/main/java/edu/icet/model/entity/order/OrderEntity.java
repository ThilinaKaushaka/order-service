package edu.icet.model.entity.order;

import edu.icet.model.entity.customer.CustomerEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private CustomerEntity customerId;




}
