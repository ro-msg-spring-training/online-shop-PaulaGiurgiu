package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ro.msg.learning.shop.entity.embedded.StockId;

@Data
@Entity
@Table(name = "stock")
public class Stock {
    @EmbeddedId
    private StockId id;

    @Column(name = "quantity")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer quantity;

}