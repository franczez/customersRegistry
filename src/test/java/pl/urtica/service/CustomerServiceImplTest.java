package pl.urtica.service;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.urtica.dao.CustomerRepository;
import pl.urtica.dto.CustomerDto;
import pl.urtica.exception.DataError;
import pl.urtica.model.Customer;
import pl.urtica.utils.Fake;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Created by Kamil on 2017-03-07.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceImplTest {
    @Mock
    CustomerRepository customerRepository;
    @InjectMocks
    CustomerServiceImpl customerService;
    @Spy
    DozerBeanMapper mapper;
    @Captor
    ArgumentCaptor<Customer> captor;

    private List<Customer> customersList;
    private Customer customer;
    private CustomerDto customerDto;

    @Before
    public void setUp() throws Exception {
        customer = Fake.fakeCustomer();
        customersList = Arrays.asList(Fake.fakeCustomer(), Fake.fakeCustomer());
        customerDto = Fake.fakeCustomerDto();

        when(customerRepository.findOne(anyInt())).thenReturn(customer);
        when(customerRepository.findAll()).thenReturn(customersList);
    }

    @Test
    public void findCustomerById() throws Exception {
        CustomerDto actual = customerService.findCustomerById(1);

        assertEquals(actual.getSurname(), customer.getSurname());
        assertEquals(actual.getId(), customer.getId());
        assertEquals(actual.getName(), customer.getName());
        assertEquals(actual.getAge(), customer.getAge());
    }

    @Test
    public void findAllCustomers() throws Exception {
        List<CustomerDto> actual = customerService.findAllCustomers();

        assertEquals(actual.get(0).getSurname(), customersList.get(0).getSurname());
        assertEquals(actual.get(0).getId(), customersList.get(0).getId());
        assertEquals(actual.get(0).getName(), customersList.get(0).getName());
        assertEquals(actual.get(0).getAge(), customersList.get(0).getAge());

        assertEquals(actual.get(1).getSurname(), customersList.get(1).getSurname());
        assertEquals(actual.get(1).getId(), customersList.get(1).getId());
        assertEquals(actual.get(1).getName(), customersList.get(1).getName());
        assertEquals(actual.get(1).getAge(), customersList.get(1).getAge());
    }

    @Test
    public void deleteCustomerShouldPass() throws Exception {
        doNothing().when(customerRepository).delete(anyInt());

        customerService.deleteCustomer(1);
    }

    @Test(expected = DataError.class)
    public void deleteCustomerShouldThrow() throws Exception {
        doThrow(new DataError("Error while deleting user")).when(customerRepository).delete(anyInt());

        customerService.deleteCustomer(1);
    }

    @Test
    public void addShop() throws Exception {
        customerService.addCustomer(customerDto);
        verify(customerRepository).save(captor.capture());

        assertEquals(customerDto.getId(), captor.getValue().getId());
        assertEquals(customerDto.getAge(), captor.getValue().getAge());
        assertEquals(customerDto.getName(), captor.getValue().getName());
        assertEquals(customerDto.getSurname(), captor.getValue().getSurname());
    }
}