package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
