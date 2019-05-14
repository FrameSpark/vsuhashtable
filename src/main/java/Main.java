import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Key<Integer,Student>> hashTable = new HashMap<Key>();
        hashTable.put(new Key(1010), new Student("Gennadiy",123));
        hashTable.put(new Key(11100), new Student("Vasili",5664));
        hashTable.put(new Key(1010), new Student("Sergey", 113));

        Set set =  hashTable.keySet();
        Iterator<Key> iterator = set.iterator();
        Key key;
        while (iterator.hasNext()){
            key = iterator.next();
            System.out.println(key.getValue()+ "   hash:" + key.getKey());
        }
    }
}
