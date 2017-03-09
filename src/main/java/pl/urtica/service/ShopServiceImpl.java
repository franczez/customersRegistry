package pl.urtica.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.urtica.dao.ShopRepository;
import pl.urtica.dto.ShopDto;
import pl.urtica.model.Customer;
import pl.urtica.model.Shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil on 2017-03-07.
 */
@Service
public class ShopServiceImpl implements ShopServiceInterface {
    @Autowired
    private DozerBeanMapper mapper;
    @Autowired
    ShopRepository shopRepository;

    @Override
    public List<ShopDto> findAllShops() {
        List<Shop> shopList = shopRepository.findAll();
        List<ShopDto> shopDtoList = new ArrayList<>();
        shopList.forEach(shop -> shopDtoList.add(mapper.map(shop, ShopDto.class)));

        return shopDtoList;
    }

    @Override
    public void modifyShop(ShopDto shopDto) {
        Shop shopToUpdate = shopRepository.findOne(shopDto.getId());
        shopToUpdate.setShopName(shopDto.getShopName());
        List<Customer> customers = new ArrayList<>();
        shopDto.getCustomers().forEach(customerDto -> customers.add(mapper.map(customerDto, Customer.class)));
        shopToUpdate.setCustomers(customers);
        shopRepository.save(shopToUpdate);
    }

    @Override
    public void addShop(ShopDto shopDto) {
        shopRepository.save(mapper.map(shopDto, Shop.class));
    }
}
