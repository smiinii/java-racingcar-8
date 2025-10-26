package racingcar.domain.moverule;

import racingcar.domain.generator.NumberGenerator;

public class RandomNumberRule implements MoveRule{

    private static final int MOVE_CONDITION = 4;
    private final NumberGenerator numberGenerator;

    public RandomNumberRule(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean canMove() {
        return numberGenerator.getNumber() >= MOVE_CONDITION;
    }
}
