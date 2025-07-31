package edu.icet.model.entity.item.contact_lens;

import edu.icet.model.entity.item.ItemEntity;
import edu.icet.util.item.contact_lens.ContactLensDuration;
import edu.icet.util.item.contact_lens.ContactLensMaterial;
import edu.icet.util.item.contact_lens.ContactLensType;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "contactLens")
public class ContactLensEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id",unique = true)
    private ItemEntity itemEntity;

    @Enumerated(EnumType.STRING)
    private ContactLensType type;
    @Enumerated(EnumType.STRING)
    private ContactLensDuration duration;
    @Enumerated(EnumType.STRING)
    private ContactLensMaterial material;

    private Double waterContent;
    private Double baseCurve;
    private Double diameter;
    private Double power;
    private Double cylinder;
    private Integer axis;
    private String colour;
    private Boolean uvProtection;
}
