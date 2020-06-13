/*
 * @author yangjiewei
 * @date 2020/6/13 20:58
 */
package ShangGuiGu.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 两个元素相等，是不会再交换的  稳定排序
 * 从小到大
 * 时间复杂度:O(N^2)  空间O(1)
 * 优化:如果有一次循环,没有一个交换就直接退出
 *      通过标识变量
 *
 *  将冒泡封装成方法
 */
public class BubbleSort {
    public static void main(String[] args) {

        // test  80000个数据排序要多久呢  11s
        int[] a = new int[80000];
        for (int i = 0; i < 80000; i++) {
            a[i] = (int) (Math.random() * 8000000);
        }

        long startTime=System.currentTimeMillis();
        bubbleSort(a);
        long endTime=System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("8w个元素冒泡排序执行时间："+excTime+"s");

        // test need time
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
//        String format = simpleDateFormat.format(date);
//        System.out.println(format);
//
//        bubbleSort(a);
//        //System.out.println();
//        //System.out.println("排序后:");
//        //System.out.println(Arrays.toString(a));
//
//        Date date1 = new Date();
//        String format1 = simpleDateFormat.format(date1);
//        System.out.println(format1);
    }

    public static void bubbleSort(int[] arr) {
        // 每一次循环都会找到一个最大值放在最后
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!flag){  // 没有交换
                break;
            }else{
                flag = false;  // 重置,还得后面的交换呢
            }
        }
    }
}
