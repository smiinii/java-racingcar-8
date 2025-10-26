package racingcar.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Result;
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
        List<Racer> racer = List.of(
                new RacingCar("smini", 3),
                new RacingCar("lsm", 2),
                new RacingCar("sm", 1)
        );
        Racers racers = new RacingCars(racer);
        Result result = new Result();
        // when & then
        String gameResult = result.gameResult(racers);
        assertThat(gameResult).isEqualTo("smini");
    }

    @Test
    @DisplayName("우승자가 여러명일 경우")
    void gameResultTest2() {
        // given
        List<Racer> racer = List.of(
                new RacingCar("smini", 3),
                new RacingCar("lsm", 3),
                new RacingCar("sm", 1)
        );
        Racers racers = new RacingCars(racer);
        Result result = new Result();
        // when & then
        String gameResult = result.gameResult(racers);
        assertThat(gameResult).isEqualTo("smini, lsm");
    }
}
