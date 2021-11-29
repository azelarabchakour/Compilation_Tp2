public class DFA_Transition 
{
    private DFA_State origine_state;
    private DFA_State destination_state;
    private char trigger_value;

    public DFA_Transition()
    {
        origine_state = new DFA_State();
        destination_state = new DFA_State();
        
    }

    public void setOrigine_state(DFA_State state) 
    {
        this.origine_state = state;
    }
    public DFA_State getOrigine_state()
    {
        return this.origine_state;
    }
    public void setDestination_state(DFA_State state) 
    {
        this.destination_state = state;
    }
    public DFA_State getDestination_state()
    {
        return this.destination_state;
    }
    public void setTrigger_value(char trigger) 
    {
        this.trigger_value = trigger;
    }
    public char getTrigger_value() 
    {
        return this.trigger_value;
    }

    
}