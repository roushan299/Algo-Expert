package sorting;

public class ThreeNumberSort {

    public int[] threeNumberSort(int[] array, int[] order) {
        int firstValue = order[0];
        int secondValue = order[1];

        //keep track of indicies where the values are stored
        int firstElementIdx = 0;
        int secondElementIdx = 0;
        int thirdElementIdx = array.length - 1;

        while (secondElementIdx <= thirdElementIdx) {
            int value = array[secondElementIdx];

            if(firstValue == value) {
                swap(array, firstElementIdx, secondElementIdx);
                firstElementIdx++;
                secondElementIdx++;
            }else if(secondValue == value) {
                secondElementIdx++;
            }else{
                swap(array, secondElementIdx, thirdElementIdx);
                thirdElementIdx--;
            }
        }

        return array;
    }

    private  void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

}
