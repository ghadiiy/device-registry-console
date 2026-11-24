package org.example;
import java.util.ArrayList;
import java.util.List;

public class InMemoryDeviceRepository implements DeviceRepository {

    private ArrayList<Device> devices = new ArrayList<>();

    @Override
    public void save(Device device) {
        devices.add(device);
    }

    @Override
    public List<Device> findAll() {
        return devices;
    }

    @Override
    public List<Device> findById(String id) {
        List<Device> result = new ArrayList<>();

        for (Device device : devices) {
            if (device.getID().toLowerCase().contains(id.toLowerCase())) {
                result.add(device);
            }
        }

        return result;
    }
}