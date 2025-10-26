package racingcar.service;

import racingcar.domain.moverule.MoveRule;
import racingcar.domain.racer.Racers;
import racingcar.domain.Result;
import racingcar.domain.Parser;

import java.util.List;
import java.util.Map;

public class RacingService {

    private final Parser parser;
    private final MoveRule moveRule;
    private final Result result;

    public RacingService(Parser parser, MoveRule moveRule, Result result) {
        this.parser = parser;
        this.moveRule = moveRule;
        this.result = result;
    }

    public List<String> parseInputs(String input) {
        return parser.parseCarNames(input);
    }

    public Map<String, Integer> roundStart(Racers racers) {
        racers = racers.moveAll(moveRule);
        return result.roundResult(racers);
    }

    public String gameEnd(Racers racers) {
        return result.gameResult(racers);
    }
}
