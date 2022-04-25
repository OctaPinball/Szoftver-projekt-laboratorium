package equipment;

import beardefense.*;
import block.BlockAndReturn;
import block.NoBlock;
import fillmaterial.IncreasedMatter;
import miscellaneous.Control;
import miscellaneous.Logger;

public class Axe extends Equipment{
	
	private int life = 1;
	
	
	/**
     * Aktiválja a Defense hatást a virológuson
     */
	public void getEffect() {
		Logger.enter(this, "getEffect", null);

		Defense d = new Defense();

        if(d.getPriority() > wearer.getDefense().getPriority())
			wearer.setDefense(d);
        
        Logger.exit(this, "getEffect", null);
	}

	
	/**
     *  Deaktiválja a Defense hatást a virológuson, visszaállítja a NoDefense hatást
     */
	public void loseEffect() {
		
		 Logger.enter(this, "loseEffect", null);

		 wearer.setBearDefense(new NoDefense());

		 Logger.exit(this, "loseEffect", null);
	}
	
	/**
     *  Elhasznál egy életet
     */
	public void usedLife() {
		life -= 1;
		if(life == 0)
			this.dropEquipment();
	}
	
	public String toString() {
		return "axe:\t " + Control.getName(this);
	}
	

}
