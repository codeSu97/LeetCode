## [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

### 题目描述
> 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
>
> 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
>
> 你可以按任意顺序返回答案。

**示例 1：**
```sh
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
```

**示例 2：**
```
输入：nums = [3,2,4], target = 6
输出：[1,2]
```

**示例 3：**
```
输入：nums = [3,3], target = 6
输出：[0,1]
```

**提示：**
- 2 <= nums.length <= 10<sup>3</sup>
- -10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>
- -10<sup>9</sup><= target <= 10<sup>9</sup>
- 只会存在一个有效答案

### 解法

**思路**
		创建字典存放数组的值与其对应的下标 遍历数组，当发现 target-nums[i] 在字典中，则说明找到了

**实现**

1. [Java](./TwoSum.java)
```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
        int n = target - nums[i];
        if (map.containsKey(n)) {
            return new int[] { map.get(n), i };
        }
        map.put(nums[i], i);
    }
    return null;
}
```
2. [Python3](./two_sum.py)
```python
def twoSum(self, nums: List[int], target: int) -> List[int]:
    tmp = {}
    for i, v in enumerate(nums):
        num = target - v
        if num in tmp:
            return [tmp[num], i]
        tmp[v] = i
```
3. [Go](./two_sum.go)
```go
func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		n := target - nums[i]
		if _, ok := m[n]; ok {
			return []int{m[n], i}
		}
		m[nums[i]] = i
	}
	return nil
}
```