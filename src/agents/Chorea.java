package agents;

import movement.NormalMovement;
import movement.RandomMovement;

public class Chorea extends Agent{
	public void activate() {
		owner.setMovement(new RandomMovement());
	}
	
	public void deactivate() {
		owner.setMovement(new NormalMovement());
		owner.getActiveAgents().remove(this);
	}
}
