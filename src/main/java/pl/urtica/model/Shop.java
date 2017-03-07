package pl.urtica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Kamil on 2017-03-06.
 */
@Entity
public class Shop {
    @Id
    @Column(name = "shop_id")
    @GeneratedValue
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private String companyName;

    @Getter
    @Setter
    @OneToMany
    private Set<Customer>  customers;

}
