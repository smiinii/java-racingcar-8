package racingcar.domain.racer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("자동차 이름이 영어가 아닐시 예외처리")
    void carNameIsAlphabeticTest() {
        // given & when & then
        assertThatThrownBy(() -> new RacingCar("123"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RacingCar("성민"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RacingCar("!!!"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RacingCar("smini1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RacingCar("smini!"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 영어면 통과")
    void carNameIsAlphabeticTest2() {
        // given
        RacingCar racer = new RacingCar("smini");
        // then
        assertThat(racer.getName()).isEqualTo("smini");
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과시 예외처리")
    void carNameLengthTest() {
        // given & when & then
        assertThatThrownBy(() -> new RacingCar("smiinii"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하면 통과")
    void carNameLengthTest2() {
        // given
        RacingCar racer = new RacingCar("smini");
        // then
        assertThat(racer.getName()).isEqualTo("smini");
    }
}
