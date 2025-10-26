package racingcar.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Result;
import racingcar.domain.moverule.MoveRule;
import racingcar.domain.racer.Racer;
import racingcar.domain.racer.Racers;
import racingcar.domain.racer.RacingCar;
import racingcar.domain.racer.RacingCars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    @DisplayName("우승자가 한명일 경우")
    void gameResultTest() {
        // given
        MoveRule alwaysMove = () -> true;

        Racer smini = RacingCar.of("smini");
        for (int i = 0; i < 5; i++) smini = smini.move(alwaysMove);

        Racer lsm = RacingCar.of("lsm");
        for (int i = 0; i < 3; i++) lsm = lsm.move(alwaysMove);

        Racer sm = RacingCar.of("sm");
        for (int i = 0; i < 1; i++) sm = sm.move(alwaysMove);

        Racers racers = new RacingCars(List.of(smini, lsm, sm));
        Result result = new Result();

        // when
        String gameResult = result.gameResult(racers);

        // then
        assertThat(gameResult).isEqualTo("smini");
    }

    @Test
    @DisplayName("우승자가 여러명일 경우")
    void gameResultTest2() {
        // given
        MoveRule alwaysMove = () -> true;

        Racer smini = RacingCar.of("smini");
        for (int i = 0; i < 5; i++) smini = smini.move(alwaysMove);

        Racer lsm = RacingCar.of("lsm");
        for (int i = 0; i < 5; i++) lsm = lsm.move(alwaysMove);

        Racer sm = RacingCar.of("sm");
        for (int i = 0; i < 3; i++) sm = sm.move(alwaysMove);

        Racers racers = new RacingCars(List.of(smini, lsm, sm));
        Result result = new Result();

        // when
        String gameResult = result.gameResult(racers);

        // then
        assertThat(gameResult).isEqualTo("smini, lsm");
    }
}
