package ro.msg.learning.shop.entity.embedded;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import ro.msg.learning.shop.entity.Order;
import ro.msg.learning.shop.entity.Product;

@Getter
@Setter
@Embeddable
public class OrderDetailId {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}