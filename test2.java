import java.util.Random;

public class test2 {
    public static void main(String[] args){
        Random randPos = new Random();
        int temp =randPos.nextInt(10 + 1) + 1;
        System.out.println(temp);
    }
    
}
