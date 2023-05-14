/**
 * search
 * @author chen
 * @date 2023/5/4 14:32
 * @version 1.0
 */
public class BinarySearch {
    /**
     * 二分查找升序基础版
     * 向左找和向右找用的空间不一样。
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target){
        int i=0;
        int m=0;
        int j = nums.length-1;
        while(i<=j){
            m=(i+j)/2;
            //可以改为 （i+j）>>> 1,应为直接除以2的话，当数组长度为整数最大值时，会出现负数问题。
            if(nums[m]>target){
                j=m-1;
            }else if(nums[m]<target){
                i=m+1;
            }else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 二分查找升序改动版
     * 改变三处
     * @param nums
     * @param target
     * @return
     */
    public int searchAlternative(int[] nums, int target){
        int i=0;
        int m=0;
        int j = nums.length; //1
        while(i < j){ //2
            m=(i+j)>>>1;
            if(nums[m]>target){
                j = m; //3
            }else if(nums[m]<target){
                i = m+1;
            }else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 二分查找升序平衡版
     * @param nums
     * @param target
     * @return
     */
    public int searchBalance(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (1 < j - i) { //表示待查找元素个数
            int m = (i + j) >>> 1;
            if (target < nums[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        return (nums[i] == target) ? i : -1;
    }

    /**
     * 二分查找升序最左侧值（数据会有重复），要找到最左侧数据。
     * @param nums
     * @param target
     * @return
     */
    public static int searchLeftmost1(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < nums[m]) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                candidate = m; // 记录候选位置
                j = m - 1;     // 继续向左
            }
        }
        return candidate;
    }

    /**
     * 二分查找升序最右侧值（数据会有重复），要找到最右侧数据。
     * @param nums
     * @param target
     * @return
     */
    public static int searchRightmost1(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < nums[m]) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                candidate = m; // 记录候选位置
                i = m + 1;	   // 继续向右
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums ={1,2,3,4,15,26,37};
        int target =5;
        BinarySearch base = new BinarySearch();
        System.out.println(base.searchInsert(nums,target));
    }
}
 