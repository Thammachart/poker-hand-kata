package poker.hands.checkers;

import poker.hands.PokerHand;

public interface PokerHandChecker {
    public boolean isValid(PokerHand hand);
    public int getValue(); 
}
