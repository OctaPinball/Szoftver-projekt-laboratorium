package block;

import agents.Agent;
import miscellaneous.Virologist;

public interface Block {

	public abstract boolean block(Virologist s, Virologist t, Agent a);
	
}
