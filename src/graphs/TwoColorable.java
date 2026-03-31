package graphs;

import java.util.Stack;

public class TwoColorable {
    private static final String GREEN = "green";
    private static final String BLUE = "blue";


    public boolean twoColorable(int[][] edges) {
        String[] colors = new  String[edges.length];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        colors[0] = GREEN;

        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            String currentColor = colors[currentNode];

            for (int neighbor : edges[currentNode]) {
                if (colors[neighbor] == null) {
                    // Assign opposite color
                    colors[neighbor] = getOppositeColor(currentColor);
                    stack.push(neighbor);
                } else if (colors[neighbor].equals(currentColor)) {
                    // Conflict detected
                    return false;
                }
            }
        }
        return true;
    }


    private String getOppositeColor(String color) {
        return color.equals(BLUE) ? GREEN : BLUE;
    }
}
