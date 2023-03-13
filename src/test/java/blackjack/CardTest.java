package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static blackjack.Card.of;
import static blackjack.Denomination.ACE;
import static blackjack.Suit.CLOVER;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Card 은")
public class CardTest {

    @Test
    void 캐싱된다() {
        // when
        final Card card = Card.of(CLOVER, ACE);

        // then
        assertThat(Card.of(CLOVER, ACE)).
                isSameAs(card);
    }

    @Test
    void 점수() {
        // given
        final Card card = Card.of(CLOVER, ACE);

        // when
        assertThat(card.score()).isEqualTo(1);
    }
}
