package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ParserTest {

    @Test
    @DisplayName("입력이 비어있으면 예외처리")
    void inputEmptyTest() {
        // given
        Parser parser = new Parser();
        // when & then
        assertThatThrownBy(() -> parser.parseCarNames(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> parser.parseCarNames(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구분자로 분리 확인")
    void inputGapRemoveTest() {
        // given
        Parser parser = new Parser();
        // when
        List<String> carNames = parser.parseCarNames("smini,sm");
        // then
        assertThat(carNames).containsExactly("smini", "sm");
    }

    @Test
    @DisplayName("분리된 자동차 이름 공백 제거 확인")
    void trimCarNameTest() {
        // given
        Parser parser = new Parser();
        // when
        List<String> carNames = parser.parseCarNames(" smini , sm ");
        // then
        assertThat(carNames).containsExactly("smini", "sm");
    }
}
