package edu.icet.model.entity.item;

import edu.icet.util.item.ItemCategory;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "item")
public class ItemEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ItemCategory category;
    private String brand;
    private Integer qty;
    private Double price;
    private String description;

    @Column(name = "created_at",nullable = false,updatable = false)
    @CreationTimestamp
    private java.sql.Timestamp createdAt;

    private Boolean isDisable;
}
