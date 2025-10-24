package racingcar.util;

import java.util.List;

public class Parser {

    public List<String> parseCarNames(String inputs) {
        validateEmpty(inputs);
        return null;
    }

    private void validateEmpty(String inputs) {
        if (inputs == null || inputs.isBlank()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
    }

}
