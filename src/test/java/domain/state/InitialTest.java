package domain.state;

import domain.card.CardArea;
import org.junit.jupiter.api.*;

import static domain.card.CardValue.ACE;
import static domain.card.CardValue.TEN;
import static domain.fixture.CardFixture.diamond;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Initial 은")
class InitialTest {

    private final Initial initial = new Initial();

    @Nested
    class InitialDrawTwoCard_테스트 {

//        @Test
//        void 카드가_두_장이_아니면_오류() {
//            // given
//            final CardArea cardArea = new CardArea(diamond(TWO), diamond(TWO));
//            cardArea.addCard(diamond(TEN));
//
//            // when & then
//            assertThatThrownBy(() ->
//                    initial.initial(cardArea)
//            ).isInstanceOf(IllegalArgumentException.class);
//        }

        @Test
        void 블랙잭인_경우_BlackJack_반환() {
            // given
            final CardArea cardArea = new CardArea(diamond(TEN), diamond(ACE));

            // when & then
            assertThat(initial.initial(cardArea))
                    .isInstanceOf(BlackJack.class);
        }

        @Test
        void 이외의_경우_Hittable_반환() {
            // given
            final CardArea cardArea = new CardArea(diamond(TEN), diamond(TEN));

            // when & then
            assertThat(initial.initial(cardArea))
                    .isInstanceOf(Hittable.class);
        }
    }
}
