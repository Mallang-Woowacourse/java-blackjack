package domain.state;

import domain.card.CardArea;
import org.junit.jupiter.api.*;

import static domain.card.CardValue.*;
import static domain.fixture.CardFixture.diamond;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Hittable 은")
class HittableTest {

    @Nested
    class Hit_테스트 {

        @Test
        void 합이_21_미만인_경우_계속해서_Hittable() {
            // given
            final CardArea cardArea = new CardArea(diamond(TEN), diamond(TWO));
            final Initial initial = new Initial();
            final BlackJackGameStateInterface state = initial.initial(cardArea);

            // when
            final BlackJackGameStateInterface after = state.hit(diamond(EIGHT));

            // then
            assertThat(after)
                    .isInstanceOf(Hittable.class);
        }

        @Test
        void 합이_21_인_경우_Stay() {
            // given
            final CardArea cardArea = new CardArea(diamond(TEN), diamond(TWO));
            final Initial initial = new Initial();
            final BlackJackGameStateInterface state = initial.initial(cardArea);

            // when
            final BlackJackGameStateInterface after = state.hit(diamond(NINE));

            // then
            assertThat(after)
                    .isInstanceOf(Stay.class);
        }

        @Test
        void 합이_21_초과인_경우_Bust() {
            // given
            final CardArea cardArea = new CardArea(diamond(TEN), diamond(TWO));
            final Initial initial = new Initial();
            final BlackJackGameStateInterface state = initial.initial(cardArea);

            // when
            final BlackJackGameStateInterface after = state.hit(diamond(TEN));

            // then
            assertThat(after)
                    .isInstanceOf(Bust.class);
        }
    }

    @Test
    void Stay_로_상태를_변환할_수_있다() {
        // given
        final CardArea cardArea = new CardArea(diamond(TEN), diamond(TWO));
        final Initial initial = new Initial();
        final BlackJackGameStateInterface state = initial.initial(cardArea);

        // when
        final BlackJackGameStateInterface after = state.changeStay();

        // then
        assertThat(after).isInstanceOf(Stay.class);
    }
}
