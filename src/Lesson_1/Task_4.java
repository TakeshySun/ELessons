package Lesson_1;

/*
 * Write a Java program to concatenate a given string to the end of another string. And remove all `P` or `p` characters.
 *
 * Test Data:
 * String 1: PHP Exercises and
 * String 2: Python Exercises
 */

public class Task_4 {
    public static void main(String[] args) {

        String x = "PHP Exercises and";
        String y = "Python Exercises";

        System.out.println(remove(x,y));;

    }

    static String remove(String x, String y) {
        String together = x + " " + y;
//        or
        String together2 = x.concat(y);

        return together.replace("P", "");
//        return together2;
    }
}


