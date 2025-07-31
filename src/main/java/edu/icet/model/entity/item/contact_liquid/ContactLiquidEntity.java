package edu.icet.model.entity.item.contact_liquid;

import edu.icet.model.entity.item.ItemEntity;
import edu.icet.util.item.contact_liquid.SolutionType;
import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "contactLiquid")
public class ContactLiquidEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id",unique = true)
    private ItemEntity itemEntity;

    private Integer volume;
    private Boolean preservatives;

    @Enumerated(EnumType.STRING)
    private SolutionType type;
}
