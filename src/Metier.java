//import java.lang.*;

public class Metier 
{
    //give the automata the initial state as the current state
    public void init_automata(DFA automata) 
    {

        /*if (automata.getIntial_state() != null) 
        {
            System.out.println("[-] Error: Initial state of automata not set.\n");
            System.exit(1);
        }*/

        automata.setCurrent_state(automata.getIntial_state());
    }    

    //as long as the caracter belongs to the table of transitions
    //of the state return true
    public boolean update_automata(char ch, DFA automata)
    {

        DFA_State state = new DFA_State();
        state = automata.getCurrent_state();
        boolean made_transition = false;
        for (int j = 0; j < state.getTransition_count(); j++) 
        {
            if (state.getTransitionAt(j).getTrigger_value() == ch) 
            {
                //DFA_Transition transition = state.getTransitions().get(j);
                automata.setCurrent_state(state.getTransitionAt(j).getDestination_state());   
                made_transition = true;
                break; // Finite automata does not have 'choices'. If trigger_value matches, then the automata must not have another transition with the same value.
            }
        }

        if (!made_transition) // Automata will always execute a transition if value is accepted.Even if the transition result in the same stage.
        {
            return false;
        }
        return true;
    }

    boolean belongs_to_language(String string, DFA automata)
    {
        //test if the string is empty
        if (string.length() == 0 )
        {
            System.out.println("[-] Error: Empty string sent to analyse in belongs_to_language.\n");
            System.exit(1);
        }

        //give the automata the intial state as initial state
        init_automata(automata);

        for (int i = 0; i < string.length(); i++) 
        {
            if (!update_automata(string.charAt(i), automata))
            {
                return false;   
            }    
        }

        return automata.getCurrent_state().getAccept_state();
    }

    //fill the state's transition table with transitions
    public void set_transition_to_state(DFA_Transition transition, DFA_State origine_state)
    {
        origine_state.getTransitions().add(transition);// Add new transitions to array of transitions
        origine_state.setTransition_count(origine_state.getTransition_count() + 1);
    }

    //fill the automata's state table with states
    public void set_state_to_automata(DFA_State state, DFA automata)
    {
        
        automata.setStates(state);// Add new state to the final of the array
        automata.setStates_count(automata.getStates_count() + 1);
    }

    //create a state and assign to it the identifier, if it's accept state or not, and the automata
    public DFA_State create_state(int state_identifier, boolean accept_state, DFA automata)
    {
        DFA_State state = new DFA_State();
        state.setAccept_state(accept_state);
        state.setTransition_count(0);
        state.setState_identifier(state_identifier);
        //state.setTransitions(null);
        set_state_to_automata(state, automata);
        return state;
    }

    //create a transition and assign to it the origin state, destination 
    //state and the trigger value

    DFA_Transition create_transition(char trigger_value, DFA_State origine_state,DFA_State destination_state)
    {
        DFA_Transition transition = new DFA_Transition();
        transition.setTrigger_value(trigger_value);
        transition.setOrigine_state(origine_state);
        transition.setDestination_state(destination_state);
        set_transition_to_state(transition, origine_state);
        return transition;

    }

    //create a transition
    void generate_transitions(String string, DFA_State origine_state, DFA_State destination_state)
    {
        for (int i = 0; i < string.length(); i++) 
        {
            create_transition(string.charAt(i), origine_state, destination_state);
        }
    }

    //create an automata with 0 states
    DFA create_automata()
    {
        DFA automata = new DFA();
        automata.setStates_count(0);
        //automata.setInitial_state(null);
        //automata.setStates(null);
        return automata;
    }






}
