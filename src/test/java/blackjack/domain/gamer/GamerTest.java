package blackjack.domain.gamer;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardNumber;
import blackjack.domain.card.CardShape;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GamerTest {

    @Test
    @DisplayName("카드를 추가한다.")
    void addCard() {
        Gamer player = new Player("name");
        player.addCard(new Card(CardShape.DIAMOND, CardNumber.ACE));
        List<Card> cards = player.getCards();
        assertThat(cards.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("보유 카드 번호 합 반환")
    void calculateCardsNumberSum() {
        Gamer player = new Player("name");
        Card card1 = new Card(CardShape.SPADE, CardNumber.TEN);
        Card card2 = new Card(CardShape.SPADE, CardNumber.FIVE);
        player.addCard(card1);
        player.addCard(card2);
        int sum = player.getCardsNumberSum();
        assertThat(sum).isEqualTo(15);
    }

    @Test
    @DisplayName("Ace가 1로 계산된 보유 카드 번호 합 반환")
    void calculateCardsNumberSumWithAceOne() {
        Gamer player = new Player("name");
        Card card1 = new Card(CardShape.SPADE, CardNumber.NINE);
        Card card2 = new Card(CardShape.SPADE, CardNumber.QUEEN);
        Card card3 = new Card(CardShape.SPADE, CardNumber.ACE);
        player.addCard(card1);
        player.addCard(card2);
        player.addCard(card3);
        int sum = player.getCardsNumberSum();
        assertThat(sum).isEqualTo(20);
    }

    @Test
    @DisplayName("Ace가 11로 계산된 보유 카드 번호 합 반환")
    void calculateCardsNumberSumWithAceEleven() {
        Gamer player = new Player("name");
        Card card1 = new Card(CardShape.SPADE, CardNumber.JACK);
        Card card2 = new Card(CardShape.SPADE, CardNumber.ACE);

        player.addCard(card1);
        player.addCard(card2);

        int sum = player.getCardsNumberSum();
        assertThat(sum).isEqualTo(21);
    }

    @Test
    @DisplayName("Ace가 4장일 때 보유 카드 번호 합 반환")
    void calculateCardsNumberSumWithFourAce() {
        Gamer player = new Player("name");
        Card card1 = new Card(CardShape.SPADE, CardNumber.ACE);
        Card card2 = new Card(CardShape.SPADE, CardNumber.ACE);
        Card card3 = new Card(CardShape.SPADE, CardNumber.ACE);
        Card card4 = new Card(CardShape.SPADE, CardNumber.ACE);

        player.addCard(card1);
        player.addCard(card2);
        player.addCard(card3);
        player.addCard(card4);

        int sum = player.getCardsNumberSum();
        assertThat(sum).isEqualTo(14);
    }
}