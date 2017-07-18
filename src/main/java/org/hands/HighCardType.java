package org.hands;

import org.PokerHand;

public class HighCardType implements HandType {
    @Override
    public boolean isValid(PokerHand hand) {
        // TODO
        return true;
    }

    @Override
    public int getValue() {
        return HandTypeValue.HIGHCARD.ordinal();
    }
}