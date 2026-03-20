package algorithms;

import java.util.*;

public class StableInternships {
    public int[][] stableInternships(int[][] internPreference, int[][] teamPreference) {
        validateInput(internPreference, teamPreference);

        int n = internPreference.length;

        //team -> current intern
        Map<Integer, Integer> teamToIntern = new HashMap<>();

        //Track which team each intern will propose to next
        int[] nextProposalIndex = new int[n];

        //Use ArrayDeque instead of stack (modern java)
        Deque<Integer> freeInterns = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            freeInterns.add(i);
        }

        //Precompute team ranking: team -> (inter -> rank)
        List<Map<Integer, Integer>> teamRanking = buildTeamranking(teamPreference);

        while(!freeInterns.isEmpty()){
            int internId = freeInterns.poll();

            //Defensive check: ensure intern still has teams to propose to
            if(nextProposalIndex[internId] >= n){
                throw new IllegalArgumentException("Interns "+internId+" has no teams left to propose");
            }
            
            int teamId = internPreference[internId][nextProposalIndex[internId]++];
            
            if(!teamToIntern.containsKey(teamId)){
                //team is free
                teamToIntern.put(teamId, internId);
            }else {
                int currentInternId = teamToIntern.get(teamId);
                
                int currentRank = teamRanking.get(teamId).get(currentInternId);
                int newRank = teamRanking.get(teamId).get(internId);
                
                if(newRank <  currentRank){
                    // team prefers new intern
                    teamToIntern.put(teamId, internId);
                    freeInterns.push(currentInternId);
                }else {
                    freeInterns.add(internId);
                }
            }
        }
        return buildMatches(teamToIntern, n);
    }

    private int[][] buildMatches(Map<Integer, Integer> teamToIntern, int n) {
        int[][] matches = new int[n][2];

        for(int teamId = 0; teamId<n; teamId++){
            Integer internId = teamToIntern.get(teamId);

            if(internId == null){
                throw new IllegalArgumentException("Team "+teamId+" was not assigned to intern");
            }
            matches[teamId][0] = internId;
            matches[teamId][1] = teamId;
        }
        return matches;
    }

    private void validateInput(int[][] internPreference, int[][] teamPreference) {
        if(internPreference == null || teamPreference == null){
            throw new IllegalArgumentException("Input array must not be null");
        }

        if(internPreference.length != teamPreference.length){
            throw new IllegalArgumentException("Number of interns and team must be same");
        }

        int n = internPreference.length;

        for(int i = 0; i < n; i++){
            if(internPreference[i] == null || internPreference[i].length != n){
                throw new IllegalArgumentException("Each intern must rank all teams");
            }

            if(teamPreference[i] == null || teamPreference[i].length != n){
                throw new IllegalArgumentException("Each team must rank all interns");
            }
        }


    }


    private List<Map<Integer, Integer>> buildTeamranking(int[][] teamPreference) {
        List<Map<Integer, Integer>> ranking = new ArrayList<>();

        for(int[] teamPref: teamPreference){
            Map<Integer, Integer> rankMap = new HashMap<>();

            for(int i=0;i<teamPref.length;i++){
                rankMap.put(teamPref[i], i);
            }
            ranking.add(rankMap);
        }
        return ranking;
    }
}
