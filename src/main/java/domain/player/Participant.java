package domain.player;

import domain.card.BlackJackScore;
import domain.card.CardArea;
import domain.card.CardDeck;
import domain.state.BlackJackGameStateInterface;
import domain.state.Initial;

public abstract class Participant {

    protected final Name name;
    protected BlackJackGameStateInterface state;

    protected Participant(final Name name, final CardArea cardArea) {
        this.name = name;
        final Initial initial = new Initial();
        state = initial.initial(cardArea);
    }

    public Name name() {
        return name;
    }

    public CardArea cardArea() {
        return state.cardArea();
    }

    public String nameValue() {
        return name.value();
    }

    public boolean isBust() {
        return state.isBust();
    }

    public void hit(final CardDeck cardDeck) {
        state = state.hit(cardDeck.draw());
    }

    public abstract boolean hittable();

    public BlackJackScore score() {
        return state.score();
    }

    protected boolean isLargerScoreThan(final Participant participant) {
        return score().isLargerThan(participant.score());
    }
}
