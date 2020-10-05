package Lesson_2.Task_3;
// °C = (°F -32) / 1,8  или наоборот  °F = (°C * 1,8) + 32

public class FahrenheitConverter implements Converter {

    @Override
    public void convert(double i) {
        double F = (i * 1.8) + 32;
        System.out.println("F: " + F);
    }
}
