package agents;

import miscellaneous.Logger;

public class ForgettingAgent extends Agent{
	public void activate() {
		Logger.enter(this, "activate", null);
		
		owner.forgetAllAgent();
		this.deactivate();
		
		Logger.exit(this, "activate", null);
	}
	
	public void deactivate() {
		Logger.enter(this, "deactivate", null);
		
		owner.getActiveAgents().remove(this);
		
		Logger.exit(this, "deactivate", null);
	}
}