/*
 * @author yangjiewei
 * @date 2020/6/15 19:56
 */
package ShangGuiGu.sort;

import java.util.Arrays;

/**
 * 1.将序列中待排序数字分为若干组,每个数字分为一组
 * 2.将若干个组两两合并,保证合并后的组是有序的
 * 3.重复第二步骤,直到只剩下最后一组,排序完成!
 *
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {10,9,8,7,6,5,4,3,2,1};
        int[] temp = new int[a.length];
        mergeSort(a,0,a.length-1,temp);

        System.out.println("归并排序后:"+ Arrays.toString(a));
    }

    /**
     *  分+治
     *  这一步是分数组然后调用合并方法
     * @param a
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] a ,int left,int right,int[] temp){
        if (left < right){
            int middle = (left + right)/2; // 中间索引
            // 向左递归进行分解
            mergeSort(a,left,middle,temp);
            // 向右递归进行分解
            mergeSort(a,middle+1,right,temp);

            // 合并  合并次数为length-1
            merge(a,left,middle,right,temp);
        }
    }

    /**
     *  合并  合并  合并
     *  归并排序算法 : 合并数组下标为left到middle,
     *                以及下标为middle+1到right的两个部分
     * @param a  待排序数组
     * @param left  左边有序序列的初始索引
     * @param middle 中间索引
     * @param right  右边索引
     * @param temp   中转数组
     */
    public static void merge(int[] a ,int left,int middle,int right,int[] temp){
        int i = left; // 左边有序序列的初始索引
        int j = middle + 1; //右边有序序列的初始索引
        int t = 0; // 指向temp数组的当前索引


        // 第一步:
        // 先把左右两边有序的数据按照规则填充到temp数组
        // 直到左右两边的有序序列,有一边处理完毕为止
        while(i <= middle && j <= right){  //还没走到数组末尾(已分为两段),还得继续
            // 如果左边的有序序列的当前元素,小于等于 右边有序序列的当前元素
            // 就把左边的当前元素 拷贝到temp数组 然后 i++,t++
            if (a[i] <= a[j]){
                temp[t] = a[i];
                t += 1;
                i += 1;
            }else{ // 右边的元素比较小,右边元素填充
                temp[t] = a[j];
                t += 1;
                j += 1;
            }
        }


        // 第二步:
        // 把有剩余数据的一方的数据依次全部填充到temp
        while( i <= middle){ // 左边的有序序列还有剩余的元素,就全部填充到temp
            //
            temp[t] = a[i];
            t++;
            i++;
        }
        while( j <= right){ // 右边的有序序列还有剩余的元素,就全部填充到temp
            temp[t] = a[j];
            t++;
            j++;
        }



        // 第三步:
        // 将temp数组的元素拷贝到数组
        // 不是每次都拷贝所有 只拷贝当前的数组中的
        // 最后一次是 left = 0  ,  right = a.length-1
        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            a[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
