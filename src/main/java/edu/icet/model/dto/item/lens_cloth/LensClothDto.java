package edu.icet.model.dto.item.lens_cloth;

import edu.icet.util.item.lens_cloth.LensClothMaterial;
import edu.icet.util.item.lens_cloth.LensClothSize;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LensClothDto {
    private Integer id;
    private Integer itemId;
    private LensClothMaterial material;
    private LensClothSize size;
    private Boolean isAntiStatic;
    private Boolean isPrinted;

}
