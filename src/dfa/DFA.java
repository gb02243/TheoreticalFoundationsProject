package dfa;

import java.util.LinkedList;

public class DFA {
    State start;
    State currentPos;
    LinkedList<State> accepts;

    // DFA constructor
    DFA(State start, LinkedList<State> accepts) {
        this.start = start;
        currentPos = start;
        this.accepts = accepts;
    }

    // traverse through the DFA
    public boolean traverseDFA(char input) {
        Transition currentTransition = currentPos.getTransition(input);
        currentPos = currentTransition.to;

        if (accepts.contains(currentPos)) {
            return true;
        } else {
            return false;
        }
    }
}
