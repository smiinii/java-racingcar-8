package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Round;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {

    @Test
    @DisplayName("입력 값이 비어있으면 예외처리")
    void inputEmptyTest() {
        // given & when & then
        assertThatThrownBy(() -> new Round(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Round("  "))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("숫자가 아니면 예외처리")
    void validateDigitTest() {
        // given & when & then
        assertThatThrownBy(() -> new Round("a"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Round("^"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 맞으면 통과")
    void trueDigitTest() {
        // given
        Round positiveRound = new Round("10");
        Round NngativeRound = new Round("-10");
        // then
        assertThat(positiveRound.getRoundNumber()).isEqualTo(10);
        assertThat(NngativeRound.getRoundNumber()).isEqualTo(-10);
    }

    @Test
    @DisplayName("음수면 예외처리")
    void notNegativeTest() {
        // given & when & then
        assertThatThrownBy(() -> new Round("-10"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 입력시 통과")
    void roundTest() {
        // given
        Round round = new Round("10");
        // then
        assertThat(round.getRoundNumber()).isEqualTo(10);
    }
}
