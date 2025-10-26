package racingcar.domain;

public class Round {

    private static final String NEGATIVE_SIGN = "-";
    private static final int SIGN_OFFSET = 1;
    private final int roundNumber;

    private Round(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public static Round of(String input) {
        validateEmpty(input);
        validateDigit(input);
        validatePositive(input);
        return new Round(Integer.parseInt(input));
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    private static void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
    }

    private static void validateDigit(String input) {
        String target = input;
        if (input.startsWith(NEGATIVE_SIGN)) {
            target = input.substring(SIGN_OFFSET);
        }

        if (!target.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private static void validatePositive(String input) {
        if (input.startsWith(NEGATIVE_SIGN)) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }
}
