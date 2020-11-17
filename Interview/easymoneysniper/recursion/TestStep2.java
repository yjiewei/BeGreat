/*
 * @author yangjiewei
 * @date 2020/11/17 11:09
 */
package interview.recursion;

/**
 * 上n级台阶 每次一步或者两步 共有多少种走法  2^n
 * 这是一种从上到下的解法，使用备忘录，每次只记住两个值即可。
 * 空间复杂度降低O(1)，时间复杂度也变为O(N)
 * 效率高，可读性差一点
 * 迭代
 */
public class TestStep2 {
    public static void main(String[] args) {
        System.out.println("5级楼梯：" + f2(5));
    }

    public static int f2(int n){
        if (n < 1){
            System.out.println("ntmd 没楼梯我怎么走嘛");
        }
        if (n == 1 || n == 2) return n;

        int one = 1;
        int two = 2;
        int sum = 0;

        for (int i = 3; i <= n; i++){
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }
}

