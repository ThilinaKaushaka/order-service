package edu.icet.model.entity.item.lens;

import edu.icet.model.entity.item.ItemEntity;
import edu.icet.util.item.lens.LensCoating;
import edu.icet.util.item.lens.LensMaterial;
import edu.icet.util.item.lens.LensType;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "lens")
public class LensEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id",unique = true)
    private ItemEntity itemEntity;

    @Enumerated(EnumType.STRING)
    private LensType type;
    @Enumerated(EnumType.STRING)
    private LensMaterial material;
    @Enumerated(EnumType.STRING)
    private LensCoating coating;

    private Double power;
    private Double cylinder;
    private Integer axis;
}
