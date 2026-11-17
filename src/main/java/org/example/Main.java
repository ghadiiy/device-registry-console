package org.example;

import java.util.Scanner;

public class Main {
  public static void main(String[] args){
      Scanner scanner =new Scanner(System.in);
    DeviceRegistry registry = new DeviceRegistry();
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
                String Name = scanner.nextLine();
                System.out.print("Enter Device Type:");
                String Type = scanner.nextLine();
                Device addDevice = new Device(id, Name, Type);
                registry.addDevice(addDevice);
                break;
            case 2:
                registry.listDevices();
                break;
            case 3:
                System.out.print("Enter ID: ");
                String searchId = scanner.nextLine();
                registry.searchDevice(searchId);
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