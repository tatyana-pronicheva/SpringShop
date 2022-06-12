package ru.gb.SpringShop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerDao {
        private SessionFactory factory;

        @Autowired
        public CustomerDao(SessionFactory factory){
            this.factory = factory;
        }

        public List<Customer> findAll() {
            List<Customer> customerList = null;
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                customerList = session.createQuery("from Customer", Customer.class).getResultList();
            }
            return customerList;
        }

        void deleteById(int id){
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                Customer customer = session.get(Customer.class, id);
                session.delete(customer);
                session.getTransaction().commit();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        public Customer findById(Integer id) {
            Customer customer = null;
            try (Session session = factory.getCurrentSession()) {
                session.beginTransaction();
                customer = session.find(Customer.class, id);
                session.getTransaction().commit();
            }catch (Exception e) {
                e.printStackTrace();
            }
            return customer;
        }
}
