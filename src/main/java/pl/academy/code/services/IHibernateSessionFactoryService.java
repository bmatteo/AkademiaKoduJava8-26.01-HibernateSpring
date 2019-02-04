package pl.academy.code.services;

import org.hibernate.Session;

public interface IHibernateSessionFactoryService {
    Session getSession();
}
