package ru.gb.SpringShop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    private SessionFactory factory;

    @Autowired
    public ProductDao(SessionFactory factory){
        this.factory = factory;
    }

    public List<Product> findAll() {
        List<Product> productList = null;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            productList = session.createQuery("from Product", Product.class).getResultList();
        }
        return productList;
    }

    void deleteById(int id){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }catch (Exception e) {
        e.printStackTrace();
         }
    }

    public void save(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();}
    }

    public Product findById(Integer id) {
        Product product = null;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            product = session.find(Product.class, id);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
    public void costPlus(int id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            int cost = (int) session.createQuery("SELECT cost FROM Product WHERE id = :id").
                    setParameter("id", id).
                    getSingleResult();
            cost++;
            session.createQuery("UPDATE Product set cost = :cost WHERE id = :id")
                    .setParameter("cost", cost)
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void costMinus(int id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            int cost = (int) session.createQuery("SELECT cost FROM Product WHERE id = :id").
                    setParameter("id", id).
                    getSingleResult();
            cost--;
            session.createQuery("UPDATE Product set cost = :cost WHERE id = :id")
                    .setParameter("cost", cost)
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
