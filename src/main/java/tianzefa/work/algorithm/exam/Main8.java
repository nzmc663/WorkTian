package tianzefa.work.algorithm.exam;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main8 {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        for (int i=0;i<10000000;i++){
            isOdd(new SecureRandom().nextInt(10000000));
        }
        System.out.println(System.currentTimeMillis()-time);



    }

    private static boolean isOdd(int num){
        return num % 2 != 0;
    }

    private static boolean isOdd2(int num){
        return (num & 1) == 1;
    }












}
