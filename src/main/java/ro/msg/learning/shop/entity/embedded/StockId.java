package ro.msg.learning.shop.entity.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import ro.msg.learning.shop.entity.Location;
import ro.msg.learning.shop.entity.Product;

@Getter
@Setter
@Embeddable
public class StockId {
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

   @ManyToOne
   @JoinColumn(name = "product_id")
   private Product product;

}