package edu.icet.model.entity.item.nose_pad;

import edu.icet.model.entity.item.ItemEntity;
import edu.icet.util.item.nose_pad.NosePadMaterial;
import edu.icet.util.item.nose_pad.NosePadMountType;
import edu.icet.util.item.nose_pad.NosePadShape;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "nosePad")
public class NosePadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id",unique = true)
    private ItemEntity itemEntity;
    @Enumerated(EnumType.STRING)
    private NosePadMaterial material;
    @Enumerated(EnumType.STRING)
    private NosePadMountType mountType;
    @Enumerated(EnumType.STRING)
    private NosePadShape shape;
}
