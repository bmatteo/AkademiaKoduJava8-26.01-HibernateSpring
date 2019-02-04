package pl.academy.code.services.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import pl.academy.code.services.IHibernateSessionFactoryService;

@Component
public class HibernateSessionFacoryImpl implements IHibernateSessionFactoryService {

    private SessionFactory sessionFactory;

    public HibernateSessionFacoryImpl() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Session getSession() {
        return this.sessionFactory.openSession();
    }
}
