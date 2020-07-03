/*
 * @author yangjiewei
 * @date 2020/7/2 22:06
 */
package ShangGuiGu.search;

import java.util.ArrayList;
import java.util.List;

// 主意：二分查找有前提 必须有序 时间复杂度O(logN)
public class BinaySearch {
    public static void main(String[] args) {
        int[] a = {1,5,6,6,6,6,6,15,26};
        int index = binarySearch(a,0,a.length-1,68);
        List<Integer> list = binarySearch1(a, 0, a.length - 1, 68);
        System.out.println("the index is "+index);
        System.out.println("the index is "+list.toString());

    }
    // 只能找到一个
    public static int binarySearch(int[] a,int left,int right,int value){
        // 当left> right说明没找到 left==right 这种情况要找
        if (left > right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVal = a[mid];
        if (value > midVal){
            return binarySearch(a, mid + 1, right, value);
        }else if (value < midVal){
            return binarySearch(a,left,mid-1,value);
        }else{
            return mid;
        }
    }

    // 当有多个相同值时，要返回全部，list
    // 找到mid时，向右扫描相同值，同理向左扫描
    public static List<Integer> binarySearch1(int[] a,int left,int right,int value){
        // 当left> right说明没找到 left==right 这种情况要找
        if (left > right || value < a[0] || value > a[a.length-1]){
            return new ArrayList<Integer>();
        }
        int mid = (left+right)/2;
        int midVal = a[mid];
        if (value > midVal){
            return binarySearch1(a, mid + 1, right, value);
        }else if (value < midVal){
            return binarySearch1(a,left,mid-1,value);
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
