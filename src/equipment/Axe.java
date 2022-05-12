package equipment;

import java.awt.Image;

import javax.swing.ImageIcon;

import beardefense.*;
import block.BlockAndReturn;
import block.NoBlock;
import fillmaterial.IncreasedMatter;
import miscellaneous.Control;
import miscellaneous.Logger;

public class Axe extends Equipment{
	
	private int life = 1;
	ImageIcon axe = new ImageIcon("res/Axe.png");
	ImageIcon usedAxe = new ImageIcon("res/Axe_used.png");
	
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
	
	public String toString() {
		return "axe\t\t" + Control.getName(this);
	}
	
	public ImageIcon getAxeIMG() {
		return axe;
	}

}
