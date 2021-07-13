/**
 * @description:
 * @author: Andy
 * @time: 2021/7/13 5:05
 */

public class 两数之和 {
    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    //
    // 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    //

    public void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
        }

        /*暴力破解*/
       /* for (int i = 0; i < nums.length; i++) {
            for (int j =i+ 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(i + "" + j);
                }
            }
        }*/

    }
}
