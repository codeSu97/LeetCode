## [977.有序数组的平方](https://leetcode-cn.com/problems/squares-of-a-sorted-array)

### 题目详情
> 给你一个按 `非递减顺序` 排序的整数数组 `nums`，返回 `每个数字的平方` 组成的新数组，要求也按 `非递减顺序` 排序。

**示例 1：**
```sh
输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]
```
**示例 2：**
```sh
输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
```
 

**提示：**

- <= nums.length <= 10<sup>4</sup>
- -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>
- nums 已按 `非递减顺序` 排序
 

**进阶：**

请你设计时间复杂度为 O(n) 的算法解决本问题

### 解法
**思路**
1. 双指针，i指向起始位置，j指向终止位置
2. 定义一个新的数组result，大小和nums一样，设置一个k指向result终止位置
3. 如果`nums[i]*nums[i] < nums[j]*nums[j]`，那么 `result[k] = nums[j]*nums[j]`
4. 如果`nums[i]*nums[i] >= nums[j]*nums[j]`，那么 `result[k] = nums[i]*nums[i]`

**实现**
1. [Java](./Solution.java)
```java
public int[] sortedSquares(int[] nums) {
    int i = 0;
    int j = nums.length - 1;
    int k = nums.length - 1;
    int[] result = new int[nums.length];
    while (i <= j) {
        int im = nums[i] * nums[i];
        int jm = nums[j] * nums[j];
        if (im < jm) {
            result[k] = jm;
            j--;
        } else {
            result[k] = im;
            i++;
        }
        k--;
    }
    return result;
}
```

2. [Python3](./solution.py)
```python
def sortedSquares(self, nums: List[int]) -> List[int]:
    i, j, k = 0, len(nums) - 1, len(nums) - 1
    result = [None] * len(nums)
    while i <= j:
        im = nums[i] ** 2
        jm = nums[j] ** 2
        if im < jm:
            result[k] = jm
            j -= 1
        else:
            result[k] = im
            i += 1
        k -= 1
    return result
```

3. [Go](./solution.go)
```go
func sortedSquares(nums []int) []int {
	i, j, k := 0, len(nums)-1, len(nums)-1
	result := make([]int, len(nums))
	for i <= j {
		im, jm := nums[i]*nums[i], nums[j]*nums[j]
		if im < jm {
			result[k] = jm
			j--
		} else {
			result[k] = im
			i++
		}
		k--
	}
	return result
}
```