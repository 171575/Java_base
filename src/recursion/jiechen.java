package recursion;

/**
 * jiechen
 * @author chen
 * @date 2023/5/8 14:47
 * @version 1.0
 */
public class jiechen {
    public static void main(String[] args) {
        //System.out.println(f(10));
        //print("zxcvbnm",0);
        //System.out.println(fei(10));
        HanoiTower(2,"a","b","c");
    }
    public static int f(int n){
        if(n==1){
            return 1;
        }
        return n*f(n-1);
    }

    public static void print(String str,int index){
        if(index==str.length()){
            return;
        }
        print(str,index+1);
        System.out.println(str.charAt(index));
    }

    public static int fei(int n){
        if (n<2){
            return n;
        }
        return fei(n-1)+fei(n-2);
    }

    /**
     * 递归实现冒泡排序
     */
    public static void sort(int[] nums,int j){
        if (j==0){
            return;
        }
        for (int i = 0; i < j; i++) {
            if(nums[i]>nums[i+1]){
                int t = nums[i];
                nums[i]=nums[i+1];
                nums[i+1]=t;
            }
        }
        sort(nums,j-1);
    }

    /**
     * 递归实现插入排序
     */
    public void insertion(int[] nums,int low){
        if(low==nums.length){
            return;
        }
        int t = nums[low];
        int i = low-1;//已排序区域指针
        while(nums[i]>t && i>=0){
            nums[i+1]=nums[i];
            i--;
        }
        if(i+1!=low) {
            nums[i + 1] = t;
        }
        insertion(nums,low+1);
    }
    /**
     * HanoiTower
     */
    public static void HanoiTower(int n,String a,String b,String c){
        if(n==0){
            return;
        }
        HanoiTower(n-1,a,c,b);
        System.out.println(a+"->"+c);
        HanoiTower(n-1,b,a,c);
    }
}
 