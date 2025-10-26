package racingcar.domain.racer;

import racingcar.domain.moverule.MoveRule;

public class RacingCar implements Racer {

    private static final int SPEED = 1;
    private static final int MAX_CARNAME_LENGTH = 5;
    private static final String ALPHABETIC = "^[a-zA-Z]+$";

    private final String carName;
    private final int distance;

    public RacingCar(String carName) {
        validateCarNameIsAlphabetic(carName);
        validateCarNameLength(carName);
        this.carName = carName;
        this.distance = 0;
    }

    public RacingCar(String carName, int distance) {
        validateCarNameIsAlphabetic(carName);
        validateCarNameLength(carName);
        this.carName = carName;
        this.distance = distance;
    }

    @Override
    public Racer move(MoveRule moveRule) {
        if (!moveRule.canMove()) {
            return this;
        }
        return new RacingCar(carName, distance + SPEED);
    }

    @Override
    public String getName() {
        return carName;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    private void validateCarNameIsAlphabetic(String carName) {
        if (!carName.matches(ALPHABETIC)) {
            throw new IllegalArgumentException("자동차 이름은 영어만 허용합니다.");
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CARNAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
