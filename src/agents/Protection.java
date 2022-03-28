package agents;

import block.NoBlock;
import block.PartialBlock;

public class Protection extends Agent{
	public void activate() {
		owner.setBlock(new PartialBlock());
	}
	
	public void deactivate() {
		owner.setBlock(new NoBlock());
		owner.getActiveAgents().remove(this);
	}
}
