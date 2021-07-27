package main

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
