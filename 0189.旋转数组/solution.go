package main

func rotate(nums []int, k int) {
	n := len(nums)
	k %= n
	reverse(nums, 0, n-1) // 反转整个数组
	reverse(nums, 0, k-1) // 反转[0, k-1)数
	reverse(nums, k, n-1) // 反转(k, n-1]数
}

func reverse(nums []int, i int, j int) {
	for i < j {
		nums[i], nums[j] = nums[j], nums[i]
		i++
		j--
	}
}
