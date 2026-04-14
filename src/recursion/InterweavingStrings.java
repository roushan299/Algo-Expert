package recursion;

public class InterweavingStrings {


    public static boolean interweavingStrings(String one, String two, String three) {
        if(three.length() != (one.length() + two.length())) return false;
        boolean[][] cache = new boolean[one.length()+1][two.length()+1];
        return areInterWoven(one, two, three, 0, 0, cache);
    }

    private static boolean areInterWoven(String one, String two, String three, int i, int j, boolean[][] cache) {
        if(cache[i][j]) return false;

        int k = i+j;

        if(k == three.length()) return true;

        if(i < one.length() && one.charAt(i) == three.charAt(k)) {
            if(areInterWoven(one, two, three, i+1, j, cache)) return true;
        }

        if(j < two.length() && two.charAt(j) == three.charAt(k)) {
            if(areInterWoven(one, two, three, i, j+1, cache)) return true;
        }
        cache[i][j] = true;
        return false;
    }

//    public static boolean interweavingStrings(String one, String two, String three) {
//        if(three.length() != (two.length() + one.length())) return false;
//        return areInterWoven(one, two, three, 0, 0);
//    }
//
//    public static boolean areInterWoven(String one, String two, String three, int i, int j) {
//        int k = i + j;
//
//        if(k== three.length()) return true;
//
//        if(i < one.length() && one.charAt(i) == three.charAt(k)){
//            if(areInterWoven(one, two, three, i+1, j)){
//                return true;
//            }
//        }
//
//        if(j < two.length() && two.charAt(j) == three.charAt(k)){
//            return areInterWoven(one, two, three, i, j+1);
//        }
//        return false;
//    }

}
