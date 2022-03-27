package block;

import agents.Agent;
import miscellaneous.Virologist;

public class PartialBlock implements Block{

	@Override
	public boolean block(Virologist s, Virologist t, Agent a) {
		
		double rnd = Math.random();
		if(rnd < 0.823)
			return true;
		return false;
	}

}
