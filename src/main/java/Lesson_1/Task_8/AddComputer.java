package Lesson_1.Task_8;

public class AddComputer {

    public static void main(String[] args) {

        Computer hp = new Computer("HP",1080, 1024);
        hp.getPcSettings();

        Computer mac = new Computer("Mac", 2048, 1090);
        mac.setCoreNumber(14);
        mac.setType("Laptop");
        mac.getPcSettings();

        Computer ms = new Computer();
        ms.getPcSettings();
    }
}
