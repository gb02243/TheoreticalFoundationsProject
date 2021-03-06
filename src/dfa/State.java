package dfa;

import java.util.LinkedList;

public class State {
    LinkedList<Transition> transitions = new LinkedList<>();
    private char label;

    // state constructor
    State(char label) {
        this.label = label;
    }

    // adds a transition/edge
    public void addTransition(Transition t) {
        transitions.add(t);
    }

    // returns the transition/edge for the corresponding input
    public Transition getTransition(char input) {
        Transition t = null;
        for (int i = 0; i < transitions.size(); i++) {
            if (transitions.get(i).input == input) {
                t = transitions.get(i);
            }
        }
        return t;
    }

    // returns the character of this state
    public char getLabel() {
        return label;
    }
}
