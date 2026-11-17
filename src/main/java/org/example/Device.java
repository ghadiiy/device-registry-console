package org.example;
/**This class is used to represent a device we want to add */
public class Device {
    private String ID;
    private  String Name;
    private String Type;
/**This constructor is used to set initial values for
*the device ID, name, and type*/
    public Device(String ID, String Name, String Type){
        this.ID=ID;
        this.Name=Name;
        this.Type=Type;
    }
    /**method used to return the device ID*/
    public String getID(){
        return ID;
    }
/**method used to return the device Name*/
    public String getName() {
        return Name;
    }
/**method used to return the device Type*/
    public String getType() {
        return Type;
    }
/**method used to update the device ID*/
    public void setID(String ID) {
        this.ID = ID;
    }
    /**method used to update the device Name*/
    public void setName(String name) {
        this.Name = name;
    }
    /**method used to update the device Type*/
    public void setType(String type) {
      this.Type=type;
    }
    /**method used to return device information as a String*/
    @Override
    public String toString(){
        return "Device [ID: " + ID + " , Name: " + Name + " , Type: " + Type + "]";
    }
}
