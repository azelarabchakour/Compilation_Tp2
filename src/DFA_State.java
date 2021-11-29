import java.util.ArrayList;
import java.util.List;

public class DFA_State 
{
    private int state_identifier;
    private boolean accept_state;
    private int transition_count;
    private List<DFA_Transition> transitions;

    public DFA_State()
    {
        transitions = new ArrayList<DFA_Transition>();
    }

    public void setState_identifier(int state_identifier)
    {
        this.state_identifier = state_identifier;
    }
    public int getState_identifier()
    {
        return this.state_identifier;
    }
    public void setAccept_state(Boolean accept_state)
    {
        this.accept_state = accept_state;
    }
    public boolean getAccept_state()
    {
        return this.accept_state;
    }
    public void setTransition_count(int transition_count)
    {
        this.transition_count = transition_count;
    }
    public int getTransition_count()
    {
        return this.transition_count;
    }
    public void setTransitions(DFA_Transition transition) 
    {
        this.transitions.add(transition);
    }
    public List<DFA_Transition> getTransitions()
    {
        return this.transitions;
    }
    public DFA_Transition getTransitionAt(int index)
    {
        return this.transitions.get(index);
    }

    
}
