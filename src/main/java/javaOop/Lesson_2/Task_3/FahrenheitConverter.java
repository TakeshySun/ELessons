package javaOop.Lesson_2.Task_3;
// °C = (°F -32) / 1,8  или наоборот  °F = (°C * 1,8) + 32

public class FahrenheitConverter implements Converter {
    private double f = 0.0;

    public double getF() {
        return f;
    }

    public void setF(double f) {
        this.f = f;
    }

    @Override
    public void convert(double i) {
        this.f = (i * 1.8) + 32;
    }
}
