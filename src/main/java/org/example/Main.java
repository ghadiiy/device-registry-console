package org.example;

import java.util.Scanner;
import java.util.List;
public class Main {
  public static void main(String[] args){
      Scanner scanner =new Scanner(System.in);
      InMemoryDeviceRepository deviceRepository = new InMemoryDeviceRepository();
      DeviceService service = new DeviceService(deviceRepository);
    int choice;
    do {
        System.out.println("\n Device Registry Console");
        System.out.println(" 1.Add Device");
        System.out.println(" 2.List Devices");
        System.out.println(" 3.Search For A Device");
        System.out.println(" 4.Exit");
        System.out.print(" Enter Your Choice : ");

        choice =scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Device ID: ");
                String id = scanner.nextLine();

                System.out.print("Enter Device Name:");
                String name = scanner.nextLine();

                System.out.print("Enter Device Type:");
                String type = scanner.nextLine();

                Device addDevice = new Device(id, name, type);
                String result = service.registerDevice(addDevice);

                if (result.equals("DEVICE_ADDED")) {
                    System.out.println("Added successfully");
                }
                else if (result.equals("EMPTY_FIELD")){
                    System.out.println("CANNOT BE EMPTY");}

                else if (result.equals("INVALID_TYPE")){
                    System.out.println("Error: Unsupported type , please choose (RFID,IO,CAMERA)");}

                else  if  (result.equals("DUPLICATE_ID")){
                    System.out.println("Device is already existed");}
                break;


            case 2:
                List<Device> devices = service.getAllDevices();
                if (devices.isEmpty()){
                    System.out.println("NO DEVICES FOUND!");

                }else {for(Device device : devices){
                    System.out.println("ID:" + device.getID()+
                          "| TYPE: " + device.getType()+
                           "| NAME:" + device.getName());}
                }
                break;
            case 3:
                System.out.print("Enter ID to search: ");
                String searchId = scanner.nextLine();

                List<Device> searchResults = service.searchDevices(searchId);

                if (searchResults.isEmpty()){
                    System.out.println("NO DEVICES FOUND!");
                }else { for (Device device : searchResults){
                    System.out.println("ID:" + device.getID()+
                            "| TYPE: " + device.getType()+
                            "| NAME:" + device.getName());}
                }
                break;
            case 4:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice! Please choose between 1 and 4.");

        }
    }while (choice != 4);
  }
}