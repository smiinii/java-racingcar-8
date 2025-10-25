package racingcar.domain.racer;

import racingcar.util.generator.NumberGenerator;

public interface Racer {
    String getName();
    int getDistance();
    Racer move(NumberGenerator numberGenerator);
}
