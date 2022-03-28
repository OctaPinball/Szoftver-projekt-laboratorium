package agents;

import block.NoBlock;
import block.PartialBlock;
import miscellaneous.Logger;


/**
 * Az Agent oszt�ly lesz�rmazottja, a haszn�l�ja v�delem al� ker�l, azaz elh�r�t minden r�kent �genst.
 */
public class Protection extends Agent{

	/**
	 * Aktiv�lja az �gens hat�s�t a virol�guson, azaz megv�di minden ellens�ges �gens hat�s�t�l.
	 */
	public void activate() {
		Logger.enter(this, "activate", null);
		
		owner.setBlock(new FullBlock());
		
		Logger.exit(this, "activate", null);
	}
	
	/**
	 * Deaktiv�lja az �gens hat�s�t a virol�guson, azaz elveszti az �gens ny�jtotta v�delmet.
	 */
	public void deactivate() {
		Logger.enter(this, "deactivate", null);
		
		owner.setBlock(new NoBlock());
		owner.getActiveAgents().remove(this);
		
		Logger.exit(this, "deactivate", null);
	}
	
	/**
	 * M�solatot k�sz�t az �gensr�l
	 * @return		az �gens m�solata
	 */
	public Agent makeCopy() {
		return (Agent) new Protection();
	}
}
