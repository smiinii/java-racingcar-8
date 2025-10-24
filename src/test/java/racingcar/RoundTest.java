package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Round;

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
}
