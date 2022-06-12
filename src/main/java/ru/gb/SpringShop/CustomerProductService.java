package ru.gb.SpringShop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerProductService {
    private SessionFactory factory;

    @Autowired
    public CustomerProductService(SessionFactory factory){
        this.factory = factory;
    }

    public  List<Product> customerGetPurchasedProductsById(int customerId){
    List<Product> productList = null;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Customer customer = session.find(Customer.class, customerId);
            productList = customer.getProducts();
            System.out.println(productList);
            session.getTransaction().commit();
        }
        return  productList;
    }

    public  List<Customer> productGetAllCustomersById(int productId){
        List<Customer> customerList = null;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.find(Product.class, productId);
            customerList = product.getCustomers();
            System.out.println(customerList);
            session.getTransaction().commit();
        }
        return  customerList;
    }
}
