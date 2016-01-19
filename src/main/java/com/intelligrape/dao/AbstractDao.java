package com.intelligrape.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

//PK stands for Primary key
    public class AbstractDao<PK extends Serializable, T> implements CrudRepository<T,PK> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }


    @Override
    public <S extends T> S save(S s){
        getSession().save(s);
        return s;
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> ses) {
        return null;
    }

    @Override
    public T findOne(PK pk) {
        return null;
    }

    @Override
    public boolean exists(PK pk) {
        return false;
    }

    @Override
    public Iterable<T> findAll() {
        return null;
    }

    @Override
    public Iterable<T> findAll(Iterable<PK> pks) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(PK pk) {

    }

    @Override
    public void delete(Iterable<? extends T> ts) {

    }

    @Override
    public void deleteAll() {

    }

    @Autowired
    public SessionFactory sessionFactory;

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }

//    public void save(T entity) {
//        getSession().save(entity);
//    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }
}
