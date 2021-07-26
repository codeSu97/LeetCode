package main

func firstBadVersion(n int) int {
	if n == 1 {
		return 1
	}
	left, right := 1, n
	for left <= right {
		mid := left + (right-left)>>1
		if isBadVersion(mid) {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return left
}
