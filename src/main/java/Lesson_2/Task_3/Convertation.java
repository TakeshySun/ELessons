package Lesson_2.Task_3;

public class Convertation {
    public static void main(String[] args) {
        KelvinConverter c = new KelvinConverter();
        FahrenheitConverter f = new FahrenheitConverter();

        c.convert(86);
        System.out.println(c.getC());
        f.convert(30);
        System.out.println(f.getF());
        System.out.println("-------");
        c.convert(-459.67);
        System.out.println(c.getC());
        f.convert(-273.15);
        System.out.println(f.getF());
    }
}
