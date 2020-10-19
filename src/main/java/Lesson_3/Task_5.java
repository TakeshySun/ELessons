package Lesson_3;

import java.util.*;

/*
Написати метод, який принімає два масиви/списки елементів типу K, V (Generic) з однаковою/різною кількість елементів
і вертає сортований Map<K, V>.
 */
public class Task_5 {
    public static void main(String[] args) {
        List<?> keyList = Arrays.asList("Key1", "Key2", "Key3", "Key10", "Key4"); //почему key10 на втором месте выводится?
        List<?> valueList = Arrays.asList(1, 2, 10, 324, 321);
        System.out.println("==" + " " + returnOneSortedMap(keyList, valueList));

        List<?> keyListMore = Arrays.asList(1, 2, 3, 10, 8, 15);
        List<?> valueListLess = Arrays.asList(1, 2, 10, 324);
        System.out.println(">" + " " + returnOneSortedMap(keyListMore, valueListLess));
        System.out.println("Ex >" + " " + returnOneSortedMapWithExceptions(keyListMore, valueListLess));

        List<?> keyListLess = Arrays.asList(1, 5, 4);
        List<?> valueListMore = Arrays.asList(1, 2, 10, 324, 777);
        System.out.println("<" + " " + returnOneSortedMap(keyListLess, valueListMore));
        System.out.println("Ex<" + " " + returnOneSortedMapWithExceptions(keyListLess, valueListMore));
    }

    /*
    Варіант 1. Якщо масив K > V - то записати в value null, якщо масив K < V - зайві value не обробляти
     */
    public static <K, V> Map<K, V> returnOneSortedMap(List<K> key, List<V> value) {
        Map<K, V> sortedMap = new TreeMap<>();
        Iterator<K> k = key.iterator();       // В чем же их разница? ЛистИтератор наследует Итератор, но все одинаковое.
        Iterator<V> v = value.listIterator();

        if (key.size() >= value.size()) {
            while (k.hasNext()) {
                if (v.hasNext()) {
                    sortedMap.put(k.next(), v.next());
                } else sortedMap.put(k.next(), null);
            }
        } else {
            while (k.hasNext()) {
                sortedMap.put(k.next(), v.next());
            }

        }
        return sortedMap;
    }

    /*
    Варіант 2. Якщо масив K > V - перехватит помилку і вивести на екран повідомлення "Value is not enough for map",
    якщо масив K < V - перехватит помилку і вивести на екран повідомлення "Key is not enough for map"
     */
    public static <K, V> Map<K, V> returnOneSortedMapWithExceptions(List<K> key, List<V> value) {
        Map<K, V> sortedMap = new TreeMap<>();

        if (key.size() >= value.size()) {
            for (int i = 0; i < key.size(); i++) {
                try {
                    sortedMap.put(key.get(i), value.get(i));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Value is not enough for map");
                    break;
                }
            }
        } else {
            for (int i = 0; i < value.size(); i++) {
                try {
                    sortedMap.put(key.get(i), value.get(i));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Key is not enough for map");
                    break;
                }
            }
        }

        return sortedMap;
    }
}
