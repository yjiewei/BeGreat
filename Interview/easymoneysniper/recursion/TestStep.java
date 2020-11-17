/*
 * @author yangjiewei
 * @date 2020/11/17 11:09
 */
package interview.recursion;

/**
 * 上n级台阶 每次一步或者两步 共有多少种走法  2^n
 * 这是一种从顶向下的解法
 */
public class TestStep {
    public static void main(String[] args) {
        System.out.println("5级楼梯：" + f(5));
    }

    public static int f(int n){
        if (n < 1){
            System.out.println("ntmd 没楼梯我怎么走嘛");
        }
        if (n == 1 || n == 2) return n;

        return f(n - 1)+ f(n - 2);
    }
}

