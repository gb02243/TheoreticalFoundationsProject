package dfa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Controller {
    String alphabet;
    LinkedList<State> states;
    State start;
    LinkedList<State> accepts;
    LinkedList<Transition> transitions;
    DFA dfa;

    Controller(File input) {
        getDescription(input);
    }

    public void getDescription(File input) {
        String alphabet;
        String states;
        char start;
        String accepts;
        LinkedList<String> transitions;

        try {
            Scanner s = new Scanner(input);

            // get alphabet
            alphabet = s.nextLine();
            alphabet = alphabet.replaceAll("[^a-zA-Z0-9]", "");
            this.alphabet = alphabet;

            // get states
            states = s.nextLine();
            states = states.replaceAll("[^a-zA-Z0-9]", "");
            this.states = new LinkedList<>();
            for (int i = 0; i < states.length(); i++) {
                this.states.add(new State(states.charAt(i)));
            }

            // get start
            start = s.nextLine().charAt(0);
            this.start = getState(start);

            // get accepting states
            accepts = s.nextLine();
            accepts = accepts.replaceAll("[^a-zA-Z0-9]", "");
            this.accepts = new LinkedList<>();
            for (int i = 0; i < accepts.length(); i++) {
                this.accepts.add(getState(accepts.charAt(i)));
            }

            // get transitions
            transitions = new LinkedList<>();
            String line;
            while (s.hasNextLine()) {
                line = s.nextLine();
                transitions.add(line);
            }
            this.transitions = new LinkedList<>();
            for (int i = 0; i < transitions.size(); i++) {
                this.transitions.add(new Transition(transitions.get(i).charAt(3), getState(transitions.get(i).charAt(1)), getState(transitions.get(i).charAt(7))));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public State getState(char c) {
        State state = null;
        for (int i = 0; i < this.states.size(); i++) {
            if (c == this.states.get(i).getLabel()) {
                state = this.states.get(i);
            }
        }
        return state;
    }

    public void build() {
        dfa = new DFA(start, accepts);
    }

    public boolean checkAlphabet(String input){
        // TODO implement
        return true;
    }

    public void testInput(String input) {
        build();

        boolean accepted = false;
        for (int i = 0; i < input.length(); i++) {
            accepted = dfa.traverseDFA(input.charAt(i));
        }
        if (accepted == true){
            System.out.println("String is accepted.");
        }else{
            System.out.println("String is not accepted.");
        }
    }

    // for testing
    public void printDescription() {
        System.out.println("Alphabet: " + alphabet);
        System.out.print("States: ");
        for (int i = 0; i < states.size(); i++) {
            System.out.print(states.get(i).getLabel());
        }
        System.out.print("\nStart state: " + start.getLabel());
        System.out.print("\nAccept States: ");
        for (int i = 0; i < accepts.size(); i++) {
            System.out.print(accepts.get(i).getLabel());
        }
        System.out.println("\nTransitions: ");
        for (int i = 0; i < transitions.size(); i++) {
            System.out.println("(" + transitions.get(i).from.getLabel() + "," + transitions.get(i).input + ")->" + transitions.get(i).to.getLabel());
        }
    }
}
