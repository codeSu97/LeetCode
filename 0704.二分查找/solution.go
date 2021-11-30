package main

func search(nums []int, target int) int {
	low := 0
	high := len(nums) - 1
	mid := 0
	for low <= high {
		mid = low + (high-low)>>1
		if nums[mid] == target {
			return mid
		} else if nums[mid] < target {
			low = mid + 1
		} else if nums[mid] > target {
			high = mid - 1
		}
	}
	return -1
}
