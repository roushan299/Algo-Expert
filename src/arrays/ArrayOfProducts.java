package arrays;

public class ArrayOfProducts {

    public int[] arrayOfProducts(int[] array) {
        int[] ans  = new int[array.length];
        int leftProduct = 1;

        for(int i = 0; i < array.length; i++) {
            ans[i] = leftProduct;
            leftProduct *= array[i];
        }

        int rightProduct = 1;

        for(int i= array.length-1; i >= 0; i--) {
            ans[i] *= rightProduct;
            rightProduct *= array[i];
        }
        return ans;
    }
}
