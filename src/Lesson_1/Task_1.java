package Lesson_1;

public class Task_1 {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        sum(x, y);
        multiply(2, 5);
        subtract(3,6);
        divide(155, 5);
        remainder_of_two_numbers(10,3);
    }

    static void sum(int a, int b){
        int result;
        result = a + b;
        System.out.println(result);
    }

    static void multiply(int a, int b){
        int result;
        result = a * b;
        System.out.println(result);
    }

    static void subtract(int a, int b){
        int result;
        result = a - b;
        System.out.println(result);
    }

    static void divide (int a, int b){
        int result;
        result = a / b;
        System.out.println(result);
    }

    static void remainder_of_two_numbers (int a, int b){
        int result;
        result = a % b;
        System.out.println(result);
    }
}
