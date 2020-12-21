package tianzefa.work.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 冒泡排序
 *
 * @author tzf
 */
public class BubbleSort {

    private static final int[] arr = new int[]
            {50, 93, 33, 48, 11, 42, 8, 75, 74, 29, 79, 19, 77, 16, 72, 20, 41, 3, 27, 64};

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(sort(arr)));
    }

    /**
     * 排序
     */
    public static int[] sort(int[] arr) {
        return bubbleSort(arr);
    }

    /**
     * 冒泡排序
     */
    public static int[] bubbleSort(int[] arr) {
        int temp;
        int size = arr.length - 1;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

}
