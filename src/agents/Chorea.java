package agents;

import miscellaneous.Logger;
import movement.NormalMovement;
import movement.RandomMovement;

public class Chorea extends Agent{
	public void activate() {
		Logger.enter(this, "activate", null);
		
		owner.setMovement(new RandomMovement());
		
		Logger.exit(this, "activate", null);
	}
	
	public void deactivate() {
		Logger.enter(this, "deactivate", null);
		
		owner.setMovement(new NormalMovement());
		owner.getActiveAgents().remove(this);
		
		Logger.exit(this, "deactivate", null);
	}
	
	public Agent makeCopy() {
		return (Agent) new Chorea();
	}
}
