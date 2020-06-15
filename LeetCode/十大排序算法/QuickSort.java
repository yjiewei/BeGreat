/*
 * @author yangjiewei
 * @date 2020/6/14 23:59
 */
package ShangGuiGu.sort;
// 目前最难  最优的情况下(每次基准值都是中间值)，快速排序算法的时间复杂度为O(nlogn)  最差:已经有序 需要O(N^2)  用树来分析
//                     树的深度是logn 每次处理要n时间
//  算法描述:
//      1.选择最左端为基准 pivot
//      2.从右边开始找 比pivot大的值,因为第一个已经空出来了
//      3.从左边开始找 比pivot小的值
// 8w 23ms
// 80w 259ms
public class QuickSort {
    public static void main(String[] args) {
//        int[] a = {-9,78,0,23,-567,70};
//        quickSort(a,0,a.length-1);
//
//        for (int i : a) {
//            System.out.print(" " + i);
//        }

        int[] a = new int[80000];
        for (int i = 0; i < 80000 ; i++) {
            a[i] = (int) (Math.random() * 8000000);
        }

        long startTime=System.currentTimeMillis();
        quickSort(a,0,a.length-1);
        long endTime=System.currentTimeMillis();
        float excTime=(float)(endTime-startTime)/1000;
        System.out.println("8w个元素冒泡排序执行时间："+excTime+"s");
    }

    /**
     *  基准pivot是最左边的值
     * @param a 数组
     * @param L 最左
     * @param R 最右
     */
    public static void quickSort(int[] a,int L,int R) {
        // 左右重叠说明只剩下一个元素
        if (L >= R) return;
        int left = L;
        int right = R;
        int pivot = a[left]; //基准为最左值
        while (left < right) { // 排序元素大于1
            while (left < right && a[right] >= pivot) {  // 右边的是要找到小的
                right--;
            }

            if (left < right) { // 找到了右边比pivot小的值
                // 赋值给左节点,然后这里就可以当做是空位置了.此时还未移动左节点,左节点的值前面已经记录,也就是pivot
                a[left] = a[right];
            }

            while (left < right && a[left] <= pivot) {  // 左边的要找到比基准大的
                left++;
            }

            if (left < right) {
                a[right] = a[left];  // 把找到的大于基准的值 -->  刚才右边的空位置
            }

            if (left >= right) {
                a[left] = pivot;     //  找不到或者交换完了,就把pivot放到空位置
            }
        }
        quickSort(a,L,right-1); // 左边的进行递归排序
        quickSort(a,right+1,R); // 右边的进行递归排序
    }

}
