package arrays;

public class MajorityElement {
    public int majorityElement(int[] array) {
        int currentMajorityElement = -1;
        int count = 0;

       for(int num : array) {
           if(count == 0) {
               currentMajorityElement = num;
           }
           if(currentMajorityElement == num) {
               count++;
           }else {
               count--;
           }
       }
       return currentMajorityElement;
    }
}
