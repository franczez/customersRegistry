package pl.urtica.utils;

import org.apache.commons.lang3.RandomStringUtils;
import pl.urtica.dto.CustomerDto;
import pl.urtica.dto.ShopDto;

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

    public static ShopDto fakeShopDto(){
        ShopDto shopDto = new ShopDto(randomInt(), randomString(), Arrays.asList(fakeCustomerDto()));
        return shopDto;
    }

    public static Integer randomInt() {
        Random random = new Random();
        return random.nextInt();
    }

    public static String randomString() {
        return RandomStringUtils.randomAlphabetic(10);
    }
}
