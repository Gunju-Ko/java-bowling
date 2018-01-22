package domain.frame;

import domain.CustomPlayStrategy;
import domain.Referee;
import domain.score.FirstScore;
import domain.score.SecondScore;
import domain.score.TotalScore;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalFrameTest {

    private Referee referee;

    @Before
    public void setUp() throws Exception {
        referee = new Referee(new CustomPlayStrategy(new FirstScore(3),
                                                     new SecondScore(3, 7)));
    }

    @Test
    public void playNextFrame() throws Exception {
        NormalFrame normalFrame = new NormalFrame(new TotalScore(3, 5), 3);

        assertThat(normalFrame.playNextFrame(referee).isPresent()).isTrue();

        Frame nextFrame = normalFrame.playNextFrame(referee).get();
        assertThat(nextFrame instanceof NormalFrame).isTrue();
    }

    @Test
    public void playNextFrame_9번째프레임() throws Exception {
        NormalFrame normalFrame = new NormalFrame(new TotalScore(3, 5), 9);

        assertThat(normalFrame.playNextFrame(referee).isPresent()).isTrue();

        Frame nextFrame = normalFrame.playNextFrame(referee).get();
        assertThat(nextFrame instanceof FinalFrame).isTrue();
    }
}