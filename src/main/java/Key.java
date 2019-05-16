import java.math.BigInteger;
import java.util.Map;

public class Key  {

    private int key; //Ключ
    private int p; //Текущая степень
    private int q;//Следующая степень

    //Степень в которую переводим не задана
    public Key(int key, int p) {
        this.key = key;
        this.p = p;
        this.q = 0;
    }

    //Степень в которую переводим задана
    public Key(int key, int p, int q) {
        this.key = key;
        this.p = p;
        if(q<=10 && q>0)
            this.q = q;
        else this.q=10;
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

        //Если степень не задана, то переводим в степень p+1
      if(q == 0){
          //Переводим в 10тичную систему
          int temp = To10System(p);
          //Переводим из 10 в систему p+1
          return From10ToAny(temp, p+1);
      }
      else{ //Если степень задана
          int temp = To10System(p);
          //Переводим из 10 в систему p+1
          return From10ToAny(temp, q);
      }




    }
}
