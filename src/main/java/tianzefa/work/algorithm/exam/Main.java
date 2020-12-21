package tianzefa.work.algorithm.exam;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int count = sc.nextInt();
            while(count%2==0){

            }
            int newCount = tableSizeFor(count);
            if (count==newCount){
                System.out.println(isTwo(count));
            }
            int num2 = newCount - (newCount - newCount/2)/2;
            if (count<num2){
                System.out.println(isTwo(newCount/2));
            } else {
                System.out.println(isTwo(newCount));
            }
        }
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1000000000) ? 1000000000 : n + 1;
    }

    private static int isTwo(int i){
        int num = 1;
        int count = 1;
        while(num!=i){
            num = num * 2;
            count++;
        }
        return count;
    }
}
