package agents;

public class ForgettingAgent extends Agent{
	public void activate() {
		owner.forgetAllAgent();
		this.deactivate();
	}
	
	public void deactivate() {
		owner.getActiveAgents().remove(this);
	}
}
