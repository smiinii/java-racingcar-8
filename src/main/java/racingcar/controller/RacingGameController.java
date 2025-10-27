package racingcar.controller;

import racingcar.domain.Round;
import racingcar.dto.RoundUpdate;
import racingcar.domain.racer.Racers;
import racingcar.domain.racer.RacingCars;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {

    private InputView inputView;
    private OutputView outputView;
    private RacingGameService racingService;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGameService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void run() {
        String input = inputView.readCarName();
        List<String> parseInputs = racingService.parseInputs(input);
        Racers racers = RacingCars.from(parseInputs);

        String roundCount = inputView.readRoundCount();
        Round round = Round.of(roundCount);

        racingStart(racers, round);
    }

    private void racingStart(Racers racers, Round round) {
        for (int i = 0; i < round.getRoundNumber(); i++) {
            RoundUpdate roundUpdate = racingService.roundStart(racers);
            racers = roundUpdate.getRacers();
            outputView.printRoundResult(roundUpdate.getRoundResult());
        }
        outputView.printGameResult(racingService.gameEnd(racers));
    }
}
