package racingcar.domain.racer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    @Test
    @DisplayName("자동차 이름이 중복되면 예외처리")
    void carNameDuplicationTest() {
        List<RacingCar> racingCars = List.of(
                new RacingCar("smini"),
                new RacingCar("smini"),
                new RacingCar("sm")
        );
        // given & then
        assertThatThrownBy(() -> new RacingCars(racingCars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 중복되지 않으면 통과")
    void carNameDuplicationTest2() {
        // given
        List<RacingCar> racingCars = List.of(
                new RacingCar("smini"),
                new RacingCar("lsm"),
                new RacingCar("sm")
        );
        // when & then
        new RacingCars(racingCars);
    }
}
