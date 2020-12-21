package tianzefa.work.algorithm.exam;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int count = 0;
            while (num > 1) {
                if (isTwo(num)) {
                    count = count+twoCount(num);
                    break;
                }
                while (num % 2 == 0) {
                    num = num / 2;
                    count++;
                }
                if (num>3&&((num+1)/2)%2==0) {
                    num++;
                    count++;
                } else if (num>1) {
                    num--;
                    count++;
                }
            }
            System.out.println(count);
        }

    }

    private static boolean isTwoHasOne(int i) {
        return (i+1)%2==0;
    }


    private static boolean isTwo(int i) {
        int num = 1;
        while (num < i) {
            num = num * 2;
        }
        if (num == i) return true;
        return false;
    }

    private static int twoCount(int i) {
        int num = 1;
        int count = 0;
        while (num != i) {
            num = num * 2;
            count++;
        }
        return count;
    }
}
