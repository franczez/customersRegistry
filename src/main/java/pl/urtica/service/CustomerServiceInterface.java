package pl.urtica.service;

import pl.urtica.dto.CustomerDto;

import java.util.List;

/**
 * Created by Kamil on 2017-03-07.
 */
public interface CustomerServiceInterface {
    CustomerDto findCustomerById(Integer id);

    List<CustomerDto> findAllCustomers();

    void deleteCustomer(Integer id);

    void addCustomer(CustomerDto customerDto);
}
