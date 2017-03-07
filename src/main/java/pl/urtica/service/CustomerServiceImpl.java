package pl.urtica.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.urtica.dto.CustomerDto;
import pl.urtica.exception.NotImplemented;

import java.util.List;

/**
 * Created by Kamil on 2017-03-06.
 */
@Service
public class CustomerServiceImpl implements CustomerServiceInterface{
    @Autowired
    DozerBeanMapper mapper;

    @Override
    public CustomerDto findCustomerById(Integer id) {
        throw new NotImplemented();
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        throw new NotImplemented();
    }

    @Override
    public void deleteCustomer(Integer id) {
        throw new NotImplemented();
    }

    @Override
    public void modifyCustomer(CustomerDto customer) {
        throw new NotImplemented();

    }
}
