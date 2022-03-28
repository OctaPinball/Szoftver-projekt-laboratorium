package agents;

import block.NoBlock;
import block.PartialBlock;
import miscellaneous.Logger;


/**
 * Az Agent osztály leszármazottja, a használója védelem alá kerül, azaz elhárít minden rákent ágenst.
 */
public class Protection extends Agent{

	/**
	 * Aktiválja az ágens hatását a virológuson, azaz megvédi minden ellenséges ágens hatásától.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		owner.setBlock(new FullBlock());
		
		Logger.exit(this, "activate", null);
	}
	
	/**
	 * Deaktiválja az ágens hatását a virológuson, azaz elveszti az ágens nyújtotta védelmet.
	 */
	public void deactivate() {
		Logger.enter(this, "deactivate", null);
		
		owner.setBlock(new NoBlock());
		owner.getActiveAgents().remove(this);
		
		Logger.exit(this, "deactivate", null);
	}
	
	/**
	 * Másolatot készít az ágensrõl
	 * @return		az ágens másolata
	 */
	public Agent makeCopy() {
		return (Agent) new Protection();
	}
}
