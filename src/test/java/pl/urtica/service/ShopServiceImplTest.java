package pl.urtica.service;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.test.context.junit4.SpringRunner;
import pl.urtica.dao.ShopRepository;
import pl.urtica.dto.ShopDto;
import pl.urtica.model.Shop;
import pl.urtica.utils.Fake;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Kamil on 2017-03-07.
 */
@RunWith(SpringRunner.class)
public class ShopServiceImplTest {
    @Mock
    ShopRepository shopRepository;
    @InjectMocks
    ShopServiceImpl shopService;
    @Spy
    DozerBeanMapper mapper;
    @Captor
    ArgumentCaptor<Shop> captor;

    private List<Shop> shopList;
    private Shop shop;
    private ShopDto shopDto;

    @Before
    public void setUp() throws Exception {
        shop = Fake.fakeShop();
        shopList = Arrays.asList(Fake.fakeShop(), Fake.fakeShop());
        shopDto = Fake.fakeShopDto();

        when(shopRepository.findAll()).thenReturn(shopList);
    }

    @Test
    public void findAllShops() throws Exception {
        List<ShopDto> actual = shopService.findAllShops();

        assertEquals(actual.size(), shopList.size());
        assertEquals(actual.get(0).getShopName(), shopList.get(0).getShopName());
        assertEquals(actual.get(0).getId(), shopList.get(0).getId());
        assertEquals(actual.get(0).getId(), shopList.get(0).getId());
        assertEquals(actual.get(0).getCustomers().get(0).getId(), shopList.get(0).getCustomers().get(0).getId());
        assertEquals(actual.get(0).getCustomers().get(0).getAge(), shopList.get(0).getCustomers().get(0).getAge());
        assertEquals(actual.get(0).getCustomers().get(0).getName(), shopList.get(0).getCustomers().get(0).getName());
        assertEquals(actual.get(0).getCustomers().get(0).getSurname(), shopList.get(0).getCustomers().get(0).getSurname());

        assertEquals(actual.get(1).getShopName(), shopList.get(1).getShopName());
        assertEquals(actual.get(1).getId(), shopList.get(1).getId());
        assertEquals(actual.get(1).getId(), shopList.get(1).getId());
        assertEquals(actual.get(1).getCustomers().get(1).getId(), shopList.get(1).getCustomers().get(1).getId());
        assertEquals(actual.get(1).getCustomers().get(1).getAge(), shopList.get(1).getCustomers().get(1).getAge());
        assertEquals(actual.get(1).getCustomers().get(1).getName(), shopList.get(1).getCustomers().get(1).getName());
        assertEquals(actual.get(1).getCustomers().get(1).getSurname(), shopList.get(1).getCustomers().get(1).getSurname());
    }


    @Test
    public void modifyShop() throws Exception {
        when(shopRepository.findOne(anyInt())).thenReturn(shop);

        shopService.modifyShop(shopDto);
        verify(shopRepository).save(captor.capture());

        assertEquals(shop.getId(), captor.getValue().getId());
        assertEquals(shopDto.getShopName(), captor.getValue().getShopName());
        assertEquals(shopDto.getCustomers().get(0).getAge(), captor.getValue().getCustomers().get(0).getAge());
        assertEquals(shopDto.getCustomers().get(0).getId(), captor.getValue().getCustomers().get(0).getId());
    }

    @Test
    public void addShop() throws Exception {
        shopService.addShop(shopDto);
        verify(shopRepository).save(captor.capture());

        assertEquals(shopDto.getId(), captor.getValue().getId());
        assertEquals(shopDto.getShopName(), captor.getValue().getShopName());
        assertEquals(shopDto.getCustomers().get(0).getAge(), captor.getValue().getCustomers().get(0).getAge());
        assertEquals(shopDto.getCustomers().get(0).getId(), captor.getValue().getCustomers().get(0).getId());
    }
}