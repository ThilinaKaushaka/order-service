package edu.icet.model.entity.item.chain;

import edu.icet.model.entity.item.ItemEntity;
import edu.icet.util.item.chain.ChainClaspType;
import edu.icet.util.item.chain.ChainMaterial;
import edu.icet.util.item.chain.ChainStyle;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "chain")
public class ChainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id",unique = true)
    private ItemEntity itemEntity;

    @Enumerated(EnumType.STRING)
    private ChainMaterial material;
    @Enumerated(EnumType.STRING)
    private ChainStyle style;
    @Enumerated(EnumType.STRING)
    private ChainClaspType claspType;

    private Double length;
}
