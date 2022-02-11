class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=findFirstIndex(nums,target);//calling function to find first index of the target
        int last=findLastIndex(nums,target,first);//calling function to find last index of the target
        
        return new int[]{first,last};
    }
    public int findFirstIndex(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;//calculating mid
             if(nums[mid]==target){
                if(mid==0 || (nums[mid]!=nums[mid-1]))//if mid element is target, then checking if mid and mid-1 are not equal then returning mid.
                    return mid;
                 else
                     high=mid-1;//if mid and mid-1 are equal, then mid will be on left side, so assigning mid-1 to high
            }else if(target<nums[mid]){// if target is less than mid, then assigning mid-1 to high
                high=mid-1;
            }else{
                low=mid+1;//if target is greater than mid, then assigning mid+1 to low
            }
        }
        return -1;//if target is not present returning -1
    }
     public int findLastIndex(int[] nums,int target,int start){
         if(start==-1)
             return -1;
        int low=start;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;//calculating mid
            if(nums[mid]==target){
                if(mid==nums.length-1 || (nums[mid]!=nums[mid+1]))////if mid element is target, then checking if mid and mid+1 are not equal then returning mid.
                    return mid;
                else
                    low=mid+1;////if mid and mid+1 are equal, then mid will be on right side, so assigning mid+1 to high
            }
            else if(target<nums[mid]){
                high=mid-1;// if target is less than mid, then assigning mid-1 to high
            }else{
                low=mid+1;//if target is greater than mid, then assigning mid+1 to low
            }
        }
        return -1;//if target is greater than mid, then assigning mid+1 to low
    }
}
