package racingcar.util.generator;

public class FixedNumberGenerator implements NumberGenerator {
    private final int number;

    public FixedNumberGenerator(int n) {
        this.number = n;
    }

    @Override
    public int getNumber() {
        return number;
    }
}
