package domain.frame;

import domain.Referee;
import domain.score.TotalScore;

import java.util.Optional;

public class BonusFrame extends Frame {

    BonusFrame(TotalScore totalScore, int frameNo) {
        super(totalScore, frameNo);
        if (frameNo != 11 && frameNo != 12) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Optional<Frame> playNextFrame(Referee referee) {
        if (frameNo != 11) {
            return Optional.empty();
        }
        if (totalScore.isStrike()) {
            return Optional.of(new BonusFrame(referee.playNextFrame(), frameNo + 1));
        }
        if (totalScore.isNeedAdditionalScore()) {
            return Optional.of(new BonusFrame(referee.playOnlyFirst(), frameNo + 1));
        }
        return Optional.empty();
    }
}

