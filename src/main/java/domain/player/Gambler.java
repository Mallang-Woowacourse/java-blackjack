package domain.player;

import domain.card.CardArea;

public class Gambler extends Participant {

    private final BettingMoney bettingMoney;

    public Gambler(final Name name, final CardArea cardArea, final BettingMoney bettingMoney) {
        super(name, cardArea);
        this.bettingMoney = bettingMoney;
    }

    public BettingMoney battingMoney() {
        return bettingMoney;
    }

    @Override
    public boolean hittable() {
        return state.hittable();
    }

    public boolean wantHit() {
        return state.hittable();
    }

    public void changeState(final HitState hitState) {
        if (hitState == HitState.STAY) {
            state = state.changeStay();
        }
    }

    public boolean isBlackJack() {
        return state.isBlackJack();
    }
}
