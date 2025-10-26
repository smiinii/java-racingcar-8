package racingcar.domain;

import java.util.List;

public class Parser {

    private static final String DELIMITER = ",";

    public List<String> parseCarNames(String inputs) {
        validateEmpty(inputs);
        List<String> notTrimCarNames = inputSplit(inputs);
        List<String> carNames = trimCarNames(notTrimCarNames);
        validateCarNamesEmpty(carNames);
        return carNames;
    }

    private void validateEmpty(String inputs) {
        if (inputs == null || inputs.isBlank()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
    }

    private List<String> inputSplit(String inputs) {
        return List.of(inputs.split(DELIMITER));
    }

    private List<String> trimCarNames(List<String> carNames) {
        return carNames.stream().map(String::trim).toList();
    }

    private void validateCarNamesEmpty(List<String> inputs) {
        if (inputs.stream().anyMatch(String::isEmpty)) {
            throw new IllegalArgumentException("자동차 이름을 미입력 하였습니다.");
        }
    }
}
