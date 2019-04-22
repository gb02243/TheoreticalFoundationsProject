package dfa;

public class Transition {
    char input;

    State from;
    State to;

    Transition(char input, State from, State to) {
        this.input = input;
        this.from = from;
        this.to = to;

        from.addTransition(this);
    }
}
