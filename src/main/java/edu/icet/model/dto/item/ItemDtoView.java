package edu.icet.model.dto.item;

import edu.icet.util.item.ItemCategory;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ItemDtoView {
    private Integer id;
    private String name;
    private ItemCategory category;
    private String brand;
    private Integer qty;
    private Double price;
    private String description;
    private Boolean isDisable;
    private Object itemObject;
}
