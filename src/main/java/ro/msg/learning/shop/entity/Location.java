package ro.msg.learning.shop.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String name;

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