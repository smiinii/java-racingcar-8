package racingcar.domain.racer;

import racingcar.domain.moverule.MoveRule;

public interface Racer {
    String getName();
    int getDistance();
    Racer move(MoveRule moveRule);
}
