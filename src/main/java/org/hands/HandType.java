package org.hands;

import org.PokerHand;

public interface HandType {
    public boolean isValid(PokerHand hand);
    public int getValue(); 
}
