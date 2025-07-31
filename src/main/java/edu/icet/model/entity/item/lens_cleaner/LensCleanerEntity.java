package edu.icet.model.entity.item.lens_cleaner;

import edu.icet.model.entity.item.ItemEntity;
import edu.icet.util.item.lens_cleaner.CleanerType;
import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "lensCleaner")
public class LensCleanerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "item_id",referencedColumnName = "id",unique = true)
    private ItemEntity itemEntity;

    private Double volume;

    @Enumerated(EnumType.STRING)
    private CleanerType type;

    private Boolean alcoholFree;
    private Boolean antiFog;
}
