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
import pl.urtica.dto.ShopDto;
import pl.urtica.service.ShopServiceImpl;
import pl.urtica.utils.Fake;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Kamil on 2017-03-07.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ShopController.class)
public class ShopControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ShopServiceImpl shopService;

    private List<ShopDto> shopList;
    private ShopDto shop;
    private ObjectMapper mapper;

    @Before
    public void setUp() throws Exception {
        shopList = Arrays.asList(Fake.fakeShopDto(), Fake.fakeShopDto());
        shop = Fake.fakeShopDto();
        mapper = new ObjectMapper();

        when(shopService.findAllShops()).thenReturn(shopList);
    }

    @Test
    public void findAllShops() throws Exception {
        this.mockMvc.perform(get("/findAllShops")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$[0].id").value(shopList.get(0).getId()))
                .andExpect(jsonPath("$[0].shopName").value(shopList.get(0).getShopName()))
                .andExpect(jsonPath("$[0].customers.[0].name").value(shopList.get(0).getCustomers().get(0).getName()))
                .andExpect(jsonPath("$[0].customers.[0].age").value(shopList.get(0).getCustomers().get(0).getAge()))
                .andExpect(jsonPath("$[1].id").value(shopList.get(1).getId()))
                .andExpect(jsonPath("$[1].shopName").value(shopList.get(1).getShopName()))
                .andExpect(jsonPath("$[1].customers.[0].name").value(shopList.get(1).getCustomers().get(0).getName()))
                .andExpect(jsonPath("$[1].customers.[0].age").value(shopList.get(1).getCustomers().get(0).getAge()));

    }

    @Test
    public void modifyShop() throws Exception {
        this.mockMvc.perform(post("/modifyShop")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsString(shop))
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk());
    }

}