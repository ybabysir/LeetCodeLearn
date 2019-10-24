package hard;

public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int index = len/2;
        int i1 = 0;
        int i2 = 0;
        if(nums1.length ==0)
            return len%2 == 1? nums2[index]:((double)nums2[index -1] + (double)nums2[index])/2;
        if(nums2.length ==0)
            return len%2 ==1 ? nums1[index]:((double)nums1[index-1] + (double)nums1[index])/2;
        int[] result = new int[index + 1];
        for(int i = 0; i <= index ; i++){
            if(i1 < nums1.length && nums1[i1] <= nums2[i2]){
                result[i] = nums1[i1++];
                if(i1 == nums1.length){
                    int rest = index - i;
                    i++;
                    for(int j = 0; j < rest;j++){
                        result[i++] = nums2[i2++];
                    }
                    break;
                }
                continue;
            }

            if(i2 < nums2.length && nums2[i2] <= nums1[i1]){
                result[i] = nums2[i2++];
                if(i2 == nums2.length){
                    int rest = index - i;
                    i++;
                    for(int j = 0 ; j < rest; j++){
                        result[i++] = nums1[i1++];
                    }
                    break;
                }
                continue;
            }
        }
        return len%2 == 1? result[index] : ((double)result[index-1] + (double)result[index])/2;
    }
}
