import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Key,Student> hashTable = new HashMap<Key,Student>();
        hashTable.put(new Key(1010,2), new Student("Gennadiy",123));
        hashTable.put(new Key(11100,2), new Student("Vasili",5664));
        hashTable.put(new Key(1010,2), new Student("Sergey", 113));

        //Берем все ключи из мапы
        Set set =  hashTable.keySet();
        //Итератор для прохода по всем ключам
        Iterator<Key> iterator = set.iterator();
        Key key;
        //Если есть следующий объект
        while (iterator.hasNext()){
            key = iterator.next();
            System.out.println(key.getKey()+ "   hash:" + key.hashCode());
        }
    }
}
