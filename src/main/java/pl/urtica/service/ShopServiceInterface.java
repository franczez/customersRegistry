package pl.urtica.service;

import pl.urtica.dto.ShopDto;

import java.util.List;

/**
 * Created by Kamil on 2017-03-07.
 */
public interface ShopServiceInterface {
    List<ShopDto> findAllShops();

    void modifyShop(ShopDto shopDto);

    void addShop(ShopDto shopDto);
}
