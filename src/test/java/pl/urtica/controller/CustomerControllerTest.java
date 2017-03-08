package pl.urtica.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.urtica.dto.CustomerDto;
import pl.urtica.service.CustomerServiceImpl;
import pl.urtica.utils.Fake;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by Kamil on 2017-03-07.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @MockBean
    CustomerServiceImpl customerService;
    @Autowired
    private MockMvc mockMvc;

    private List<CustomerDto> customersList;
    private CustomerDto customerDto;
    private ObjectMapper mapper;

    @Before
    public void setUp() throws Exception {
        customerDto = Fake.fakeCustomerDto();
        customersList = Arrays.asList(Fake.fakeCustomerDto(), Fake.fakeCustomerDto());
        mapper = new ObjectMapper();

        when(customerService.findCustomerById(anyInt())).thenReturn(customerDto);
        when(customerService.findAllCustomers()).thenReturn((customersList));
    }

    @Test
    public void findCustomerById() throws Exception {
        this.mockMvc.perform(get("/findCustomerById")
                .param("id", "1")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.age").value(customerDto.getAge()))
                .andExpect(jsonPath("$.name").value(customerDto.getName()))
                .andExpect(jsonPath("$.surname").value(customerDto.getSurname()))
                .andExpect(jsonPath("$.id").value(customerDto.getId()));
    }

    @Test
    public void findAllCustomers() throws Exception {
        this.mockMvc.perform(get("/findAllCustomers")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].age").value(customersList.get(0).getAge()))
                .andExpect(jsonPath("$[0].name").value(customersList.get(0).getName()))
                .andExpect(jsonPath("$[0].surname").value(customersList.get(0).getSurname()))
                .andExpect(jsonPath("$[0].id").value(customersList.get(0).getId()))
                .andExpect(jsonPath("$[1].age").value(customersList.get(1).getAge()))
                .andExpect(jsonPath("$[1].name").value(customersList.get(1).getName()))
                .andExpect(jsonPath("$[1].surname").value(customersList.get(1).getSurname()))
                .andExpect(jsonPath("$[1].id").value(customersList.get(1).getId()));
    }

    @Test
    public void deleteCustomer() throws Exception {
        this.mockMvc.perform(get("/deleteCustomer")
                .param("id", "1")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
    }

    @Test
    public void addCustomer() throws Exception {
        this.mockMvc.perform(post("/addCustomer")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(customerDto))
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
    }
}