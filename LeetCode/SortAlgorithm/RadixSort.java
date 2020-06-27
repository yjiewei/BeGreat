/*
 * @author yangjiewei
 * @date 2020/6/27 17:25
 */
package ShangGuiGu.sort;

import java.util.Arrays;

/**
 * 基数排序：稳定排序
 *     1.定义一个二维数组，来分配10个桶 0~9 桶是一维数组 桶的大小为a.length
 *     2.将每个元素的个/十/百...位数取出，对应哪个桶就把元素放在桶里面
 *     3.按照这个桶的顺序（一维数组的下标取出数据，放在原来的数组）
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        radixSort(arr);

//        int[] arr = new int[80000];
//        int[] temp = new int[arr.length];
//        for (int i = 0; i < 80000 ; i++) {
//            arr[i] = (int) (Math.random() * 8000000);
//        }
//
//        long startTime=System.currentTimeMillis();
//        radixSort(arr);
//        long endTime=System.currentTimeMillis();
//        float excTime=(float)(endTime-startTime)/1000;
//        System.out.println("8w个元素基数排序执行时间："+excTime+"s");

    }

    // 基数排序方法  以空间换时间
    //
    public static void radixSort(int[] arr){

        // 如何得到数组中最大的位数
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >max){
                max = arr[i];
            }
        }
        // 得到最大位数是几位数
        int maxLength = (max+"").length();

        int[][] bucket = new int[10][arr.length];
        // 用一个数组来记录每个桶存放的数据个数
        int[] bucketElementCounts = new int[10];


        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < arr.length; j++) {
                // 个位数
                int digitOfElement =(int) (arr[j] /Math.pow(10,i) %10);  //   /10%10  /100%10  不能排负数
                // 放入对应的桶，并且记录个数也完成
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;// 这个位置的+1了
            }
            // 按照这个桶的顺序（一维数组的下标取出数据，放在原来的数组）
            int index = 0;
            // 遍历每一桶，取数据放回原来的桶
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中有数据，才放回原数组
                if (bucketElementCounts[k] != 0){
                    // 有数据循环该桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素放回arr
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                bucketElementCounts[k] = 0;
            }
            System.out.println("arr=" + Arrays.toString(arr));
        }
    }
}
