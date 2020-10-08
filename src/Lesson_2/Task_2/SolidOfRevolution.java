package Lesson_2.Task_2;

public class SolidOfRevolution extends Shape{
    double radius;

    SolidOfRevolution(double volume, double radius) {
        super(volume);
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }
}
