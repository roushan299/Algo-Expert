package greedy_algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class ClassPhotos {

    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        int difference = redShirtHeights.get(0) - blueShirtHeights.get(0);

        for(int i = 0; i < redShirtHeights.size(); i++) {
            int redShirtHeight = redShirtHeights.get(i);
            int blueShirtHeight = blueShirtHeights.get(i);

            if(((redShirtHeight - blueShirtHeight) * difference) <= 0 ){
                return false;
            }
        }
        return true;
    }
}
