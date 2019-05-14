import java.math.BigInteger;
import java.util.Map;

public class Key  {

    private int key;
    private int p; //Текущая степень

    public Key(int key, int p) {
        this.key = key;
        this.p = p;
    }

    //Ищем наибольшую цифру в ключе для определения системы счисления
    private int getCurrentLevelNumSystem(){
       int digit;
       int k = key;
       int max = k %10;
        while (k != 0) {
            digit = k % 10;
            if(digit > max){
                max = digit;
            }
            k /= 10;
        }
        return max+1;
    }


    public Object getKey() {
        return key;
    }


    //Перевод в десятичную систему
    private int To10System(int currentStepen){
        int value = key;
        int result = 0;

        int length = (int)Math.log10( value );

        for (int i = 0; i <= length; i++) {

            int a = value % 10;
            value /= 10;

            result += a * (int)Math.pow( currentStepen, (double)i );
        }

        return result;
    }

    //Из 10 в любую
    private int From10ToAny(int value , int stepen) {


        String result = "";
        int p,q;
        while ( value % stepen > 0 || value/stepen != 0) {

             p = value / stepen;
             q = value % stepen;

            result = q + result;

            value = p;
        }

        return Integer.parseInt( result );
    }

    public int hashCode(){
        //Считаем текущую степень
        int level = getCurrentLevelNumSystem();
        if(level < 9){ //Если меньше 10 систмы

            int temp = To10System(p);
            return From10ToAny(temp, p+1);

        }
        else{
            return key;
        }
    }
}
