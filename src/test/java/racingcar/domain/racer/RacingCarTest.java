package racingcar.domain.racer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("무작위 값이 4 이상일 경우 전진")
    void carMoveTest() {
        // given
        Racer racer = new RacingCar("smini");
        // when
        RacingCar moveRacer = (RacingCar)racer.move(4);
        // then
        assertThat(moveRacer.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("무작위 값이 4 미만일 경우 정지")
    void carStopTest() {
        // given
        Racer racer = new RacingCar("smini");
        // when
        RacingCar stopRacer = (RacingCar)racer.move(3);
        // then
        assertThat(stopRacer.getDistance()).isEqualTo(0);
    }
}
