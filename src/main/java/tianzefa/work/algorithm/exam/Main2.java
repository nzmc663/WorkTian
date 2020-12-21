package tianzefa.work.algorithm.exam;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String nums = sc.next();
            int counts = sc.nextInt();
            String[] arr = nums.split(",");
            int value = -1;
            int l = 0;
            int h = 1;
            while (h < arr.length || l < arr.length) {
                int count = sum(arr,l,h);
                if (count == counts) {
                    if (value < (h - l)) value = h - l;
                    if (h == arr.length) break;
                    if (h < arr.length) {
                        h++;
                        continue;
                    }
                    if (l < arr.length) {
                        l++;
                        continue;
                    }
                }
                if (count < counts) {
                    if (h == arr.length) {
                        break;
                    }
                    h++;
                }
                if (count > counts) l++;
            }
            System.out.println(value);
        }

    }

    private static int sum(String[] arr,int l,int h){
        int count = 0;
        for (;l<h;l++){
            count += Integer.valueOf(arr[l]);
        }
        return count;
    }


}
