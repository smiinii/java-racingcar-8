package racingcar.service;

import racingcar.dto.RoundUpdate;
import racingcar.domain.moverule.MoveRule;
import racingcar.domain.racer.Racers;
import racingcar.domain.Result;
import racingcar.domain.Parser;

import java.util.List;
import java.util.Map;

public class RacingGameService {

    private final Parser parser;
    private final MoveRule moveRule;
    private final Result result;

    public RacingGameService(Parser parser, MoveRule moveRule, Result result) {
        this.parser = parser;
        this.moveRule = moveRule;
        this.result = result;
    }

    public List<String> parseInputs(String input) {
        return parser.parseCarNames(input);
    }

    public RoundUpdate roundStart(Racers racers) {
        Racers updateRacers = racers.moveAll(moveRule);
        Map<String, Integer> roundResult = result.roundResult(updateRacers);
        return new RoundUpdate(updateRacers, roundResult);
    }

    public String gameEnd(Racers racers) {
        return result.gameResult(racers);
    }
}
