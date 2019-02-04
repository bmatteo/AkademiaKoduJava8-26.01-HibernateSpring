package pl.academy.code.services.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.academy.code.model.Animal;
import pl.academy.code.services.IAnimalService;
import pl.academy.code.services.IHibernateSessionFactoryService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Component
public class AnimalServiceImpl implements IAnimalService {

    @Autowired
    IHibernateSessionFactoryService sessionFactoryService;

    public void saveAnimal(Animal animal) {
        Session session = this.sessionFactoryService.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(animal);
        transaction.commit();
        session.close();
    }

    public List<Animal> getAllAnimals() {
        Session session = this.sessionFactoryService.getSession();
        Transaction tx = session.beginTransaction();

        List<Animal> list = session.createCriteria(Animal.class).list();

        tx.commit();
        session.close();
        return list;
    }

    public Animal getAnimalById(int id) {
        /*
        Po staremu !!!!

        Session session = this.sessionFactoryService.getSession();
        Transaction tx = session.beginTransaction();

        Criteria criteria = session.createCriteria(Animal.class);
        criteria.add(Restrictions.eq("id", id));
        Animal animal = (Animal) criteria.uniqueResult();

        tx.commit();
        session.close();
        return animal;
        */
        Session session = this.sessionFactoryService.getSession();
        Transaction tx = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Animal> criteriaQuery = criteriaBuilder.createQuery(Animal.class);

        Root<Animal> root = criteriaQuery.from(Animal.class);

        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));

        criteriaQuery.where(criteriaBuilder.equal(root.get("name"), "Reksio"));
        Query<Animal> query = session.createQuery(criteriaQuery);
        Animal animal = query.getSingleResult();

        tx.commit();
        session.close();

        return animal;


    }

    public void updateAnimal(Animal animal) {
        Session session = this.sessionFactoryService.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(animal);
        transaction.commit();
        session.close();
    }
}
