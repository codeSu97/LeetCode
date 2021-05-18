package leetcode

// @title twoSum
// @description 创建字典存放数组的值与其对应的下边, 遍历数组，当发现 target-nums[i] 在字典中，则说明找到了
// @param nums [int] 传入的数组
// @param target int 目标值
// @return
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
