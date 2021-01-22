#### [剑指 Offer 40. 最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)

```java
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

示例 1：
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]
 
限制：
0 <= k <= arr.length <= 10000
0 <= arr[i] <= 10000
```



**答题思路：** 

```
最常用的两个方法必须掌握，一个是利用快排的性质，一个是大根堆。
快排速度快一点但是会改变原数组结构，时间复杂度是O(n)
大根堆时间复杂度大一点但是不会改变原数组，因为维护了一个大小为k的堆，所以空间是O(k) 时间是O(Nlogk)
```



**答题代码：** 

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 1.流氓解法
        // if(k <= 0) return new int[]{};
        // Arrays.sort(arr);
        // return Arrays.copyOf(arr, k);

        // 2.使用快速排序 堆排序
        if(arr.length <= 0 || k <= 0) return new int[0];
        return quickSearch(arr, 0, arr.length-1, k-1); 
    }

    public int[] quickSearch(int[] arr, int low, int high, int k){
        // 分区，以第一个元素为基准，最后返回第一个元素排列后的下标
        int j = partition(arr, low, high); 
        if(j == k) return Arrays.copyOf(arr, j+1); // j+1代表新数组的个数
        return j > k ? quickSearch(arr, low, j-1, k) : quickSearch(arr, j+1, high, k);
    }

    // 分区分区
    public int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int left = low;
        int right = high+1; 
        while(true){
            // 从左边和右边分别找一个比基准值大和小的值进行后续交换
            while(++left <= high && arr[left] < pivot);
            while(--right >= low && arr[right] > pivot);
            if(left >= right) break;
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        // 此时left >= right，因为我们一开始把第一个取出来了，那个位置空了，left 依旧指向比pivot大的值，right 指向比pivot小的值
        arr[low] = arr[right];
        arr[right] = pivot;
        return right; // 返回下标
    }
}
```

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0 || arr.length == 0) return new int[0];
        int[] counter = new int[10001];
        for(int num : arr) counter[num]++; // 下标为num
        int[] res = new int[k];
        int index = 0;
        // 小值下标就先遍历到，先取出来，并且不需要管顺序
        for(int num = 0; num < 10001; num++){
            // 下标所在值大于0
            while(counter[num]-- > 0 && index < k){
                res[index++] = num;
            }
            if(index == k) break; // k下标没有被取出来
        }
        return res;
    }
}
```

```java
// 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
// 1. 若目前堆的大小小于K，将当前数字放入堆中。
// 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
//    反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 不符合条件输入
        if(k == 0 || arr.length == 0) return new int[0];
        // 优先级队列，默认实现是小根堆，重写比较器
        Queue<Integer> pq = new PriorityQueue<>((v1,v2) -> v2 - v1);
        for(int num : arr){
            // 元素还没有k个直接插入，等于k就要判断了，所以里面只有k个
            if(pq.size() < k) pq.offer(num); 
            else if(num < pq.peek()){ // 插入的元素比最大的还要小，替换       
                pq.poll();            // 删除最大元素
                pq.offer(num);        // 插入当前遍历元素
            }
        }
        // 将大根堆封装到一个数组
        int[] res = new int[pq.size()];
        int index = 0;
        for(int num : pq) res[index++] = num;
        return res;
    }
}
```

```java
// 二叉搜索树 treemap 没看懂
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // TreeMap的key是数字, value是该数字的个数。
        // cnt表示当前map总共存了多少个数字。
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num: arr) {
            // 1. 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            } 
            // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
            //    若当前数字比map中最大的数字还大，就直接忽略；
            //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1。
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            
        }

        // 最后返回map中的元素
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }
} 
```



