package com.maktab25.homework11.tamrin2.repository.impl;

import com.maktab25.homework11.tamrin2.repository.base.BaseRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public abstract class BaseRepositoryImpl<E extends Serializable> implements BaseRepository<E> {


    private static SessionFactory factory;

    public BaseRepositoryImpl(SessionFactory factory) {
        BaseRepositoryImpl.factory = factory;
    }

    protected abstract String getEntityName();

    @Override
    public void create(E e) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.persist(e);

        session.getTransaction().commit();

        session.close();

    }


    @Override
    public E update(E e) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.update(e);

        session.getTransaction().commit();

        session.close();

        return e;
    }

    @Override
    public E read(Serializable id) {
        Session session = factory.openSession();

        Object o = session.createQuery("from " + getEntityName() + " ent where ent.id = " + id).getSingleResult();
        E e = (E) o;
        session.close();

        return e;
    }

    @Override
    public void delete(Serializable id) {
        Session session = factory.openSession();

        session.beginTransaction();

        session.createQuery("delete " + getEntityName() + " entity where entity.id = " + id).executeUpdate();

        session.getTransaction().commit();

        session.close();
    }
}
