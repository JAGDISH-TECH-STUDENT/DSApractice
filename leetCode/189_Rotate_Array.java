class ArrayRotation {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        ArrayRotation s = new ArrayRotation();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        s.rotate(nums, k);
        System.out.print("Rotated array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
