package tianzefa.work.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 插入排序
 *
 * @author tzf
 */
public class InsertSort {

    private static final int[] arr = new int[]
            {50, 93, 33, 48, 11, 42, 8, 75, 74, 29, 79, 19, 77, 16, 72, 20, 41, 3, 27, 64};

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(sort(arr)));
    }

    /**
     * 排序
     */
    public static int[] sort(int[] arr) {
        return insertSort(arr);
    }

    /**
     * 插入排序
     */
    private static int[] insertSort(int[] arr){
        for (int i = 1;i < arr.length; i++){
            int tempValue = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>tempValue){ //如果对比的值大于我,则将对比的值往右移动一位。
                arr[j+1] = arr[j];
                j--;
            }
            //对比的值小于我,或者已经没有值了,此时将我保存在指针的下一个。
            arr[j+1] = tempValue;
        }
        return arr;
    }

}
