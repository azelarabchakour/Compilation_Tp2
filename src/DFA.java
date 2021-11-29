import java.util.ArrayList;
import java.util.List;

public class DFA 
{
    private int states_count;
    private List<DFA_State> states ;
    private DFA_State current_state;
    private DFA_State initial_state;

    public DFA()
    {
        //states_count = 0;
        //initial_state = null;
        //states = new ArrayList<DFA_State>();

        /*DFA automata = new DFA();
        automata.setStates_count(0);
        automata.setInitial_state(null);
        automata.setStates(null);
        return automata;*/

        states = new ArrayList<DFA_State>();
        current_state = new DFA_State();
        //initial_state = new DFA_State();
    }

    public void setStates_count(int states_count)
    {
        this.states_count = states_count;
    }
    public int getStates_count()
    {
        return this.states_count;
    }
    public List<DFA_State> getStates() 
    {
        return this.states;    
    }
    public void setStates(DFA_State state)
    {
        this.states.add(state);
    }
    public void setCurrent_state(DFA_State state) 
    {
        this.current_state = state;
    }
    public DFA_State getCurrent_state() 
    {
        return this.current_state;
    }
    public void setInitial_state(DFA_State state) 
    {
        //this.initial_state = new DFA_State();
        this.initial_state = state;
    }
    public DFA_State getIntial_state() 
    {
        return this.initial_state;
    }
    public DFA_State getStateAt(int index)
    {
        return states.get(index);
    }

}
