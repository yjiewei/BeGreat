#### [剑指 Offer 04. 二维数组中的查找](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)

```java
上下左右有序二维数组。
现有矩阵 matrix 如下：
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。
给定 target = 20，返回 false。
```



**答题思路：** 

```
从数组右上角或者左下角开始遍历，利用数组排序的规律。
时间复杂度是O(N+M) 分别是行数和列数
空间复杂度是O(1) 只用了额外的几个常量
```



**答题代码：** 

```java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean found = false;
        if(matrix == null || matrix.length == 0) return found;
        int rows = matrix.length;
        int columns = matrix[0].length;
        if(matrix != null && rows > 0 && columns > 0){
            int row = 0;
            int column = columns - 1;
            while(row < rows && column >= 0){ // 刚才抄都抄错了，应该是可以等于0的
                if(matrix[row][column] == target){
                    found = true;
                    break;
                }else if(matrix[row][column] > target){
                    column--;
                }else{
                    row++;
                }
            }
        }
        return found;
    }
}
```

