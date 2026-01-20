package arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class TournamentWinner {

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        HashMap<String, Integer> scoreBoard = new HashMap<>();
        String currentLeader = "";
        int highestScore = 0;
        for(int i = 0; i < competitions.size(); i++) {
            ArrayList<String> competition = competitions.get(i);
            String matchWinner = getMatchWinner(competition, results.get(i));
            int updatedScore = updateScore(scoreBoard, matchWinner);

            if(updatedScore > highestScore) {
                highestScore = updatedScore;
                currentLeader = matchWinner;
            }
        }
        return currentLeader;
    }
    public int updateScore(HashMap<String, Integer> scoreBoard, String winnerTeamName) {
        int newScore = scoreBoard.getOrDefault(winnerTeamName, 0)+1;
        scoreBoard.put(winnerTeamName, newScore);
        return newScore;
    }

    public String getMatchWinner(ArrayList<String> competition, int result){
        int winnerIndex =  getWinnerIndex(result);
        return competition.get(winnerIndex);
    }

    public int getWinnerIndex(int result){
        return result==1 ? 0: 1;
    }

}
