package service;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrey on 20.01.2019.
 */
public class ServiceRepository {
    @Getter
    private static final ServiceRepository INSTANCE = new ServiceRepository();

    private Map<Class, Object> services = new HashMap<>();

    public ServiceRepository(){
    register(new HibernateService());
    register(new CrudRepositoryService());
    }

    private void register(Object service){
    services.put(service.getClass(), service);
    }

    public  <T> T getService(Class<T> tClass){
    return (T)services.get(tClass);
    }
}
