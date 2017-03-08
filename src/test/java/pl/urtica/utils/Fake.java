package pl.urtica.utils;

import org.apache.commons.lang3.RandomStringUtils;
import pl.urtica.dto.CustomerDto;
import pl.urtica.dto.ShopDto;
import pl.urtica.model.Customer;
import pl.urtica.model.Shop;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Kamil on 2017-03-07.
 */
public class Fake {
    public static CustomerDto fakeCustomerDto() {
        CustomerDto customerDto = new CustomerDto(randomInt(), randomString(), randomString(), randomInt());
        return customerDto;
    }

    public static Customer fakeCustomer() {
        Customer customer = new Customer();
        customer.setAge(randomInt());
        customer.setId(randomInt());
        customer.setName(randomString());
        customer.setSurname(randomString());
        return customer;
    }

    public static ShopDto fakeShopDto(){
        ShopDto shopDto = new ShopDto(randomInt(), randomString(), Arrays.asList(fakeCustomerDto()));
        return shopDto;
    }

    public static Shop fakeShop(){
        Shop shop = new Shop();
        shop.setId(randomInt());
        shop.setCustomers(Arrays.asList(fakeCustomer(), fakeCustomer()));
        shop.setShopName(randomString());
        return shop;
    }

    public static Integer randomInt() {
        Random random = new Random();
        return random.nextInt();
    }

    public static String randomString() {
        return RandomStringUtils.randomAlphabetic(10);
    }
}
