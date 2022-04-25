package agents;

import block.Block;
import block.FullBlock;
import block.NoBlock;
import block.PartialBlock;
import miscellaneous.Logger;


/**
 * Az Agent osztï¿½ly leszï¿½rmazottja, a hasznï¿½lï¿½ja vï¿½delem alï¿½ kerï¿½l, azaz elhï¿½rï¿½t minden rï¿½kent ï¿½genst.
 */
public class Protection extends Agent{

	/**
	 * Aktivï¿½lja az ï¿½gens hatï¿½sï¿½t a virolï¿½guson, azaz megvï¿½di minden ellensï¿½ges ï¿½gens hatï¿½sï¿½tï¿½l.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		Block block = new FullBlock();
		
		if(block.getPriority() > owner.getBlock().getPriority())
			owner.setBlock(block);
		
		Logger.exit(this, "activate", null);
	}
	
	/**
	 * Deaktivï¿½lja az ï¿½gens hatï¿½sï¿½t a virolï¿½guson, azaz elveszti az ï¿½gens nyï¿½jtotta vï¿½delmet.
	 */
	public void deactivate() {
		Logger.enter(this, "deactivate", null);
		
		owner.setBlock(new NoBlock());
		owner.getActiveAgents().remove(this);
		
		Logger.exit(this, "deactivate", null);
	}
	
	/**
	 * Mï¿½solatot kï¿½szï¿½t az ï¿½gensrï¿½l
	 * @return		az ï¿½gens mï¿½solata
	 */
	public Agent makeCopy() {
		return (Agent) new Protection();
	}
	
	/**
	 * Megtanulja az ágenst.
	 */
	public void interact() {
		owner.learnAgent(this);
	}
}
