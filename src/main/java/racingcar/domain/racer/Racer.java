package racingcar.domain.racer;

public interface Racer {
    String getName();
    int getDistance();
    Racer move(int randomNumber);
}
