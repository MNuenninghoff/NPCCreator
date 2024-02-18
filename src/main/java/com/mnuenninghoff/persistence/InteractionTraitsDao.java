package com.mnuenninghoff.persistence;

import com.mnuenninghoff.entity.InteractionTraits;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class InteractionTraitsDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets interaction trait by id.
     *
     * @param id the id
     * @return the by id
     */
    public InteractionTraits getById(int id) {
        Session session = sessionFactory.openSession();
        InteractionTraits interactionTraits = session.get(InteractionTraits.class, id);
        session.close();
        return interactionTraits;
    }
    /**
     * update interaction trait
     * @param interactionTrait interaction trait to be updated
     */
    public void update(InteractionTraits interactionTrait) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(interactionTrait);
        transaction.commit();
        session.close();
    }
    /**
     * insert a new interaction trait
     * @param interactionTrait interaction trait to be inserted
     */
    public int insert(InteractionTraits interactionTrait) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(interactionTrait);
        transaction.commit();
        id = interactionTrait.getId();
        session.close();
        return id;
    }
    /**
     * Delete an interaction trait
     * @param interactionTrait interactionTrait to be deleted
     */
    public void delete(InteractionTraits interactionTrait) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(interactionTrait);
        transaction.commit();
        session.close();
    }
    /** Return a list of all interaction traits
     *
     * @return All interaction traits
     */
    public List<InteractionTraits> getAll() {

        Session session = sessionFactory.openSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<InteractionTraits> query = builder.createQuery(InteractionTraits.class);
        Root<InteractionTraits> root = query.from(InteractionTraits.class);
        List<InteractionTraits> interactionTraits = session.createSelectionQuery( query ).getResultList();

        logger.debug("The list of orders " + interactionTraits);
        session.close();

        return interactionTraits;
    }
}
