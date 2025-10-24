package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ParserTest {

    @Test
    @DisplayName("입력이 비어있으면 예외처리")
    void inputEmpty() {
        // given
        Parser parser = new Parser();
        // when & then
        assertThatThrownBy(() -> parser.parseCarNames(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> parser.parseCarNames(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
