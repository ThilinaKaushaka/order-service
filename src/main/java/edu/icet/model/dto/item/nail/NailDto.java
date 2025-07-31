package edu.icet.model.dto.item.nail;

import edu.icet.util.item.nail.NailMaterial;
import edu.icet.util.item.nail.NailThreadType;
import edu.icet.util.item.nail.NailUsage;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class NailDto {
    private Integer id;
    private Integer itemId;
    private String size;
    private Boolean isNutAndBolt;
    private NailMaterial material;
    private NailUsage usages;
    private NailThreadType threadType;
}
