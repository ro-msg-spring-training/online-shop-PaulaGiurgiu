package ro.msg.learning.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.CustomerDTO;
import ro.msg.learning.shop.entity.repository.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/findAll")
    public List<CustomerDTO> findAll() {
//        var customers = customerRepository.findAll();
//        return customers;
        return null;
    }
}
