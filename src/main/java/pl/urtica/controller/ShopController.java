package pl.urtica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.urtica.dto.ShopDto;
import pl.urtica.service.ShopServiceImpl;

import java.util.List;

/**
 * Created by Kamil on 2017-03-06.
 */
@RestController
public class ShopController {
    @Autowired
    ShopServiceImpl shopServiceImpl;

    @RequestMapping("/findAllShops")
    public List<ShopDto> findAllShops() {
        return shopServiceImpl.findAllShops();
    }

    @RequestMapping("/modifyShop")
    public void modifyShop(@RequestBody ShopDto shop) {

    }
}
