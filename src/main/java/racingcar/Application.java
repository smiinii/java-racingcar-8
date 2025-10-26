package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.moverule.MoveRule;
import racingcar.domain.moverule.RandomNumberRule;
import racingcar.domain.Result;
import racingcar.service.RacingGameService;
import racingcar.domain.Parser;
import racingcar.domain.generator.NumberGenerator;
import racingcar.domain.generator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Parser parser = new Parser();
        Result result = new Result();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        MoveRule moveRule = new RandomNumberRule(numberGenerator);

        RacingGameService racingService = new RacingGameService(parser, moveRule, result);
        RacingGameController racingController = new RacingGameController(inputView, outputView, racingService);

        racingController.run();
    }
}
