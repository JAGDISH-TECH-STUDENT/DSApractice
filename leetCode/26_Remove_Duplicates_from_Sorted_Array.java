class Main {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        int[] nums = {1,1,2};
        int result = m.removeDuplicates(nums);
        System.out.println(result);
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}