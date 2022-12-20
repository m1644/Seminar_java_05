package Seminar_Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Task_01 (Map, HashMap, LinkedHashMap, TreeMap)
 */
public class Task_01 {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "zero");
        map.put(null, null);
        map.put(1, null);
        System.out.println(map);  // {0=zero, null=null, 1=null}
        map.forEach((k, v) -> System.out.println(" "+k+"="+v+" "));  // 

        String tmp = map.get(2);
        tmp = map.getOrDefault(2, "default");  // если нет, выводит "default"
        System.out.println(tmp);
        
        Set<Integer> kset4 = map.keySet();
        System.out.println(kset4);  // [0, null, 1]

        Set<Map.Entry<Integer,String>> eset = map.entrySet();
        System.out.println(eset);  // [0=zero, null=null, 1=null]

        // map.remove(1);  // удаляет по ключу
        // System.out.println(map);

        if (map.containsKey(1)) map.remove(1);  // ищет по ключу и удаляет
        System.out.println(map);

        if (map.containsValue("one")) {
            System.out.println("True");
        } else System.out.println("False");

        System.out.println(map.size());  // 2
        System.out.println(map.isEmpty());  // false

        map.putIfAbsent(1, "one");  // добавляет, если нет такого ключа
        System.out.println(map);  // {0=zero, null=null, 1=one}

        map.replace(null, "tmp");
        System.out.println(map);  // {0=zero, null=tmp, 1=one}

        Collection<String> vol = map.values();
        System.out.println(vol);  // [zero, tmp, one]

        map.clear();  // очищает map
        System.out.println(map);  // {}

        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        System.out.println(map);  // {0=zero, 1=one, 2=two}

        map.compute(1, (k, v) -> v += "!");
        //map.computeIfPresent(1, (k, v) -> v += "!");  // если есть заданный ключ
        System.out.println(map);  // {0=zero, 1=one!, 2=two}

        map.computeIfPresent(1, (k, v) -> v = v.toUpperCase());
        System.out.println(map);  // {0=zero, 1=ONE!, 2=two}

        map.computeIfAbsent(3, v -> "three");
        System.out.println(map);  // {0=zero, 1=one!, 2=two, 3=three}

        map.computeIfAbsent(4, v -> getStr());
        System.out.println(map);  // {0=zero, 1=one!, 2=two, 3=three, 4=four}

        map.remove(4);  // удалили 4 ключ
        map.merge(4, "Four", (v1, v2) -> v2);  
        // добавляет по ключу, если его нет {0=zero, 1=ONE!, 2=two, 3=three, 4=Four}
        map.merge(4, "FOUR", (v1, v2) -> v1 + " " + v2);  
        // если есть, можно заменить, добавить и т.д. {0=zero, 1=ONE!, 2=two, 3=three, 4=Four FOUR}
        System.out.println(map);
        map.merge(4, "FOUR", (v1, v2) -> null);  // удалит!!!
        System.out.println(map);  // {0=zero, 1=ONE!, 2=two, 3=three}

        Map<Integer, String> map1 = new LinkedHashMap<>();
        map1.put(0, "zero");
        map1.put(2, "two");
        map1.put(1, "one");      
        map1.merge(3, "three", (v1, v2) -> v2);
        System.out.println(map1);  // {0=zero, 2=two, 1=one, 3=three}

        Map<Integer, String> map2 = new TreeMap<>();   
        map2.put(2, "two");
        map2.put(0, "zero");
        map2.put(1, "one");      
        map2.merge(3, "three", (v1, v2) -> v2);
        System.out.println(map2);  // {0=zero, 1=one, 2=two, 3=three}

        Set<Integer> cnt = map1.keySet();
        for (int i = 0; i < cnt.size(); i++) {
            System.out.println(map1.get(cnt.toArray()[i]));
        }

    }

    private static String getStr() {
        return "four";    
    }
}
