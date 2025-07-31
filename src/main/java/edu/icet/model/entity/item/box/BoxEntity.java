package edu.icet.model.entity.item.box;

import edu.icet.model.entity.item.ItemEntity;
import edu.icet.util.item.box.BoxMaterial;
import edu.icet.util.item.box.BoxSize;
import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "box")
public class BoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id",unique = true)
    private ItemEntity itemEntity;

    @Enumerated(EnumType.STRING)
    private BoxMaterial material;
    @Enumerated(EnumType.STRING)
    private BoxSize size;

    private Boolean isLockable;
    private Boolean isWaterProof;
}
