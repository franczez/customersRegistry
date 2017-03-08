package pl.urtica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.urtica.dto.CustomerDto;
import pl.urtica.service.CustomerServiceInterface;

import java.util.List;

/**
 * Created by Kamil on 2017-03-07.
 */
@RestController
public class CustomerController {
    @Autowired
    CustomerServiceInterface customerService;

    @RequestMapping(value = "/findCustomerById", method = RequestMethod.GET)
    public CustomerDto findCustomerById(@RequestParam Integer id) {
        return customerService.findCustomerById(id);
    }

    @RequestMapping(value = "/findAllCustomers", method = RequestMethod.GET)
    public List<CustomerDto> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
    public void deleteCustomer(@RequestParam Integer id) {
        customerService.deleteCustomer(id);
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public void addCustomer(@RequestBody CustomerDto customer) {
        customerService.addCustomer(customer);
    }

}
