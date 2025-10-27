package racingcar.domain.racer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {

    @Test
    @DisplayName("자동차 이름이 중복되면 예외처리")
    void carNameDuplicationTest() {
        List<String> racingCars = List.of("smini", "smini", "sm");
        // given & then
        assertThatThrownBy(() -> RacingCars.from(racingCars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 중복되지 않으면 통과")
    void carNameDuplicationTest2() {
        // given
        List<String> racingCars = List.of("smini", "lsm", "sm");
        // when & then
        RacingCars.from(racingCars);
    }
}
