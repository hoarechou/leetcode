public class Solution {
    
    public int search(int[] nums, int target) {
        int min;
	    
	    if(target == nums[0])
		    return 0;
	    if(target == nums[nums.length - 1])
		    return nums.length -1;
		    
        min = findMin(nums);
        if(target == nums[min])
		    return min;
		    
        if(target > nums[min] && target < nums[nums.length-1])
            return binarySearch(nums, min, nums.length - 1, target);
	    else
            return binarySearch(nums, 0, min, target);
    }   

    public int findMin(int[] a) {
        int left = 0;
        int right = a.length - 1;
        int min = left + (right - left) / 2;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(a[mid] < a[min])
                min = mid;
            /* The a[left] is the min value of left side, but */
            /* we still need to check right side due to the array may be rotated */
            if(a[left] < a[mid]){
                /* update min */
                if(a[left] < a[min])
                    min = left;
                /* check right side */        
                left = mid + 1;
            }
            /* if a[left] > a[mid], the min valuse is at left side */
            else if(a[left] > a[mid]) {
                right = mid - 1;
                left = left + 1;
            }
            /* a[left] == a[mid] (i.e lo = hi -1) means that only a[right] need to check */
            else{
                if(a[right] < a[min])
                    min = right;
                break;
            }
        }
        return min;
    }
    
    public int binarySearch(int[] a, int left, int right, int target) {
        while (left <= right) {
            /* target is in a[left..right] or not present. */
            int mid = left + (right - left) / 2;
            if(target < a[mid])
                right = mid - 1;
            else if(target > a[mid])
                left = mid + 1;
            else 
                return mid;
        }
        return -1;
    }
}

