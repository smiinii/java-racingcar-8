package racingcar.view;

import racingcar.domain.racer.Racers;

import java.util.Map;

public class OutputView {

    public void printRoundResult(Map<String, Integer> roundResult) {
        System.out.println("실행 결과");
        for(int i = 0; i < roundResult.size(); i++) {
            roundResult.forEach((k, v) -> System.out.println(k + " : " + v));
        }
    }

    public void printGameResult(String gameResult) {
        System.out.println( "최종 우승자 : " + gameResult);
    }
}
