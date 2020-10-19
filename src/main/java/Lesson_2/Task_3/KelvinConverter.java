package Lesson_2.Task_3;
// °C = (°F -32) / 1,8  или наоборот  °F = (°C * 1,8) + 32

public class KelvinConverter implements Converter{
    double c = 0.0;

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public interface Op{

    }

    @Override
    public void convert(double i) {
        this.c = (i - 32) / 1.8;
    }
}
