package block;

import agents.Agent;
import miscellaneous.Virologist;

public class NoBlock implements Block{

	@Override
	public boolean block(Virologist s, Virologist t, Agent a) {

		return false;
	}

}
