package racingcar.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("난수 생성기는 0 이상 9 이하의 수를 반환한다")
    void generateNumberWithinRange() {
        // given
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        // when & then
        for (int i = 0; i < 1000; i++) {
            int number = numberGenerator.getNumber();
            assertThat(number).isBetween(0, 9);
        }
    }


}
