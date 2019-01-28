package repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.HibernateService;
import service.ServiceRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Andrey on 20.01.2019.
 */
public class CrudRepository<T, K> {
    private Class<T> tClass;
    private SessionFactory sessionFactory;

    public CrudRepository(Class tClass){
        this.tClass = tClass;
        HibernateService hibernateService = ServiceRepository.getINSTANCE().getService(HibernateService.class);
        sessionFactory = hibernateService.getSessionFactory();
    }

    public Session openTransactSession(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return session;
    }

    public Session closeTransactSession(Session session){
        session.getTransaction().commit();
        session.close();
        return session;
    }

    public void createDao(T object){
    Session session = openTransactSession();
    session.save(object);
    closeTransactSession(session);
    }

    public T getDao(K id){
    Session session = sessionFactory.openSession();
    T object = session.get(tClass, (Serializable) id);
    session.close();
    return object;
    }

    public void deleteDao(T object){
        Session session = openTransactSession();
        session.delete(object);
        closeTransactSession(session);
    }

    public void updateDao(T object){
        Session session = openTransactSession();
        session.update(object);
        closeTransactSession(session);
    }

    public List<T> getList(){
        Session session = sessionFactory.openSession();
        String hql = "from " + tClass.getSimpleName();
        List<T> objects = session.createQuery(hql).list();
        session.close();
        return objects;
    }

    public T getLastDao(){
        Session session = sessionFactory.openSession();
        String hql = "from " + tClass.getSimpleName() + " ORDER BY id DESC";
        T object = (T) session.createQuery(hql).setMaxResults(1).uniqueResult();
        session.close();
        return object;
    }

}
