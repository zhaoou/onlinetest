package com.zhaoou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DiceSimulatorUtils {

    /**
     * Get simulated score by throwing dice
     *
     * @param numberOfDice
     * @param takenOffThreshold
     * @param score
     * @return simulated score
     */
    public static int getSimulatedScore(int numberOfDice, int takenOffThreshold, int score) {
        List<Integer> diceList = new ArrayList<>();
        for (int i = 0; i < numberOfDice; i++) {
            diceList.add(getRandomNumberBetween(1, 6));
        }
        if (diceList.contains(takenOffThreshold)) {
            diceList = delElementFromList(diceList, takenOffThreshold, false);
        } else {
            int minValue = Collections.min(diceList);
            score = score + minValue;
            diceList = delElementFromList(diceList, minValue, true);
        }
        if (diceList.size() > 0) {
            return getSimulatedScore(diceList.size(), takenOffThreshold, score);
        } else {
            return score;
        }
    }

    /**
     * Generate a random number between the passed in number pair
     *
     * @param min
     * @param max
     * @return random number between passed in number pair
     */
    private static int getRandomNumberBetween(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    /**
     * Remove element(s) from list when the element value equals to the passed in number
     *
     * @param diceList
     * @param number
     * @param removeFirstOnly
     * @return the list after element(s) are removed
     */
    private static List<Integer> delElementFromList(List<Integer> diceList, int number, boolean removeFirstOnly) {
        Iterator iterator = diceList.iterator();
        while (iterator.hasNext()) {
            Object cur = iterator.next();
            if (cur.equals(number)) {
                iterator.remove();
                if (removeFirstOnly) {
                    break;
                }
            }
        }
        return diceList;
    }

}
