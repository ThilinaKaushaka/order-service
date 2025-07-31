package edu.icet.model.dto.item.lens_cleaner;

import edu.icet.util.item.lens_cleaner.CleanerType;
import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LensCleanerDto {
    private Integer id;
    private Integer itemId;
    private Double volume;
    private CleanerType type;
    private Boolean alcoholFree;
    private Boolean antiFog;
}
