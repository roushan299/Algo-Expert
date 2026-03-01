package arrays;

public class MajorityElement {

    public int majorityElement(int[] array) {
        int currentFrequency = 1;
        int currentNumber = array[0];

        for (int i = 1; i < array.length; i++) {
            if (currentNumber == array[i]) {
                currentFrequency++;
            }else {
                currentFrequency--;
            }

            if(currentFrequency == 0){
                currentNumber = array[i];
                currentFrequency = 1;
            }
        }
        return currentNumber;
    }
}
