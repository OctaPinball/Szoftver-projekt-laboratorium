package block;

import agents.Agent;
import miscellaneous.Virologist;

public class BlockAndReturn implements Block{
	
	private int counter;
	private BlockAndReturn bar = new BlockAndReturn();
	
	public BlockAndReturn() {
		counter = 0;
	}
	
	@Override
	public boolean block(Virologist s, Virologist t, Agent a) {
		// TODO Auto-generated method stub
		
		if(bar.counter < 2) {
			a.cast(t, bar.counter++);
			
			block(t, s, a);		
			return true;
		}
		else return false;
	}
}
