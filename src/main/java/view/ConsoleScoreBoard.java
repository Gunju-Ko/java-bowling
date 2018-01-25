package view;

import domain.ScoreBoard;
import domain.frame.BowlingGame;

public class ConsoleScoreBoard implements ScoreBoard {

    @Override
    public void printGameResult(BowlingGame bowlingGame) {
        printHeader();
        System.out.println(bowlingGame);
        System.out.println(bowlingGame.getUpdatedScoreResult());
    }

    private void printHeader() {
        System.out.println("| NAME | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10  |");
    }
}
