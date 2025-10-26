package racingcar.domain;

import racingcar.domain.racer.Racers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Result {

    public Map<String, Integer> roundResult(Racers racers) {
        return toResultMap(racers);
    }

    public String gameResult(Racers racers) {
        Map<String, Integer> result = toResultMap(racers);
        int max = maxDistance(result);
        List<String> winnersName = winnerNames(result, max);
        return joinWinnerNames(winnersName);
    }

    private Map<String, Integer> toResultMap(Racers racers) {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < racers.getRacers().size(); i++) {
            result.put(racers.getRacers().get(i).getName(),
                    racers.getRacers().get(i).getDistance());
        }
        return result;
    }

    private int maxDistance(Map<String, Integer> result) {
        int max = 0;
        for (String name : result.keySet()) {
            int value = result.get(name);
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    private List<String> winnerNames(Map<String, Integer> result, int max) {
        List<String> winners = new ArrayList<>();
        for (String name : result.keySet()) {
            int value = result.get(name);
            if (max == value) {
                winners.add(name);
            }
        }
        return winners;
    }

    private String joinWinnerNames(List<String> winners) {
        String winnerNames = "";
        if (winners.size() > 1) {
            for (int i = 0; i < winners.size(); i++) {
                winnerNames = String.join(", ", winners);
            }
            return winnerNames;
        }
        winnerNames = winners.getFirst();
        return winnerNames;
    }
}
