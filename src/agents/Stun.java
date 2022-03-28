package agents;

import movement.NormalMovement;
import movement.Stunned;

public class Stun extends Agent{
	public void activate() {
		owner.setMovement(new Stunned());
	}
	
	public void deactivate() {
		owner.setMovement(new NormalMovement());
		owner.getActiveAgents().remove(this);
	}
}
