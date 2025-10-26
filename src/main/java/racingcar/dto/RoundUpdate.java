package racingcar.dto;

import racingcar.domain.racer.Racers;

import java.util.Map;

public class RoundUpdate {

    private Racers racers;
    private Map<String, Integer> roundResult;

    public RoundUpdate(Racers racers, Map<String, Integer> roundResult) {
        this.racers = racers;
        this.roundResult = roundResult;
    }

    public Map<String, Integer> getRoundResult() {
        return roundResult;
    }

    public Racers getRacers() {
        return racers;
    }
}
