package graphs;

public class YoungestCommonAncestor {

    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        int depthOne = getDescendantDepth(topAncestor, descendantOne);
        int depthTwo = getDescendantDepth(topAncestor, descendantTwo);

        if (depthOne > depthTwo) {
            return backTrackAncestralTree(descendantOne, descendantTwo, depthOne - depthTwo);
        }else {
            return backTrackAncestralTree(descendantTwo, descendantOne, Math.abs(depthTwo - depthOne));
        }
    }

    private static AncestralTree backTrackAncestralTree(AncestralTree lowestDescendant, AncestralTree higherDescendant, int diff) {

        while (diff > 0) {
            lowestDescendant = lowestDescendant.ancestor;
            diff--;
        }

        while (lowestDescendant !=  higherDescendant) {
            higherDescendant = higherDescendant.ancestor;
            lowestDescendant = lowestDescendant.ancestor;
        }
        return lowestDescendant;
    }


    private static int getDescendantDepth(AncestralTree topAncestor, AncestralTree descendant) {
        int depth = 0;

        while (topAncestor != descendant) {
            depth++;
            descendant = descendant.ancestor;
        }
        return depth;
    }


    static class AncestralTree{
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name){
            this.name=name;
            ancestor=null;
        }

        void addAncestor(AncestralTree[] descendants){

            for(AncestralTree descendant :descendants){
                descendant.ancestor=this;
            }

        }

    }
}
