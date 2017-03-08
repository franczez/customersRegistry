package pl.urtica.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.dozer.Mapping;

/**
 * Created by Kamil on 2017-03-07.
 */
public class CustomerDto {
    @Getter
    @Mapping("id")
    private Integer id;

    @Getter
    @Mapping("name")
    private String name;

    @Mapping("surname")
    @Getter
    private String surname;

    @Mapping("age")
    @Getter
    private Integer age;

    public CustomerDto() {
    }

    @JsonCreator
    public CustomerDto(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("surname") String surname, @JsonProperty("age") Integer age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
