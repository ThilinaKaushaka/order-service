package edu.icet.model.dto.item.frame;

import edu.icet.util.item.frame.FrameGender;
import edu.icet.util.item.frame.FrameMaterial;
import edu.icet.util.item.frame.FrameShape;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FrameDto {
    private Integer id;
    private Integer itemId;
    private FrameMaterial material;
    private FrameShape shape;
    private FrameGender gender;
}
