package Seminar_Task;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Task_02
 * Собрать Map в котором храняться ключи ФИО и возраст
 */
public class Task_02 {

    public static void main(String[] args) {
        Map<Integer, String> fio = new TreeMap<>();
        fio.put(1, "Иванов Иван Иванович 30");
        fio.put(2, "Петров Петр Петрович 25");
        fio.put(3, "Сидоров Сидр Сидрович 35");
        System.err.println(fio);

        Set<Integer> keys = fio.keySet();
        for (Integer key : keys) {
            String tmp1 = fio.get(key).split(" ")[0];
            String tmp = tmp1.toUpperCase().charAt(0)+tmp1.toLowerCase().substring(1, tmp1.length());
            tmp1 = fio.get(key).split(" ")[1].toUpperCase().charAt(0)+".";
            tmp = tmp + " " + tmp1;
            tmp1 = fio.get(key).split(" ")[2].toUpperCase().charAt(0)+".";
            tmp = tmp + tmp1;
            System.out.println(tmp);
        }

        LinkedList<Integer> alist = new LinkedList<>();
        Collection<String> key1 = fio.values();
        for (int i = 0; i < key1.size(); i++) {
            System.out.println(key1.toArray()[i]);
            alist.add(Integer.parseInt(key1.toArray()[i].toString().split(" ")[3]));
        }
        System.out.println(alist);
    }
}
