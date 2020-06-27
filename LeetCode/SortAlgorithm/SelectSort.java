/*
 * @author yangjiewei
 * @date 2020/6/13 21:27
 */
package ShangGuiGu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 选择排序 找到最小值或者最大值的时候才交换
 *
 * 不稳定排序
 * e.g. 举个例子，序列5 8 5 2 9，我们知道第一遍选择第1个元素5会和2交换，
 *      那么原序列中两个5的相对前后顺序就被破坏了，所以选择排序是一个不稳定的排序算法。
 *
 * 时间复杂度O(n^2)
 * 空间复杂度O(1)
 * 时间比冒泡短 好多!!!! 循环内的操作不一样
 * 选择使用的时临时变量,冒泡是直接数组内操作
 */
public class SelectSort {
    public static void main(String[] args) {

        // test  80000个数据排序要多久呢  3s
        int[] a = new int[80000];
        for (int i = 0; i < 80000; i++) {
            a[i] = (int) (Math.random() * 8000000);
        }

        long startTime=System.currentTimeMillis();
        selectSort(a);
        long endTime=System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("8w个元素选择排序执行时间："+excTime+"s");
    }

    public static void selectSort(int[] a){
        // 每次循环找到最小值,更改记录的最小值
        for (int i = 0; i < a.length-1; i++) {
            int k = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[k] > a[j]){
                    k = j;
                }
            }
            if (a[k] != a[i]){
                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
            }
        }
//        for (int i : a) {
//            System.out.print(i+" ");
//        }
    }
}
