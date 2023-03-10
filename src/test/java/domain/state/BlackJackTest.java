package domain.state;

import domain.card.CardArea;
import domain.player.BettingMoney;
import domain.player.Revenue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static domain.card.CardValue.ACE;
import static domain.card.CardValue.TEN;
import static domain.fixture.CardFixture.diamond;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("BlackJack 은")
class BlackJackTest {

    @Test
    void 상금은_블랙잭_상금이다() {
        // given
        final CardArea cardArea = new CardArea(diamond(TEN), diamond(ACE));
        final Initial initial = new Initial();
        final BlackJackGameState state = initial.initialDrawTwoCard(cardArea);

        // when
        final Revenue revenue = state.revenue(BettingMoney.of(10000));

        // then
        assertThat(revenue).isEqualTo(Revenue.blackJackWin(BettingMoney.of(10000)));
    }
}
