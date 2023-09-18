package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

    @Column(name = "description", length = 1000)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;

    @Column(name = "price")
    @JdbcTypeCode(SqlTypes.DECIMAL)
    private String price;

    @Column(name = "weight")
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private String weight;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "image_url")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String imageURL;

}