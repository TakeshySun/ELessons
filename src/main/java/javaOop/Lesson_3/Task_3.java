package javaOop.Lesson_3;

import java.util.HashMap;
import java.util.Map;

/*
Написати метод, який принімає Map<K, V> і вертає Map,
де ключі і значення поміняні місцями.
Так як значення можуть бути не унікальними, то тип значення в Map буде вже не K, а Collection<K>:
Map<V, Collection<K>>/
 */

public class Task_3 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "2");
        System.out.println(mixKeyAndValue(map));

        Map<Integer,Integer> map2 = new HashMap<>();
        map2.put(100, 200);
        System.out.println(mixKeyAndValue(map2));
    }

    public static <K, V> Map<V, K> mixKeyAndValue(Map<? extends K,? extends V> map){
        Map<V,K> mixedMap = new HashMap<>();
        for (K key:map.keySet()) {
            V value = map.get(key);
            mixedMap.put(value, key);
        }

        return mixedMap;
    }
}
