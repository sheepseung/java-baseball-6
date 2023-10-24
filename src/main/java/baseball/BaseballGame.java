package baseball;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

import static baseball.NumberInfo.*;
import static baseball.Message.*;
public class BaseballGame {
    private final ComputerFunction computerFunction;

    public BaseballGame(ComputerFunction computerFunction) {
        this.computerFunction = computerFunction;
    }

    public void run(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true) {
            playGame();

            if(askRestartGame()){
                continue;
            }
            break;
        }
    }

    private void playGame(){
        List<Integer> randomNumberlist = computerFunction.createRandomNumber();
        computerFunction.countCalculate(randomNumberlist);
    }

    private boolean askRestartGame(){
        System.out.println(RESTART_QUESTION_MESSAGE.getMessage());
        String cmd = Console.readLine();
        int restart = Integer.parseInt(cmd);

        if(restart == RESTART_TRUE.getNumberInfo()){
            return true;
        }
        else if(restart == RESTART_FALSE.getNumberInfo()){
            return false;
        }

        throw new IllegalArgumentException("재시작을 원하시면 1, 종료를 원하시면 2를 입력하세요.");
    }
}