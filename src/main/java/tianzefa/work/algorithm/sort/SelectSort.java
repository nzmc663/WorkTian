package tianzefa.work.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 选择排序
 *
 * @author tzf
 */
public class SelectSort {

    private static final int[] arr = new int[]
            {50, 93, 33, 48, 11, 42, 8, 75, 74, 29, 79, 19, 77, 16, 72, 20, 41, 3, 27, 64};

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(sort(arr)));
    }

    /**
     * 排序
     */
    public static int[] sort(int[] arr) {
        return selectSort(arr);
    }

    /**
     * 选择排序
     */
    private static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int tempIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[tempIndex]) {
                    tempIndex = j;
                }
            }
            int tempValue = arr[i];
            arr[i] = arr[tempIndex];
            arr[tempIndex] = tempValue;
        }
        return arr;
    }

}
