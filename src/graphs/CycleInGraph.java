package graphs;

public class CycleInGraph {


    private final int WHITE = 0;
    private final int GREY = 1;
    private final int BLACK = 2;

    public boolean cycleInGraph(int[][] edges) {
        int numberOfEdges = edges.length;
        int[] colours = new int[numberOfEdges];

        for (int node = 0; node < numberOfEdges; node++) {

            if(colours[node] != WHITE){
                continue;
            }

            boolean containsCycle = traverseAndColorsNodes(node, edges, colours);
            if(containsCycle) return true;
        }
        return false;
    }

    private boolean traverseAndColorsNodes(int node, int[][] edges, int[] colours) {
        colours[node] = GREY;
        int[] neighbours = edges[node];

        for (int neighbour : neighbours) {
            int neighbourColour = colours[neighbour];

            if(neighbourColour == GREY) return true;
            if(colours[neighbour] != WHITE) continue;

            boolean containsCycle = traverseAndColorsNodes(neighbour, edges, colours);
            if(containsCycle) return true;
        }
        colours[node] = BLACK;
        return false;
    }


//    public boolean cycleInGraph(int[][] edges) {
//        int numOfNodes = edges.length;
//        boolean[] visited = new boolean[numOfNodes];
//        boolean[] currentlyInStack = new boolean[numOfNodes];
//
//       for(int node = 0; node <numOfNodes; node++){
//
//           if(visited[node]){
//               continue;
//           }
//           boolean containsCycle = isNodeInCycle(edges, node, visited, currentlyInStack);
//
//           if(containsCycle){
//               return true;
//           }
//
//       }
//       return false;
//    }
//
//    private boolean isNodeInCycle(int[][] edges, int node, boolean[] visited, boolean[] currentlyInStack) {
//       visited[node] = true;
//       currentlyInStack[node] = true;
//
//       int[] neighbours = edges[node];
//
//       for(int neighbour : neighbours){
//           if(!visited[neighbour]){
//             boolean containsCycle =  isNodeInCycle(edges, neighbour, visited, currentlyInStack);
//
//             if(containsCycle) return true;
//           } else if (currentlyInStack[neighbour]) {
//               return true;
//           }
//
//       }
//       currentlyInStack[node] = false;
//       return false;
//    }


}
