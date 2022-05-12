package field;

import miscellaneous.*;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import agents.*;

/**
 * A Field oszt�ly lesz�rmazottja, az ilyen t�pus� mez�kre l�pve tudnak a virol�gusok �j �genseket megismerni.
 * Minden laborat�riumban tal�lhat� egy �gens, amit a mez�re l�p� virol�gus egyb�l megtanul.
 */
public class Laboratory extends Field{
	
	Image lab = new ImageIcon("res/Field_3.png").getImage();
	Image darkLab = new ImageIcon("res/Field_3_dark.png").getImage();
	
	public Laboratory(int id) {
		super(id);
	}

	private Agent agentOnField;
	
	/**
	 * A Field oszt�ly stepOn f�ggv�ny�t kieg�sz�ti, azzal hogy megismerteti a virol�gussal a laborat�riumban tal�lhat� �gens k�dj�t
	 * @param virologist		a mez�re l�p� virol�gus
	 * @throws IOException 
	 * @throws CloneNotSupportedException 
	 */
	@Override
	public void stepOn(Virologist virologist) throws CloneNotSupportedException, IOException {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "stepOn", par);
		
		
		super.stepOn(virologist);
		agentOnField.setOwner(virologist);
		agentOnField.interact();
		//virologist.learnAgent(agentOnField);
		
		
		
		Logger.exit(this, "stepOn", null);
	}

	/**
	 * Hozz�adja a param�terben kapott �genst a laborat�riumhoz.
	 * @param newAgent		a laborat�riumban megtanulhat� �gens
	 */
	public void addAgent(Agent newAgent) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(newAgent);
		Logger.enter(this, "addAgent", par);


		agentOnField = newAgent;


		Logger.exit(this, "addAgent", null);
	}
	
	public String toString() {
		return "name:\t\t" + Control.getName(this)
		+ "\ntype:\t\tlaboratory"
		+ "\nvirologist:\t" + Control.getName(virologistOnField)
		+ "\nequipment:\t" + Control.getName(equipmentOnField);
	}
}
