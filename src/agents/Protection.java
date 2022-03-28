package agents;

import block.NoBlock;
import block.PartialBlock;
import miscellaneous.Logger;

public class Protection extends Agent{
	public void activate() {
		Logger.enter(this, "activate", null);
		
		owner.setBlock(new PartialBlock());
		
		Logger.exit(this, "activate", null);
	}
	
	public void deactivate() {
		Logger.enter(this, "deactivate", null);
		
		owner.setBlock(new NoBlock());
		owner.getActiveAgents().remove(this);
		
		Logger.exit(this, "deactivate", null);
	}
}
