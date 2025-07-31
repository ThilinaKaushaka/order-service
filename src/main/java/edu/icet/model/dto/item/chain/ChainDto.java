package edu.icet.model.dto.item.chain;

import edu.icet.util.item.chain.ChainClaspType;
import edu.icet.util.item.chain.ChainMaterial;
import edu.icet.util.item.chain.ChainStyle;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ChainDto {
    private Integer id;
    private Integer itemId;

    private ChainMaterial material;
    private ChainStyle style;
    private ChainClaspType claspType;

    private Double length;
}
