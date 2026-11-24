package org.example;
import java.util.List;
public class DeviceService {
    private DeviceRepository repository;

    public DeviceService(DeviceRepository repository) {
        this.repository = repository;

    }

    public String registerDevice(Device device) {
        if (device.getName().isEmpty() || device.getID().isEmpty()) {
            return "EMPTY_FIELD";

        }
       if (!device.getType().equalsIgnoreCase("RFID") &&
               !device.getType().equalsIgnoreCase("IO") &&
               !device.getType().equalsIgnoreCase("CAMERA")){
           return "INVALID_TYPE";
       }
        for (Device existingDevice : repository.findAll()) {
            if (device.getID().equalsIgnoreCase(existingDevice.getID())){
                return "DUPLICATE_ID";
        }

    }repository.save(device);
        return "DEVICE_ADDED";
}public List<Device> getAllDevices(){
        return repository.findAll();
    }
    public List<Device> searchDevices(String id){
    return repository.findById(id);
    }
}
