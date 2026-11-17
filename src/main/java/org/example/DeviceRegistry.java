package org.example;
import java.util.ArrayList;
public class DeviceRegistry {
    private ArrayList<Device> devices = new ArrayList<>();
    /**this method is used to check the
     *device information and add the device if the information is valid*/
    public void addDevice(Device device) {

      if(device.getName().isEmpty() || device.getID().isEmpty()){
          System.out.println("Error : cannot be empty");
          return;
      }

      if(!device.getType().equalsIgnoreCase("RFID") &&
              !device.getType().equalsIgnoreCase("IO") &&
              !device.getType().equalsIgnoreCase("CAMERA"))
      {
          System.out.println("Error: Unsupported type");
          return;
      }

      for (Device existingDevice : devices) {
          if (device.getID().equalsIgnoreCase(existingDevice.getID())) {
              System.out.println("Error : ID already exists!");
              return;
          }

      }

      devices.add(device);
      System.out.println("Added successfully!");
  }
  /**This method is used to list all existing devices or
   *  display a message if no devices are found*/
public void listDevices(){
      if(devices.isEmpty()){
          System.out.println("NO DEVICES FOUND!");
      }
      else {
          for (Device device : devices) {
              System.out.println(device);
          }
      }
}
    /** This method is used to search for a device by its ID
     * If the device is found, it displays its information
     * Otherwise, it displays a message that the device was not found
     */
public void searchDevice(String id){
for (Device device : devices){
    if (id.equalsIgnoreCase(device.getID())){
        System.out.println(device);
        return;
    }
}
    System.out.println("Device not found!");
}
}
