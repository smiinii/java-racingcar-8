package racingcar.view;

import racingcar.domain.racer.Racers;

import java.util.Map;

public class OutputView {

    public void printRoundResult(Map<String, Integer> roundResult) {
        System.out.println("실행 결과");
        for (String name : roundResult.keySet()) {
            int distance = roundResult.get(name);
            String distanceBar = "-".repeat(distance);
            System.out.println(name + " : " + distanceBar);
        }
        System.out.println();
    }

    public void printGameResult(String gameResult) {
        System.out.println( "최종 우승자 : " + gameResult);
    }
}
