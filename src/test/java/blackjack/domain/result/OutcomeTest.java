package blackjack.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutcomeTest {

    @DisplayName("정적 팩터리")
    @Test
    void calculateWinPlayerMoreThanDealer() {
        CardsResult bust = new CardsResult(22);
        CardsResult twentyOne = new CardsResult(21);
        CardsResult twenty = new CardsResult(20);
        CardsResult nineteen = new CardsResult(19);

        assertThat(Outcome.of(twenty, nineteen)).isEqualTo(Outcome.PLAYER_WIN);
        assertThat(Outcome.of(bust, twentyOne)).isEqualTo(Outcome.PLAYER_LOSE);

        assertThat(Outcome.of(twenty, twenty)).isEqualTo(Outcome.PLAYER_DRAW);
        assertThat(Outcome.of(bust, bust)).isEqualTo(Outcome.PLAYER_LOSE);

        assertThat(Outcome.of(twenty, twentyOne)).isEqualTo(Outcome.PLAYER_LOSE);
        assertThat(Outcome.of(twenty, bust)).isEqualTo(Outcome.PLAYER_WIN);
    }
}