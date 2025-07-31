package edu.icet.model.dto.item.lens;

import edu.icet.util.item.lens.LensCoating;
import edu.icet.util.item.lens.LensMaterial;
import edu.icet.util.item.lens.LensType;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LensDto {
    private Integer id;
    private Integer itemId;
    private LensType type;
    private LensMaterial material;
    private LensCoating coating;
    private Double power;
    private Double cylinder;
    private Integer axis;
}
