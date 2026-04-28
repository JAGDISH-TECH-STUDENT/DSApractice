class GreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       int [] r=new int[nums1.length];
       for(int i=0;i<nums1.length;i++){
            r[i]=getnextGreater(nums1[i],nums2);
       }
       return r;
    }
    
    public int getnextGreater(int num ,int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==num){
                for(i=i+1;i<arr.length;i++){
                    if(num<arr[i]){
                        return arr[i];
                    }
                }
                return -1;
            }
        }
        return -1;    
    }
    public static void main(String[] args) {
        GreaterElement ge = new GreaterElement();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] result = ge.nextGreaterElement(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}