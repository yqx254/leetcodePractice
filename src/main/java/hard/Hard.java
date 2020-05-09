package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Hard {

    public double findMedianSortedArrays(int [] nums1, int [] nums2){
        int n = nums1.length;
        int m = nums2.length;
        if(m > n){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = n;
            n = m;
            m = tmp;
        }
        int iMin = 0, iMax = m, halfLen  =(m + n + 1) / 2;
        while(iMin <= iMax){
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if(i < iMax && nums1[i] < nums2[j - 1]){
                iMin = i + 1;
            }
            else if(i > iMin && nums1[i - 1] > nums2[j]){
                iMax = i - 1;
            }
            else{
                int maxLeft = 0;
                if(i == 0){
                    maxLeft = nums2[j - 1];
                }
                else if(j == 0){
                    maxLeft = nums1[i - 1];
                }
                if((m + n ) % 2 == 1){
                    return maxLeft;
                }
                
            }
        }
        return 0.0;

    }
}
