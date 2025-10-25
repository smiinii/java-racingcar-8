package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.Round;
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

        RacingService racingService = new RacingService(parser, numberGenerator, result);
        RacingController racingController = new RacingController(inputView, outputView, racingService);

        racingController.run();
    }
}
