package racingcar.controller;

import racingcar.domain.Round;
import racingcar.domain.racer.Racer;
import racingcar.domain.racer.Racers;
import racingcar.domain.racer.RacingCar;
import racingcar.domain.racer.RacingCars;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<String> inputList = racingService.parseInputs(input);

        String roundCount = inputView.readRoundCount();
        Round round = new Round(roundCount);

        List<Racer> racerList = makeRacer(inputList);
        Racers racers = new RacingCars(racerList);

        racingStart(racers, round);
    }

    private List<Racer> makeRacer(List<String> inputList) {
        List<Racer> racerList = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            racerList.add(new RacingCar(inputList.get(i)));
        }
        return racerList;
    }

    private void racingStart(Racers racers, Round round) {
        for (int i = 0; i < round.getRoundNumber(); i++) {
            Map<String, Integer> roundResult = racingService.roundStart(racers);
            outputView.printRoundResult(roundResult);
        }
        outputView.printGameResult(racingService.gameEnd(racers));
    }
}
