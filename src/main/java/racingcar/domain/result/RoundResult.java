package racingcar.domain.result;

import racingcar.domain.racer.Racers;

import java.util.LinkedHashMap;
import java.util.Map;

public class RoundResult {

    public Map<String, Integer> addRoundResult(Racers racers) {
        Map<String, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < racers.getRacers().size(); i++) {
            result.put(racers.getRacers().get(i).getName(),
                    racers.getRacers().get(i).getDistance());
        }
        return result;
    }
}
