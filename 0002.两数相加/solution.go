package main

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
