package block;

import java.util.ArrayList;

import agents.Agent;
import miscellaneous.Logger;
import miscellaneous.Virologist;

public class BlockAndReturn implements Block{
	
	private int counter;
	private BlockAndReturn bar = new BlockAndReturn();
	
	public BlockAndReturn() {
		counter = 0;
	}
		
	public boolean block(Virologist s, Virologist t, Agent a) throws CloneNotSupportedException {

		ArrayList<Object> par = new ArrayList<>(); par.add(s); par.add(t); par.add(a);
		Logger.enter(this, "block", par);
		
		boolean result = true;
		
		if(bar.counter <= 2) {
			a.cast(t, bar.counter++);
			
			block(t, s, a);		
			return true;
		}
		else result = false;
		
		Logger.exit(this, "block", result);
		return result;
	}
}
