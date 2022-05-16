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
 * Egy olyan felszerel�st reprezent�l a programban, amelyet ha felvesz egy j�t�kos,
 * akkor megtudja vele �lni a medve�gens hat�sa alatt �ll� virol�gust.
 */
public class Axe extends Equipment{
	
	private int life = 1;
	//ImageIcon axe = new ImageIcon("res/Axe.png");
	//ImageIcon usedAxe = new ImageIcon("res/Axe_used.png");
	
	/**
     * Aktiv�lja a Defense hat�st a virol�guson
     */
	public void getEffect() {
		Logger.enter(this, "getEffect", null);

		Defense d = new Defense();

        if(d.getPriority() > wearer.getDefense().getPriority())
			wearer.setDefense(d);
        
        Logger.exit(this, "getEffect", null);
	}

	
	/**
     *  Deaktiv�lja a Defense hat�st a virol�guson, vissza�ll�tja a NoDefense hat�st
     */
	public void loseEffect() {
		
		 Logger.enter(this, "loseEffect", null);

		 wearer.setBearDefense(new NoDefense());

		 Logger.exit(this, "loseEffect", null);
	}
	
	/**
     *  Elhaszn�l egy �letet
     */
	public void usedLife() {
		life -= 1;
		if(life == 0)
			this.dropEquipment();
	}
	
	/**
     *  Visszat�r az axe nev�vel
     *  @return "axe" string
     */
	public String toString() {
		return "axe\t\t" + Control.getName(this);
	}


	/**
     *  Kiv�lasztja az axe-hoz sz�ks�ges rajzol�st
     */
	@Override
	public void pickDraw(View v) {
		v.drawAxe(this);
	}
}
