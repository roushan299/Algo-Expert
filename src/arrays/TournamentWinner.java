package arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class TournamentWinner {
    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        HashMap<String, Integer> pointTable = new  HashMap<>();
        String finalWinner = "";
        int winnerPoints = 0;
        for(int idx=0;idx<competitions.size();idx++){
            int winnerIdx = results.get(idx) == 0 ? 1 : 0;
            String  winner = competitions.get(idx).get(winnerIdx);
            int points = pointTable.containsKey(winner) ? pointTable.get(winner)+1 : 1;
            pointTable.put(winner, points);
            if(winnerPoints < points){
                finalWinner = winner;
                winnerPoints = points;
            }
        }
        return finalWinner;
    }
}
