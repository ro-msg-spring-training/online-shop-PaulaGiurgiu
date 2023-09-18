package ro.msg.learning.shop.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ro.msg.learning.shop.entity.Customer}
 */
@Value
public class CustomerDTO implements Serializable {
    Integer id;
    String username;
    String email;
}