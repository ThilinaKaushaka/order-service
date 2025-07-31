package edu.icet.model.dto.item.box;

import edu.icet.util.item.box.BoxMaterial;
import edu.icet.util.item.box.BoxSize;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoxDto {
    private Integer id;
    private Integer itemId;
    private BoxMaterial material;
    private BoxSize size;
    private Boolean isLockable;
    private Boolean isWaterProof;
}
