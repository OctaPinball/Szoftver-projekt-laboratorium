package equipment;

import block.*;
import miscellaneous.Control;
import miscellaneous.Logger;

/**
 * Egy olyan felszerelést reprezentál a programban, amelyet ha felvesz egy játékos, akkor megkapja a BlockAndReturn tulajdonságot,
 * amely megvédi a virológust bármilyen vírustól, és azt vissza is dobja a támadójára.
 */
public class Glove extends Equipment{
	
	private static int i = 0;
	private int life = 3;
	
	public Glove(){
		i++;
	}

    /**
     * Aktiválja a BlockAndReturn hatást a virológuson
     */
    public void getEffect(){

        Logger.enter(this, "getEffect", null);

        wearer.setBlock(new BlockAndReturn());
        Logger.register(wearer.getBlock(), "bar"+i);

        Logger.exit(this, "getEffect", null);

    }

    /**
     *  Deaktiválja a BlockAndReturn hatást a virológuson, visszaállítja a NoBlock hatást
     */
    public void loseEffect(){

        Logger.enter(this, "loseEffect", null);

        wearer.setBlock(new NoBlock());

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
		return "glove:\t " + Control.getName(this);
	}
}