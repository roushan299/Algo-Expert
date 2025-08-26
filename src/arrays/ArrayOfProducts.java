package arrays;


public class ArrayOfProducts {

    public int[] arrayOfProducts(int[] array) {
        // Write your code here.
        int[] productArr = new int[array.length];
        int product = 1;

        for(int i=0;i<array.length;i++){
            productArr[i] = 1;
        }

        for(int i=0;i< array.length;i++){
            productArr[i] = product;
            product *=array[i];
        }
        product = 1;
        for(int i=array.length-1;i>=0;i--){
            productArr[i] *=product;
            product *= array[i];
        }
        return productArr;
    }
}
