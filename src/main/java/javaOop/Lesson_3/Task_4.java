package javaOop.Lesson_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/*
Створити String масив з замовленнями (з дублюючими замовленнями), які прийшли в інтернет магазин.
Створити два види колекцій HashSet та TreeSet, в які потрібно добавлятись наші замовлення.
Вевести на екран список з HashSet та з TreeSet окремо один від одного.
 */
public class Task_4 {
    public static void main(String[] args) {
        String[] orders = {"Order 1", "Order 2", "Order 3", "Order 4", "Order 5", "Order 2", "Order 4"};
        HashSet<String> hashOrder = new HashSet<>(Arrays.asList(orders));
        System.out.println(hashOrder);
//Another Implementation
        TreeSet<String> treeOrder = new TreeSet<>();
        for (int i =0; i< orders.length; i++) {
            treeOrder.add(orders[i]);
        }
        System.out.println(treeOrder);
    }
}
