/*
 * @author yangjiewei
 * @date 2020/7/3 22:16
 */
package ShangGuiGu.search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] a = {1,2,3,7,8,30,45,100,1000,2000,2000};
        int index = fibSearch(a, 2000);
        System.out.println(index);
    }

    // 因为后面我们mid = low + F(k-1)-1,需要使用到斐波那契数列
    // 因此先造一个斐波那契数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    /**
     *  编写斐波那契查找算法
     *  非递归的方式
     * @param a
     * @param value
     * @return  返回对应的下标哦，没有返回-1
     */
    public static int fibSearch(int[] a,int value){
        int low = 0;
        int high = a.length - 1;
        int k = 0; // 表示斐波那契分割数值下标
        int mid = 0; // 存放mid值
        int[] f = fib(); // 获得数列
        // 获得斐波那契分割数值下标
        while(high > f[k] - 1){
            k++;
        }
        // 因为f(k) 的值可能大于 a 的长度
        // 因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
        // 复制指定的数组，截断或填充零（如果必要）所以副本具有指定的长度。
        int[] temp = Arrays.copyOf(a,f[k]);
        // 实际上需要使用a数组的最后的数填充temp
        for (int i = high+1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        // 使用while来循环处理，找到我们的key
        while(low <= high){
            mid = low + f[k-1] -1;
            if (value < temp[mid]){
                high = mid - 1;
                // k--
                k--;
            }else if (value > temp[mid]){
                low = mid + 1;
                k -= 2;
            }else {
                // 找到
                if (mid <= a.length-1){
                    return mid;
                }else{
                    return a.length-1;
                }
            }
        }
        return -1;
    }
}











