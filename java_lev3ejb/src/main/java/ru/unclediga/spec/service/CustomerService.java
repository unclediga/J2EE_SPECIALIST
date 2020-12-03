package ru.unclediga.spec.service;

import ru.unclediga.spec.model.Customer;

import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.List;

@Stateless
public class CustomerService {

    private final List<Customer> customers = Arrays.asList(
            new Customer(1, "Cust1", "111-11-11"),
            new Customer(2, "Cust2", "222-22-22"),
            new Customer(3, "Cust3", "333-33-33")
    );

    public List<Customer> getAll() {
        return customers;
    }

    public Customer getById(long id) {
        int idx = (int) (id - 1L);
        switch (idx) {
            case 0:
            case 1:
            case 2:
                return customers.get(idx);
        }
        return null;
    }

    public void create(Customer customer) {
        customers.add(new Customer(
                customers.size() + 1,
                customer.getName(),
                customer.getPhone()));
    }
}
