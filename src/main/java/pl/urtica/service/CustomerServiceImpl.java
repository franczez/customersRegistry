package pl.urtica.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.urtica.dao.CustomerRepository;
import pl.urtica.dto.CustomerDto;
import pl.urtica.model.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil on 2017-03-06.
 */
@Service
public class CustomerServiceImpl implements CustomerServiceInterface{
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DozerBeanMapper mapper;

    @Override
    public CustomerDto findCustomerById(Integer id) {
        Customer customer = customerRepository.findOne(id);
        return mapper.map(customer, CustomerDto.class);
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        customers.forEach(customer -> customerDtoList.add(mapper.map(customer, CustomerDto.class)));

        return customerDtoList;
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.delete(id);
    }

    @Override
    public void addCustomer(CustomerDto customerDto) {
        customerRepository.save(mapper.map(customerDto, Customer.class));
    }
}
