package racingcar.domain;

public class Round {

    private final int roundNumber;

    public Round(String input) {
        validateEmpty(input);
        this.roundNumber = Integer.parseInt(input);
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    private void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
    }
}
