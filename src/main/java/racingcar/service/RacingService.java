package racingcar.service;

import racingcar.domain.racer.Racers;
import racingcar.domain.result.Result;
import racingcar.util.Parser;
import racingcar.util.generator.NumberGenerator;

import java.util.List;
import java.util.Map;

public class RacingService {

    private final Parser parser;
    private final NumberGenerator numberGenerator;
    private final Result result;

    public RacingService(Parser parser, NumberGenerator numberGenerator, Result result) {
        this.parser = parser;
        this.numberGenerator = numberGenerator;
        this.result = result;
    }

    public List<String> parseInputs(String input) {
        return parser.parseCarNames(input);
    }

    public Map<String, Integer> roundStart(Racers racers) {
        racers = racers.moveAll(numberGenerator);
        return result.roundResult(racers);
    }

    public String gameEnd(Racers racers) {
        return result.gameResult(racers);
    }
}
