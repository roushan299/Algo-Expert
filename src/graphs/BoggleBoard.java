package graphs;

import java.util.*;

public class BoggleBoard {
    private static int[][] DIRECTIONS;

    static class Trie{
        Map<Character, Trie> children = new HashMap<Character, Trie>();
        boolean isWordEnd;
    }

    public static List<String> boggleBoard(char[][] board, String[] words) {
        initializeDirection();
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        Set<String> visitedWords = new HashSet<String>();
        Trie root = new Trie();
        insert(root, words);

        for(int row =0; row<board.length; row++){
            for(int col =0; col<board[0].length; col++){
                dfs(board, row, col, isVisited, "", visitedWords, root);
            }
        }
        return new ArrayList<String>(visitedWords);
    }

    private static void dfs(char[][] board, int row, int col, boolean[][] isVisited, String currentString, Set<String> visitedWords, Trie root) {

        if(isVisited[row][col]) return;
        char letter = board[row][col];

        if(!root.children.containsKey(letter)) return;

        isVisited[row][col] = true;
        root = root.children.get(letter);

        currentString += letter;

        if(root.isWordEnd){
            visitedWords.add(currentString);
        }

        for(int[] direction :DIRECTIONS){
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if(isInBoundary(nextRow, nextCol, board)){
                dfs(board, nextRow, nextCol, isVisited, currentString, visitedWords, root);
            }
        }
        isVisited[row][col] = false;
    }

    private static void insert(Trie root, String[] words) {
        for (String word : words) {
            Trie current = root;
            for(char c : word.toCharArray()) {
                if(!current.children.containsKey(c)) {
                    current.children.put(c, new Trie());
                }
                current = current.children.get(c);
            }
            current.isWordEnd = true;
        }
    }

    private static boolean isInBoundary(int row, int col, char[][] board){
        boolean isRowInBoundary = 0 <= row && row <  board.length;
        boolean isColInBoundary = 0 <= col && col <  board[0].length;
        return isRowInBoundary && isColInBoundary;
    }


    private static void initializeDirection() {
        int[][] directions = new int[][]{
                {-1, -1}, {-1, 0}, {-1, 1},
                {0,  -1},          {0,  1},
                {1,  -1}, {1,   0}, {1, 1}
        };
        DIRECTIONS = directions;
    }

}
