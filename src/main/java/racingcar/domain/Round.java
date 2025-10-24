package racingcar.domain;

public class Round {

    private final int roundNumber;

    public Round(String input) {
        validateEmpty(input);
        validateDigit(input);
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

    private void validateDigit(String input) {
        String target = input;
        if (input.startsWith("-")) {
            target = input.substring(1);
        }

        if (!target.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
