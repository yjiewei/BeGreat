/*
 * @author yangjiewei
 * @date 2020/7/3 11:25
 */
package ShangGuiGu.search;

import java.util.ArrayList;
import java.util.List;

// 必须有序 插值查找算法  数据量大、分布均匀的查找就比较快  索引和值的一种平衡
public class InsertSearch {
    public static void main(String[] args) {
        int[] a = new int[1000000];
        for(int i = 0;i<1000000;i++){
            a[i] = i+1;
        }
        List<Integer> list = insertSearch(a, 0, a.length - 1, 1000);
        System.out.println("the index is "+list.toString());
    }
    private static List<Integer> insertSearch(int[] a, int left, int right, int value) {
        // 当left> right说明没找到 left==right 这种情况要找
        if (left > right || value < a[0] || value > a[a.length-1]){
            return new ArrayList<Integer>();
        }
        // 数组值一样的话会报错 by zero
        int mid = left + (right - left)*(value - a[left])/(a[right] - a[left]);
        // 存在栈溢出 越界 情况
        int midVal = a[mid];
        if (value > midVal){
            return insertSearch(a, mid + 1, right, value);
        }else if (value < midVal){
            return insertSearch(a,left,mid-1,value);
        }else{
            List<Integer> list = new ArrayList<Integer>();
            // 向左扫描，把相同值的下标放到集合里面去
            int temp = mid - 1;
            while(true){
                if (temp < 0 || a[temp]!=value){
                    break;
                }
                // 找到
                list.add(temp);
                temp -= 1;// temp 左移
            }
            list.add(mid);
            // 向右扫描，把相同值的下标放到集合里面去
            temp = mid + 1;
            while(true){
                if (temp > a.length || a[temp]!=value){
                    break;
                }
                // 找到
                list.add(temp);
                temp += 1;// temp 左移
            }
            return list;
        }
    }
}
