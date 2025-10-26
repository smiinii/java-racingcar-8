package racingcar.domain.racer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.moverule.MoveRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    @DisplayName("이동 규칙이 true일 경우 전진")
    void carMoveTest() {
        // given
        Racer racer = RacingCar.of("smini");
        MoveRule alwaysMove = () -> true;
        // when
        RacingCar moveRacer = (RacingCar)racer.move(alwaysMove);
        // then
        assertThat(moveRacer.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("이동 규칙이 false일 경우 정지")
    void carStopTest() {
        // given
        Racer racer = RacingCar.of("smini");
        MoveRule neverMove = () -> false;
        // when
        RacingCar stopRacer = (RacingCar)racer.move(neverMove);
        // then
        assertThat(stopRacer.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름이 영어가 아닐시 예외처리")
    void carNameIsAlphabeticTest() {
        // given & when & then
        assertThatThrownBy(() -> RacingCar.of("123"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> RacingCar.of("성민"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> RacingCar.of("!!!"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> RacingCar.of("smini1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> RacingCar.of("smini!"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 영어면 통과")
    void carNameIsAlphabeticTest2() {
        // given
        RacingCar racer = RacingCar.of("smini");
        // then
        assertThat(racer.getName()).isEqualTo("smini");
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과시 예외처리")
    void carNameLengthTest() {
        // given & when & then
        assertThatThrownBy(() -> RacingCar.of("smiinii"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 이름이 5자 이하면 통과")
    void carNameLengthTest2() {
        // given
        RacingCar racer = RacingCar.of("smini");
        // then
        assertThat(racer.getName()).isEqualTo("smini");
    }
}
