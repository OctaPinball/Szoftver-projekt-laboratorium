package agents;

import miscellaneous.Logger;
import movement.NormalMovement;
import movement.Stunned;

public class Stun extends Agent{
	public void activate() {
		Logger.enter(this, "activate", null);
		
		owner.setMovement(new Stunned());
		
		Logger.exit(this, "activate", null);
	}
	
	public void deactivate() {
		Logger.enter(this, "deactivate", null);
		
		owner.setMovement(new NormalMovement());
		owner.getActiveAgents().remove(this);
		
		Logger.exit(this, "deactivate", null);
	}
	
	public Agent makeCopy() {
		return (Agent) new Stun();
	}
}
