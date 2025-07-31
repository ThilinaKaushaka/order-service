package edu.icet.model.entity.item.lens_cloth;

import edu.icet.model.entity.item.ItemEntity;
import edu.icet.util.item.lens_cloth.LensClothMaterial;
import edu.icet.util.item.lens_cloth.LensClothSize;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "lensCloth")
public class LensClothEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id",unique = true)
    private ItemEntity itemEntity;

    @Enumerated(EnumType.STRING)
    private LensClothMaterial material;
    @Enumerated(EnumType.STRING)
    private LensClothSize size;

    private Boolean isAntiStatic;
    private Boolean isPrinted;
}
