package service;

import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Andrey on 20.01.2019.
 */
public class HibernateService {
    @Getter
    private SessionFactory sessionFactory;

    public HibernateService(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
}
