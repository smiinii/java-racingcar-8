package racingcar.domain.racer;

import racingcar.domain.moverule.MoveRule;
import racingcar.util.generator.NumberGenerator;

import java.util.List;

public interface Racers {
    Racers moveAll(MoveRule moverule);
    List<Racer> getRacers();
}
