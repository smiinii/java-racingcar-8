package racingcar.domain.racer;

import racingcar.util.generator.NumberGenerator;

import java.util.List;

public interface Racers {
    Racers moveAll(NumberGenerator numberGenerator);
    List<Racer> getRacers();
}
