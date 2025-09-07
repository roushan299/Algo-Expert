package string;

public class OneEdit {
    public boolean oneEdit(String stringOne, String stringTwo) {
      int lengthOne = stringOne.length();
      int  lengthTwo = stringTwo.length();

      if(Math.abs(lengthOne - lengthTwo) > 1){
          return false;
      }

      boolean madeEdit = false;
      int indexOne = 0;
      int indexTwo = 0;


     while((indexOne<lengthOne) && (indexTwo<lengthTwo)){
         if(stringOne.charAt(indexOne) != stringTwo.charAt(indexTwo)){
             if(madeEdit){
                 return false;
             }
             madeEdit = true;

             if(lengthOne > lengthTwo){
                 indexOne = indexOne + 1;
             }else if(lengthTwo > lengthOne){
                 indexTwo = indexTwo + 1;
             }else {
                 indexOne = indexOne + 1;
                 indexTwo = indexTwo + 1;
             }
         }else {
             indexOne = indexOne + 1;
             indexTwo = indexTwo + 1;
         }
     }

        return true;
    }
}
