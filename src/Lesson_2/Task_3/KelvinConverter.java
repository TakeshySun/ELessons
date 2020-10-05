package Lesson_2.Task_3;
// °C = (°F -32) / 1,8  или наоборот  °F = (°C * 1,8) + 32

public class KelvinConverter implements Converter{

    @Override
    public void convert(double i) {
        double C = (i - 32) / 1.8;
        System.out.println("C: " + C);
    }
}
