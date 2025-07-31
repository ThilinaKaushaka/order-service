package edu.icet.model.dto.item.contact_liquid;

import edu.icet.util.item.contact_liquid.SolutionType;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactLiquidDto {
    private Integer id;
    private Integer itemId;
    private Integer volume;
    private Boolean preservatives;
    private SolutionType type;
}
