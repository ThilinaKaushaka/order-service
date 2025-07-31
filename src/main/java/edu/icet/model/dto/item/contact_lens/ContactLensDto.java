package edu.icet.model.dto.item.contact_lens;

import edu.icet.util.item.contact_lens.ContactLensDuration;
import edu.icet.util.item.contact_lens.ContactLensMaterial;
import edu.icet.util.item.contact_lens.ContactLensType;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ContactLensDto {
    private Integer id;
    private Integer itemId;
    private ContactLensType type;
    private ContactLensDuration duration;
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
