package pl.urtica.dto;

import lombok.Getter;
import org.dozer.Mapping;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

/**
 * Created by Kamil on 2017-03-07.
 */
public class ShopDto {
    @Getter
    @Mapping("id")
    private Integer id;

    @Getter
    @Mapping("shopName")
    private String shopName;

    @Getter
    @Mapping("customers")
    @Fetch(value = FetchMode.SELECT)
    private List<CustomerDto> customers;

    public ShopDto() {
    }

    public ShopDto(Integer id, String shopName, List<CustomerDto> customers) {
        this.id = id;
        this.shopName = shopName;
        this.customers = customers;
    }
}
