package pl.urtica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.urtica.dto.CustomerDto;
import pl.urtica.service.CustomerServiceImpl;

import java.util.List;

/**
 * Created by Kamil on 2017-03-07.
 */
@RestController
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @RequestMapping(value = "/findCustomerById", method = RequestMethod.GET)
    public CustomerDto findCustomerById(@RequestParam Integer id) {
        return customerServiceImpl.findCustomerById(id);
    }

    @RequestMapping(value = "/findAllCustomers", method = RequestMethod.GET)
    public List<CustomerDto> findAllCustomers() {
        return customerServiceImpl.findAllCustomers();
    }

    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
    public void deleteCustomer(@RequestParam Integer id) {
        customerServiceImpl.deleteCustomer(id);
    }

    @RequestMapping(value = "/modifyCustomer", method = RequestMethod.POST)
    public void modifyCustomer(@RequestBody CustomerDto customer) {
        customerServiceImpl.modifyCustomer(customer);
    }
}
