package edu.icet.model.entity.item.frame;

import edu.icet.model.entity.item.ItemEntity;
import edu.icet.util.item.frame.FrameGender;
import edu.icet.util.item.frame.FrameMaterial;
import edu.icet.util.item.frame.FrameShape;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "frame")
public class FrameEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id",unique = true)
    private ItemEntity itemEntity;

    @Enumerated(EnumType.STRING)
    private FrameMaterial material;
    @Enumerated(EnumType.STRING)
    private FrameShape shape;
    @Enumerated(EnumType.STRING)
    private FrameGender gender;
}
