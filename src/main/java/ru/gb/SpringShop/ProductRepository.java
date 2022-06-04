package ru.gb.SpringShop;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> list = new ArrayList<>();

    public ProductRepository(){
        list.add(new Product(1,"Milk", 50));
        list.add(new Product(2,"Bread", 20));
        list.add(new Product(3, "Meat", 300));
        list.add(new Product( 4, "Butter", 200));
        list.add(new Product(5, "Eggs", 100));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(list);
    }

    public void save(Product student) {
        list.add(student);
    }

    public Product findById(Integer id) {
        return list.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }
}
