package block;

import java.util.ArrayList;

import agents.Agent;
import miscellaneous.Logger;
import miscellaneous.Virologist;

public class FullBlock implements Block{

	@Override
	public boolean block(Virologist s, Virologist t, Agent a) {

		ArrayList<Object> par = new ArrayList<>(); par.add(s); par.add(t); par.add(a);
		Logger.enter(this, "block", par);
		
		
		Logger.exit(this, "block", true);
		return true;
	}

}
