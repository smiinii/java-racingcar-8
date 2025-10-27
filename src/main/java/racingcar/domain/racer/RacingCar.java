package racingcar.domain.racer;

import racingcar.domain.moverule.MoveRule;

public class RacingCar implements Racer {

    private static final int INITIAL_RACER_POSITION = 0;
    private static final int SPEED = 1;
    private static final int MAX_CARNAME_LENGTH = 5;
    private static final String ALPHABETIC = "^[a-zA-Z]+$";

    private final String carName;
    private final int distance;

    private RacingCar(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public static RacingCar of(String carName) {
        validateCarNameIsAlphabetic(carName);
        validateCarNameLength(carName);
        return new RacingCar(carName, INITIAL_RACER_POSITION);
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

    private static void validateCarNameIsAlphabetic(String carName) {
        if (!carName.matches(ALPHABETIC)) {
            throw new IllegalArgumentException("자동차 이름은 영어만 허용합니다.");
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CARNAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
