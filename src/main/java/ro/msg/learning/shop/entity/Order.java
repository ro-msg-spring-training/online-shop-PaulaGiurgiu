package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "created")
    @JdbcTypeCode(SqlTypes.DATE)
    private String created;

    @Column(name = "country", unique = true)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String country;

    @Column(name = "city")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String city;

    @Column(name = "county")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String county;

    @Column(name = "street")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String street;

}