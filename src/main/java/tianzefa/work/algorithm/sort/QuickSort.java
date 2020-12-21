package tianzefa.work.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 快速排序
 *
 * @author tzf
 */
public class QuickSort {

    private static final int[] arr = new int[]
            {50, 93, 33, 48, 11, 42, 8, 75, 74, 29, 79, 19, 77, 16, 72, 20, 41, 3, 27, 64};

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(sort(arr)));
    }

    /**
     * 排序
     */
    public static int[] sort(int[] arr) {
        return quickSort(arr,0,arr.length-1);
    }
    /**
     * 快速排序
     */
    public static int[] quickSort(int[] array, int left, int right) {
        if (left > right) { return array;}
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }
            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
        return array;
    }
}
