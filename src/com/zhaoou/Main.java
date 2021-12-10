package com.zhaoou;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int numberOfSimulations = 10000;
        int numberOfDice = 5;
        int takenOffThreshold = 3;
        int simulatedScore;

        long startTime = System.currentTimeMillis();

        // Put simulated score into hashmap for printing out. Key: score, Value: appeared times
        Map<Integer, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < numberOfSimulations; i++) {
            simulatedScore = DiceSimulatorUtils.getSimulatedScore(numberOfDice, takenOffThreshold, 0);
            scoreMap.merge(simulatedScore, 1, Integer::sum);
        }

        long stopTime = System.currentTimeMillis();

        // Print out results
        System.out.println("Number of simulations was " + numberOfSimulations + " using " + numberOfDice + " dice.");
        for (Map.Entry<Integer, Integer> entry : scoreMap.entrySet()) {
            System.out.println("Total " + entry.getKey() + " occurs " + String.format("%.4f", (double) (entry.getValue()) / numberOfSimulations) + " occurred " + entry.getValue() + " times");
        }
        System.out.println("Total simulation took " + String.format("%.3f", (double) (stopTime - startTime) / 1000) + " seconds.");
    }
}
