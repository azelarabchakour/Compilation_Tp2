public class Main 
{
    public static void main(String[] args)
    {
        DFA automata = new DFA();
        Metier m = new Metier();
        automata = m.create_automata();


        DFA_State initial_state = new DFA_State();
        initial_state =  m.create_state(-1, false, automata);

        DFA_State zero_state = new DFA_State();
        zero_state = m.create_state(0, false, automata);

        DFA_State one_state = new  DFA_State(); 
        one_state = m.create_state(1, false, automata);

        DFA_State accept_state = new DFA_State();
        accept_state = m.create_state(2, true, automata);
        

        m.generate_transitions("a-", initial_state, initial_state);
        m.generate_transitions("0", initial_state, zero_state);
        m.generate_transitions("1", initial_state, one_state);
        m.generate_transitions("0", one_state, zero_state);
        m.generate_transitions("1", zero_state, one_state);
        m.generate_transitions("+", zero_state, accept_state);
        m.generate_transitions("%", one_state, accept_state);
       
        //System.out.println("1\n");
        automata.setInitial_state(initial_state);

        //System.out.println("1\n");

        String ch1 = "a-aaaa--0101%";
        String ch2 = "100101011";

        if (m.belongs_to_language(ch1, automata)) 
            System.out.println("yes, it belongs");
        else 
            System.out.println("no, it doesn't");
        
    
    }
}
