package pl.urtica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.urtica.model.Customer;

/**
 * Created by Kamil on 2017-03-07.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
