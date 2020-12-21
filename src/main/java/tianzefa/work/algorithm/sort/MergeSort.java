package tianzefa.work.algorithm.sort;

import com.alibaba.fastjson.JSON;

/**
 * 归并排序
 *
 * @author tzf
 */
public class MergeSort {

    private static final int[] arr = new int[]
            {50, 93, 33, 48, 11, 42, 8, 75, 74, 29, 79, 19, 77, 16, 72, 20, 41, 3, 27, 64};

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(sort(arr)));
    }

    /**
     * 排序
     */
    public static int[] sort(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 归并排序
     */
    private static int[] mergeSort(int[] arr, int low, int hight) {
        int mid = (low+hight)/2;
        if (low<hight){
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,hight);
            merge(arr,low,mid,hight);
        }
        return arr;
    }

    private static void merge(int[] arr,int low,int mid,int hight){
        int[] temp = new int[hight-low+1];
        int i=low,j=mid+1,k=0;
        while(i<=mid && j<=hight){
            temp[k++] = arr[i]<arr[j]?arr[i++]:arr[j++];
        }
        while (i<=mid){
            temp[k++] = arr[i++];
        }
        while (j<=hight){
            temp[k++] =arr[j++];
        }
        for (int x=0;x<temp.length;x++){
            arr[x+low] = temp[x];
        }
    }


}
