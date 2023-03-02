package domain.area;

import domain.card.Card;
import domain.participant.Participant;

public class ParticipantCardArea extends CardArea {

    private final Participant participant;

    public ParticipantCardArea(final Card firstCard, final Card secondCard, final Participant participant) {
        super(firstCard, secondCard);
        this.participant = participant;
    }

    public ParticipantCardArea(final Card firstCard, final Card secondCard) {
        super(firstCard, secondCard);
        this.participant = null;
    }

    @Override
    public boolean wantHit() {
        return participant.wantHit();
    }

    public Participant participant() {
        return participant;
    }
}
