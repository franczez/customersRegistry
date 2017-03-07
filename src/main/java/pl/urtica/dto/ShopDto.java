package pl.urtica.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

/**
 * Created by Kamil on 2017-03-07.
 */
public class ShopDto {
    @Getter
    private Integer id;

    @Getter
    private String shopName;

    @Getter
    private List<CustomerDto> customers;

    @JsonCreator
    public ShopDto(@JsonProperty("id") Integer id, @JsonProperty("shopName") String shopName, @JsonProperty("customers") List<CustomerDto> customers) {
        this.id = id;
        this.shopName = shopName;
        this.customers = customers;
    }
}
