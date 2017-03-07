package pl.urtica.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by Kamil on 2017-03-07.
 */
public class CustomerDto {
    @Getter
    private Integer id;

    @Getter
    private String name;

    @Getter
    private String surname;

    @Getter
    private Integer age;

    @JsonCreator
    public CustomerDto(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("surname") String surname, @JsonProperty("age") Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
