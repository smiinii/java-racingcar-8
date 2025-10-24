package racingcar.domain.racer;

import java.util.HashSet;
import java.util.List;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        validateCarNameDuplication(racingCars);
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    private void validateCarNameDuplication(List<RacingCar> racingCars) {
        long uniqueCarName = racingCars.stream().map(RacingCar::getCarName).distinct().count();
        if (uniqueCarName != racingCars.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복됩니다.");
        }
    }
}
