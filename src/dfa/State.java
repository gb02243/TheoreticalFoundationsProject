package dfa;

import java.util.LinkedList;

public class State {
    LinkedList<Transition> transitions = new LinkedList<>();
    private char label;

    State(char label){
        this.label = label;
    }

    public void addTransition(Transition t){
        transitions.add(t);
    }

    // Returns the Edge for the corresponding input
    public Transition getTransition(char input) {
        Transition t = null;
        for (int i = 0; i < transitions.size(); i++) {
            if (transitions.get(i).input == input) {
                t = transitions.get(i);
            }
        }
        return t;
    }

    public char getLabel(){
        return label;
    }
}
