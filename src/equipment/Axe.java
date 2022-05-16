package equipment;

import java.awt.Image;

import javax.swing.ImageIcon;

import beardefense.*;
import block.BlockAndReturn;
import block.NoBlock;
import fillmaterial.IncreasedMatter;
import graphic.View;
import miscellaneous.Control;
import miscellaneous.Logger;

/**
 * Egy olyan felszerelést reprezentál a programban, amelyet ha felvesz egy játékos,
 * akkor megtudja vele ölni a medveágens hatása alatt álló virológust.
 */
public class Axe extends Equipment{
	
	private int life = 1;
	//ImageIcon axe = new ImageIcon("res/Axe.png");
	//ImageIcon usedAxe = new ImageIcon("res/Axe_used.png");
	
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
	
	/**
     *  Visszatér az axe nevével
     *  @return "axe" string
     */
	public String toString() {
		return "axe\t\t" + Control.getName(this);
	}


	/**
     *  Kiválasztja az axe-hoz szükséges rajzolást
     */
	@Override
	public void pickDraw(View v) {
		v.drawAxe(this);
	}
}
