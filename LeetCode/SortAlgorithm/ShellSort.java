/*
 * @author yangjiewei
 * @date 2020/6/14 11:33
 */
package ShangGuiGu.sort;

/**
 *  平均时间复杂度为O（n^1.3） 最差O(N^2) 最好情况下的时间复杂度为O（n）
 *  分组 + 冒泡
 * 希尔排序  :  缩小增量排序 ,增量减至1时,算法终止
 * shell sort :
 *      希尔排序是在插入排序的基础进行改进的,
 *      插入排序需要不断后移元素,效率较低,
 *      插入时可以  直接交换元素(冒泡)8s / 移动元素(插入排序)46ms
 *
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {10,9,8,7,6};
        shellSort3(a);

//        int[] a = new int[80000];
//        for (int i = 0; i < 80000 ; i++) {
//            a[i] = (int) (Math.random() * 8000000);
//        }
//
//        long startTime=System.currentTimeMillis();
//        shellSort2(a);
//        long endTime=System.currentTimeMillis();
//        float excTime=(float)(endTime-startTime)/1000;
//        System.out.println("8w个元素冒泡排序执行时间："+excTime+"s");
    }
    public static void shellSort(int[] a ){
        int temp = 0;
        // 插入时直接交换元素
        for (int gap = a.length/2;gap > 0;gap /= 2){
            for (int i = gap;i<a.length;i++){
                for (int j = i - gap;j>=0;j -= gap){
                    if (a[j] > a[j+gap]){
                        temp = a[j];
                        a[j] = a[j+gap];
                        a[j+gap] = temp;
                    }
                }
            }
        }
//        for (int i : a) {
//            System.out.print(i + " ");
//        }
    }

    public static void shellSort2(int[] a ){
        int temp = 0;
        int j = 0;
        // 插入时直接移动元素
        for (int gap = a.length/2;gap > 0;gap /= 2){
            for (int i = gap;i<a.length;i++){
                j = i;
                temp = a[j];
                if (a[j] < a[j-gap]){
                    while(j-gap >= 0 && temp < a[j-gap]){
                        a[j] = a[j-gap];
                        j -= gap;
                    }
                    a[j] = temp;
                }
            }
        }
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
//-----------------------------------------------------------------------

    public static void shellSort3(int[] a){
        int temp = 0;
        int insertVal = 0;
        int insertIndex = 0;
        for (int gap = a.length / 2; gap > 0 ; gap /= 2) { // 步长
            for (int i = gap;i<a.length;i++){
                insertVal = a[i];
                int j = i;
                if (a[j] < a[j-gap]){
                    while(j-gap>=0 && insertVal < a[ j-gap] ){
                        a[ j ] = a[j -gap];
                         j -= gap;
                    }
                    a[j] = insertVal;
                }
            }
        }

        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
