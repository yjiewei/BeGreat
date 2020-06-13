/*
 * @author yangjiewei
 * @date 2020/6/13 21:57
 */
package ShangGuiGu.sort;

/**
 * 数组第二个开始插入,从小到大,从最后一个开始比较
 * 插入位置不能小于0,最大只能插入第一个,同时值小的话往前遍历,否则直接插入
 * 时间复杂度为 O(N^(1-2))
 * 空间复杂度为 O(1)
 *
 * 80000个元素只需要 1s
 */
public class InsertSort {
    public static void main(String[] args) {

        // test  80000个数据排序要多久呢  700ms
        int[] a = new int[80000];
        for (int i = 0; i < 80000; i++) {
            a[i] = (int) (Math.random() * 8000000);
        }

        long startTime=System.currentTimeMillis();
        insertSort(a);
        long endTime=System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("8w个元素插入排序执行时间："+excTime+"s");
    }

    public static void insertSort(int[] arr){
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1; // last one's index
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex -= 1;
            }
            if (insertIndex+1 != i){
                arr[insertIndex+1] = insertVal;
            }
        }
//        System.out.println("插入排序后:");
//        for (int i : arr) {
//            System.out.print(i+" ");
//        }
    }
}
