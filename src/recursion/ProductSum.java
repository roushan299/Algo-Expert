package recursion;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {
    public static int productSum( List<Object> array) {
       return calculateInner(1, array);
    }

    public static int calculateInner(int depth, List<Object> array){
        int innerSum  =0;
        for(int i=0;i<array.size();i++){
            if(array.get(i) instanceof ArrayList ){
                innerSum = innerSum + calculateInner(depth+1, (ArrayList)(array.get(i)));
            }else {
                innerSum = innerSum + (Integer)(array.get(i));
            }
        }
        return innerSum*depth;
    }
}
