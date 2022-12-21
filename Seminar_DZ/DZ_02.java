package Seminar_DZ;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Задание 1. Создать словарь HashMap. Обобщение <Integer, String>
 * Задание 2. Заполнить пятью ключами (индекс, ФИО+Возраст+Пол "Иванов Иван Иванович 28 м"), добавить ключь, если не было!)
 * Задание 3. Изменить значения сделав пол большой буквой.
 * Задание 4. Пройти по коллекции и вывести значения в формате Фамилия инициалы "Иванов И.И."
 * Задание 5. *Сортировать значения по возрасту и вывести отсортированную коллекция как в четвёртом пункте.
 */
public class DZ_02 {

    public static void main(String[] args) {
        // Задание 1.
        HashMap<Integer, String> person = new HashMap<>();
        // Задание 2.
        person.put(0, "Иванов Иван Иванович 35 м");
        person.put(1, "Петров Петр Петрович 28 м");
        person.put(2, "Сидоров Сидр Сидрович 40 м");
        person.put(3, "Зуева Марина Викторовна 24 ж");
        person.put(4, "Комова Светлана Петровна 32 ж");
        person.merge(4, "Комова Юлия Петровна 32 ж", (v1, v2) -> v2);
        
        System.out.println("***** Задание 2 *****");
        person.forEach((k, v) -> System.out.println(v));

        // Задание 3.
        System.out.println();
        System.out.println("***** Задание 3 *****");

        person.forEach((k, v) -> System.out.println(
            v.split(" ")[0] + " "
            + v.split(" ")[1] + " "
            + v.split(" ")[2] + " "
            + v.split(" ")[3] + " "
            + v.split(" ")[4].toUpperCase()));

        // Задание 4.
        System.out.println();
        System.out.println("***** Задание 4 *****");
        
        person.forEach((k, v) -> System.out.println(
            v.split(" ")[0] + " "
            + v.split(" ")[1].charAt(0) + "."
            + v.split(" ")[2].charAt(0) + "."));

        // Задание 5.
        System.out.println();
        System.out.println("***** Задание 5 *****");

        List<Map.Entry<Integer,String>> list = new LinkedList<Map.Entry<Integer,String>>(person.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer,String>> () {
            public int compare(Map.Entry<Integer,String> o1, Map.Entry<Integer,String> o2) {
                return o1.getValue().split(" ")[3].compareTo(o2.getValue().split(" ")[3]);
            }
        });

        HashMap<Integer,String> sortedPerson = new LinkedHashMap<Integer,String>();
        for (java.util.Map.Entry<Integer, String> entry : list) {
            sortedPerson.put(entry.getKey(), entry.getValue());
        }

        sortedPerson.forEach((k, v) -> System.out.println(
            v.split(" ")[0] + " "
            + v.split(" ")[1].charAt(0) + "."
            + v.split(" ")[2].charAt(0) + ". Age:"
            + v.split(" ")[3]));       
    }
}
