package pl.urtica.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.urtica.dto.ShopDto;
import pl.urtica.exception.NotImplemented;

import java.util.List;

/**
 * Created by Kamil on 2017-03-07.
 */
@Service
public class ShopServiceImpl implements ShopServiceInterface {
    @Autowired
    DozerBeanMapper mapper;

    @Override
    public List<ShopDto> findAllShops() {
        throw new NotImplemented();
    }

    @Override
    public void modifyShop(Integer id) {
        throw new NotImplemented();
    }
}
