package org.test.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.test.monitor.dao.Dao;
import org.test.monitor.dao.DaoImpl.ServiceDao;
import org.test.monitor.domain.Service;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);

       // Service service = getService(1);
       // System.out.println(service);
       // updateService(service, new String[]{"192.168.2.1", "8090"});
        saveService(new Service("192.168.2.2", "8080"));
     //   deleteService(getService(2));
        getAllServices().forEach(user -> System.out.println(user.getHost()));

    }

    private static Dao<Service> serviceDao = new ServiceDao();

    public static Service getService(long id) {
        Optional<Service> service = serviceDao.get(id);

        return service.orElseGet(
                () -> new Service("no host", "no port"));
    }

    public static List<Service> getAllServices() {
        return serviceDao.getAll();
    }

    public static void updateService(Service service, String[] params) {
        serviceDao.update(service, params);
    }

    public static void saveService(Service service) {
        serviceDao.save(service);
    }

    public static void deleteService(Service service) {
        serviceDao.delete(service);
    }


}

