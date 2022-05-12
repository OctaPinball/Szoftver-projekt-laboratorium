package equipment;

import java.awt.Image;

import javax.swing.ImageIcon;

import block.*;
import miscellaneous.Control;
import miscellaneous.Logger;

/**
 * Egy olyan felszerelést reprezentál a programban, amelyet ha felvesz egy játékos,
 * akkor megkapja a PartialBlock tulajdonságot, amely 82,3%-os védelmet nyújt minden vírus ellen.
 */
public class Cape extends Equipment{
	
	ImageIcon cape = new ImageIcon("res/Cape.png");

    /**
     * Aktiválja a PartialBlock hatást a virológuson
     */
    public void getEffect(){

        Logger.enter(this, "getEffect", null);

        PartialBlock pb = new PartialBlock();
        
        if(pb.getPriority() > wearer.getBlock().getPriority())
			wearer.setBlock(pb);
        
        Logger.register(wearer.getBlock(), "pb");

        Logger.exit(this, "getEffect", null);

    }

    /**
     *  Deaktiválja a PartialBlock hatást a virológuson, visszaállítja a NoBlock hatást
     */
    public void loseEffect(){

        Logger.enter(this, "loseEffect", null);

        wearer.setBlock(new NoBlock());

        Logger.exit(this, "loseEffect", null);

    }
    
    public String toString() {
		return "cape\t\t" + Control.getName(this);
	}
    
    public ImageIcon getCapeIMG() {
		return cape;
	}
}
