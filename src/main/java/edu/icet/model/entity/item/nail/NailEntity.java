package edu.icet.model.entity.item.nail;

import edu.icet.model.entity.item.ItemEntity;
import edu.icet.util.item.nail.NailMaterial;
import edu.icet.util.item.nail.NailThreadType;
import edu.icet.util.item.nail.NailUsage;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "nails")
public class NailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id",unique = true)
    private ItemEntity itemEntity;

    private String size;
    private Boolean isNutAndBolt;

    @Enumerated(EnumType.STRING)
    private NailMaterial material;

    @Enumerated(EnumType.STRING)
    private NailUsage usages;

    @Enumerated(EnumType.STRING)
    private NailThreadType threadType;
}
