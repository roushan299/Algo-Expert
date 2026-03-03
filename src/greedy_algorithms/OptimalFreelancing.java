package greedy_algorithms;

import java.util.Map;

public class OptimalFreelancing {

    public int optimalFreelancing(Map<String, Integer>[] jobs) {
        int[] paymentsPerDay = new int[7];

        for(Map<String, Integer> job : jobs) {
            int deadline = Math.min(job.get("deadline")-1, 6);
            putIntoBestPosition(paymentsPerDay, deadline, job.get("payment"));
        }

        int totalEarning = calculateTotalEarning(paymentsPerDay);
        return totalEarning;
    }

    private void putIntoBestPosition(int[] payments, int deadline, int payment) {

        while (deadline >= 0 && payment != 0){

            if(payment > payments[deadline]){
                int temp = payments[deadline];
                payments[deadline] = payment;
                payment = temp;
            }
            deadline--;
        }
    }

    private int calculateTotalEarning(int[] paymentsPerDay) {
        int totalEarning = 0;
        for (int i = 0; i < paymentsPerDay.length; i++) {
            totalEarning += paymentsPerDay[i];
        }
        return totalEarning;
    }
}
