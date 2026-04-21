class SortedArray {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n; 

        int i = 2; 
        for (int j = 2; j < n; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i; 
    }
    public static void main(String[] args) {
        SortedArray s = new SortedArray();
        int[] nums = {1,1,1,2,2,3};
        int newLength = s.removeDuplicates(nums);
        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
