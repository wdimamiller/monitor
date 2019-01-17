package org.test.monitor.dao.DaoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.test.monitor.dao.Dao;
import org.test.monitor.domain.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class ServiceDao implements Dao<Service> {

   @PersistenceContext
    private EntityManager entityManager;

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }

    @Override
    public Optional<Service> get(long id) {
        return Optional.ofNullable(entityManager.find(Service.class, id));
    }

    @Override
    public List<Service> getAll() {
        Query query = entityManager.createQuery("SELECT s FROM service s");
        return query.getResultList();
    }

    @Override
    public void save(Service service) {
        executeInsideTransaction(entityManager -> entityManager.persist(service));
    }

    @Override
    public void update(Service service, String[] params) {
        service.setHost(Objects.requireNonNull(params[0], "Name cannot be null"));
        service.setPort(Objects.requireNonNull(params[1], "Email cannot be null"));
        executeInsideTransaction(entityManager -> entityManager.merge(service));
    }

    @Override
    public void delete(Service service) {
        executeInsideTransaction(entityManager -> entityManager.remove(service));
    }


}