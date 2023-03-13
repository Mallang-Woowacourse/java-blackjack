package blackjack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Hand 은")
public class HandTest {

    @Test
    void 생성() {
        // when & then
        assertDoesNotThrow(() -> new Hand());
    }

    @Test
    void twoTen() {
        // given
        final Hand hand = new Hand(
                Card.of(Suit.DIAMOND, Denomination.TWO),
                Card.of(Suit.DIAMOND, Denomination.TEN)
        );

        // when
        final int score = hand.calculate().value();

        // then
        assertThat(score).isEqualTo(12);
    }

    @Test
    void twoThreeFour() {
        // given
        final Hand hand = new Hand(
                Card.of(Suit.DIAMOND, Denomination.TWO),
                Card.of(Suit.DIAMOND, Denomination.THREE),
                Card.of(Suit.DIAMOND, Denomination.FOUR)
        );

        // when
        final int score = hand.calculate().value();

        // then
        assertThat(score).isEqualTo(9);
    }

    // ace 2 -> 13
    @Test
    void ace_two() {
        // given
        final Hand hand = new Hand(
                Card.of(Suit.DIAMOND, Denomination.ACE),
                Card.of(Suit.DIAMOND, Denomination.TWO)
        );

        // when
        final int score = hand.calculate().value();

        // then
        assertThat(score).isEqualTo(13);
    }

    // ace 10 -> 21
    @Test
    void ace_ten() {
        // given
        final Hand hand = new Hand(
                Card.of(Suit.DIAMOND, Denomination.ACE),
                Card.of(Suit.DIAMOND, Denomination.TEN)
        );

        // when
        final int score = hand.calculate().value();

        // then
        assertThat(score).isEqualTo(21);
    }

    // ace ace -> 12
    @Test
    void ace_ace() {
        // given
        final Hand hand = new Hand(
                Card.of(Suit.DIAMOND, Denomination.ACE),
                Card.of(Suit.DIAMOND, Denomination.ACE)
        );

        // when
        final int score = hand.calculate().value();

        // then
        assertThat(score).isEqualTo(12);
    }

    // ace ace ace ace -> 14
    @Test
    void ace_ace_ace_Ace() {
        // given
        final Hand hand = new Hand(
                Card.of(Suit.DIAMOND, Denomination.ACE),
                Card.of(Suit.DIAMOND, Denomination.ACE),
                Card.of(Suit.DIAMOND, Denomination.ACE),
                Card.of(Suit.DIAMOND, Denomination.ACE)
        );

        // when
        final int score = hand.calculate().value();

        // then
        assertThat(score).isEqualTo(14);
    }

    // ten + ten + ace -> 21
    @Test
    void ten_ten_ace() {
        // given
        final Hand hand = new Hand(
                Card.of(Suit.DIAMOND, Denomination.TEN),
                Card.of(Suit.DIAMOND, Denomination.TEN),
                Card.of(Suit.DIAMOND, Denomination.ACE)
        );

        // when
        final int score = hand.calculate().value();

        // then
        assertThat(score).isEqualTo(21);
    }
}
