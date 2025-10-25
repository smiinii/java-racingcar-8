package racingcar.domain.racer;

import racingcar.domain.moverule.MoveRule;
import racingcar.util.generator.NumberGenerator;

public interface Racer {
    String getName();
    int getDistance();
    Racer move(MoveRule moveRule);
}
