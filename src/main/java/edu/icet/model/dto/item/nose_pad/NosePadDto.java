package edu.icet.model.dto.item.nose_pad;

import edu.icet.util.item.nose_pad.NosePadMaterial;
import edu.icet.util.item.nose_pad.NosePadMountType;
import edu.icet.util.item.nose_pad.NosePadShape;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NosePadDto {
    private Integer id;
    private Integer itemId;
    private NosePadMaterial material;
    private NosePadMountType mountType;
    private NosePadShape shape;
}
