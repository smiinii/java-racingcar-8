package racingcar.domain.racer;

import java.util.List;

public interface Racers {
    Racers moveAll(int randomNumber);
    List<Racer> getRacers();
}
