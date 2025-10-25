package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.moverule.MoveRule;
import racingcar.domain.moverule.RandomNumberRule;
import racingcar.domain.result.Result;
import racingcar.service.RacingService;
import racingcar.util.Parser;
import racingcar.util.generator.NumberGenerator;
import racingcar.util.generator.RandomNumberGenerator;
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

        RacingService racingService = new RacingService(parser, moveRule, result);
        RacingController racingController = new RacingController(inputView, outputView, racingService);

        racingController.run();
    }
}
