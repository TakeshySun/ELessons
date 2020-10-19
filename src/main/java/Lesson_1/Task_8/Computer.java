package Lesson_1.Task_8;
/*
Design such Java class with name Computer and such properties as:
- Brand
- Screen size
- Number of cores
-Type (laptop,desktop,etc.)

Make `Brand` and `Screen size` properties required in order to create an object(instance).
Create two auxiliary object of Computer class. 
 */
public class Computer {
    String brand = "MS";
    String screenSize = "640x480";
    int coreNumber;
    String type;

    public Computer(String brand, int x, int y){
        this.brand = brand;
        setScreenSize(x, y);
    }

    public Computer(){};

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int x, int y) {
        this.screenSize = String.format("%s" + "x" + "%s", x, y);
    }

    public int getCoreNumber() {
        return coreNumber;
    }

    public void setCoreNumber(int coreNumber) {
        this.coreNumber = coreNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void getPcSettings(){
        System.out.println("___________________________");
        System.out.println("Brand is: " + getBrand());
        System.out.println("Screen size is: " + getScreenSize());
        if (getCoreNumber() != 0){
            System.out.println("Core Number is: " + getCoreNumber());
        }
        if (getType() != null){
            System.out.println("Type is: " + getType());
        }
        System.out.println("___________________________");
    }

}
