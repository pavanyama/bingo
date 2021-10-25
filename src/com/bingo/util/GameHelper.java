package com.bingo.util;

import com.bingo.generator.RandomNumberGenerator;
import com.bingo.model.Game;
import com.bingo.model.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GameHelper {

    public static Integer generateRandomNumber(int count, Game game) {
        boolean isDuplicate;
        Integer randomNumber;
        do{
            List<Integer> randomNumberList = RandomNumberGenerator.generate(count, game.getUpperBound());
            //Need to check null check and throw IllegalStatusException.
            randomNumber = randomNumberList.get(0);
            isDuplicate = game.getCallerNumbers().contains(randomNumber);
        } while(isDuplicate && game.getCallerNumbers().size()!=game.getTotalNumbersCountOnTicket());

        game.getCallerNumbers().add(randomNumber);
        return randomNumber;
    }

    public static void generateSummary(Game game) {
        Map<String, String> summaryMap = new HashMap<>();

        System.out.println("\n\n ======================");
        System.out.println("         Summary:");
        game.getWinners().forEach(winner -> {
            Player player = winner.getPlayer();
            String evaluatorsDescr = summaryMap.get(player.getName());
            if(evaluatorsDescr!=null && !evaluatorsDescr.isEmpty()) {
                summaryMap.put(player.getName(), evaluatorsDescr
                        + Constants.AND + winner.getEvaluator().getName());
            } else {
                summaryMap.put(player.getName(), winner.getEvaluator().getName());
            }
        });
        summaryMap.forEach((key, value) -> {
            System.out.println(key+Constants.COLON+value);
        });
        System.out.println(" ======================");
    }
}
