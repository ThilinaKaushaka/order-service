package edu.icet.model.entity.order;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsKey implements Serializable {
    private Integer orderId;
    private Integer itemId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetailsKey)) return false;
        OrderDetailsKey that = (OrderDetailsKey) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(itemId, that.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, itemId);
    }
}
