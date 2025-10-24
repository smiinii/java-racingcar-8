package racingcar.domain.racer;

public class RacingCar implements Racer {

    private static final int SPEED = 1;
    private final String carName;
    private final int distance;

    public RacingCar(String carName) {
        this.carName = carName;
        this.distance = 0;
    }

    public RacingCar(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    @Override
    public Racer move(int randomNumber) {
        if (randomNumber >= 4) {
            return new RacingCar(carName, distance + SPEED);
        }
        return this;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

}
