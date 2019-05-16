import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Создаем хеш таблицу с ключем Key и значением Student
        Map<Key,Student> hashTable = new HashMap<Key,Student>();

        //Добавляем значение ключа 1010 в системе 2 (будет преобразован в хеш в системе счисления 3)
        hashTable.put(new Key(1010,2), new Student("Gennadiy",123));
        //Добавляем значение 11100 в системе 2 и явно указываем что нужно переводит в систему 3
        hashTable.put(new Key(11100,2,3), new Student("Vasili",5664));
        hashTable.put(new Key(1010,2), new Student("Sergey", 113));

        //Берем все ключи из мапы
        Set set =  hashTable.keySet();
        //Итератор для прохода по всем ключам
        Iterator<Key> iterator = set.iterator();
        Key key;
        //Если есть следующий объект
        while (iterator.hasNext()){
            key = iterator.next();
            System.out.println(key.getKey()+ "   hash:" + key.hashCode() + " Name: " + hashTable.get(key).getName());
        }
    }
}
