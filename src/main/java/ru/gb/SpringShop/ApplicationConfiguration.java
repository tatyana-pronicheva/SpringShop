package ru.gb.SpringShop;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.gb.SpringShop")
public class ApplicationConfiguration {

    @Bean(name = "sessionFactory")
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration().configure("configs/crud/hibernate.cfg.xml").buildSessionFactory();
    };

}
