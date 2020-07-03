/*
 * @author yangjiewei
 * @date 2020/7/2 21:53
 */
package ShangGuiGu.search;

public class SeqSearch {
    public static void main(String[] args) {
        int[] a = {1,-9,-20,0,14};
        int index = seqSearch(a,-9);
        if (index == -1){
            System.out.println("I can't find it.");
        }else{
            System.out.println("the index is "+index);
        }
    }

    public static int seqSearch(int[] a,int value){
        // 线性查找是逐一比对，发现相同的返回下标值
        for (int i = 0; i < a.length; i++) {
            if (a[i] == value ){
                return i;
            }
        }
        return -1;
    }
}
