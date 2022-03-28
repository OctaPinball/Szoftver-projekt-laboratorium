package block;

import java.util.ArrayList;

import agents.Agent;
import miscellaneous.Logger;
import miscellaneous.Virologist;

public class PartialBlock implements Block{

	@Override
	public boolean block(Virologist s, Virologist t, Agent a) {
		
		ArrayList<Object> par = new ArrayList<>(); par.add(s); par.add(t); par.add(a);
		Logger.enter(this, "block", par);
		
		boolean result = true;
		
		double rnd = Math.random();
		
		if(rnd < 0.823);
		else result = false;
		
		Logger.exit(this, "block", result);
		return result;
	}

}
