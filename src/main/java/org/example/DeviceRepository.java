package org.example;
import java.util.List;
public interface DeviceRepository {
 void save(Device device);
     List<Device> findAll();
    List <Device> findById(String id);

}

