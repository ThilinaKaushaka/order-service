package edu.icet.model.dto.item;

import edu.icet.util.item.ItemCategory;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ItemDto {
    private Integer id;
    private String name;
    private ItemCategory category;
    private String brand;
    private Integer qty;
    private Double price;
    private String description;
    private Boolean isDisable;
}
