package Wyatt;

import java.util.ArrayList;

public class RoundRobinSchedule {
    public static void main(String[] args) {
        // Initialize the ArrayList of fighters
        ArrayList<String> fighters = new ArrayList<>();
        fighters.add("domon");
        fighters.add("saisaishi");
        fighters.add("argo");
        fighters.add("george");
        fighters.add("schwartz");

        // Generate and print the schedule
        generateRoundRobinSchedule(fighters);
    }

    private static void generateRoundRobinSchedule(ArrayList<String> fighters) {
        int numFighters = fighters.size();

        // If the number of fighters is odd, add a dummy fighter to make it even
        boolean hasDummy = false;
        if (numFighters % 2 != 0) {
            fighters.add("dummy");
            numFighters++;
            hasDummy = true;
        }

        int numRounds = numFighters - 1;
        int halfSize = numFighters / 2;

        ArrayList<String> tempList = new ArrayList<>(fighters);

        for (int round = 0; round < numRounds; round++) {
            System.out.println("Round " + (round + 1));

            for (int i = 0; i < halfSize; i++) {
                String fighter1 = tempList.get(i);
                String fighter2 = tempList.get(numFighters - i - 1);

                if (!fighter1.equals("dummy") && !fighter2.equals("dummy")) {
                    System.out.println(fighter1 + " -> " + fighter2);
                }
            }

            // Rotate the list to get the new pairings for the next round
            String last = tempList.remove(numFighters - 1);
            tempList.add(1, last);
        }
    }
}
