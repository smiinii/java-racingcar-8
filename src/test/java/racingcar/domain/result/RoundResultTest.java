package racingcar.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Result;
import racingcar.domain.Round;
import racingcar.domain.moverule.MoveRule;
import racingcar.domain.racer.Racer;
import racingcar.domain.racer.Racers;
import racingcar.domain.racer.RacingCar;
import racingcar.domain.racer.RacingCars;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundResultTest {

    @Test
    @DisplayName("각 라운드별 모든 자동차 이름 및 이동거리 확인")
    void roundResultTest() {
        // given
        MoveRule alwaysMove = () -> true;
        MoveRule neverMove = () -> false;

        List<Racer> racer = List.of(
                RacingCar.of("smini"),
                RacingCar.of("lsm"),
                RacingCar.of("sm")
        );
        Racers racers = new RacingCars(racer);
        Racers racers1 = new RacingCars(racer);
        Round round = Round.of("3");
        Result result = new Result();

        // when & then
        for (int i = 1; i < round.getRoundNumber() + 1; i++) {
            racers = racers.moveAll(alwaysMove);
            Map<String, Integer> roundResult = result.roundResult(racers);
            assertThat(roundResult).hasSize(3)
                    .containsEntry("smini", i)
                    .containsEntry("lsm", i)
                    .containsEntry("sm", i);
        }
        // when & then
        for (int i = 1; i < round.getRoundNumber() + 1; i++) {
            racers1 = racers1.moveAll(neverMove);
            Map<String, Integer> roundResult = result.roundResult(racers1);
            assertThat(roundResult).hasSize(3)
                    .containsEntry("smini", 0)
                    .containsEntry("lsm", 0)
                    .containsEntry("sm", 0);
        }
    }
}
