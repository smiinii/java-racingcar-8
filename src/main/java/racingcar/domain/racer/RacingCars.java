package racingcar.domain.racer;

import racingcar.util.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class RacingCars implements Racers {

    private final List<Racer> racers;

    public RacingCars(List<Racer> racingCars) {
        List<Racer> racingCarsCopy = List.copyOf(racingCars);
        validateCarNameDuplication(racingCarsCopy);
        this.racers = racingCarsCopy;
    }

    @Override
    public Racers moveAll(NumberGenerator numberGenerator) {
        List<Racer> newRacers = new ArrayList<>();
        for (Racer racer : racers) {
            newRacers.add(racer.move(numberGenerator));
        }
        return new RacingCars(newRacers);
    }

    @Override
    public List<Racer> getRacers() {
        return racers;
    }

    private void validateCarNameDuplication(List<Racer> racingCars) {
        long uniqueCarName = racingCars.stream().map(Racer::getName).distinct().count();
        if (uniqueCarName != racingCars.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복됩니다.");
        }
    }
}
