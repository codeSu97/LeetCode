package main

func moveZeroes(nums []int) {
    slow, fast := 0, 0
    for fast <= len(nums)-1 {
        if nums[fast] == 0 {
            fast++
        } else {
            nums[slow], nums[fast] = nums[fast], nums[slow]
            slow++
            fast++
        }
    }
}
