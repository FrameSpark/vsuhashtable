import java.math.BigInteger;
import java.util.Map;

public class Key implements Map.Entry {

    private Student student;
    private int key;

    public Key(int key) {
        this.key = key;
    }

    //Ищем наибольшую цифру в ключе для определения системы счисления
    private int getCurrentLevelNumSystem(){
       int digit;
       int max = key %10;
        while (key != 0) {
            digit = key % 10;
            if(digit > max){
                max = digit;
            }
            key /= 10;
        }
        return max+1;
    }

    //Функция высчитывания хеша по значению
    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return this.student;
    }

    public Object setValue(Object value) {
        this.student = (Student) value;
        return student;
    }

    public int hashCode(){
        //Считаем текущую степень
        int level = getCurrentLevelNumSystem();
        if(level <= 9){ //Если меньше 10 систмы
            //Используем этот класс для преобразования в систему на степень выше
            BigInteger temp = new BigInteger(String.valueOf(key));
            String keyInString = temp.toString(level+1);
            return Integer.valueOf(keyInString);
        }
        else{
            return key;
        }
    }
}
