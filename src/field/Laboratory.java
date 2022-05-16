package field;

import miscellaneous.*;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import agents.*;
import graphic.View;

/**
 * A Field oszt�ly lesz�rmazottja, az ilyen t�pus� mez�kre l�pve tudnak a virol�gusok �j �genseket megismerni.
 * Minden laborat�riumban tal�lhat� egy �gens, amit a mez�re l�p� virol�gus egyb�l megtanul.
 */
public class Laboratory extends Field{
	
	ImageIcon lab = new ImageIcon("res/Field_3.png");
	ImageIcon darkLab = new ImageIcon("res/Field_3_dark.png");
	
	public Laboratory(int id, int x, int y) {
		super(id, x, y);
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
	
	/**
	 * Visszaadja stringk�nt a mez�n tart�zkod� virol�gust, 
	 * felszerel�st �s a mez� t�pus�t
	 * @return		az eml�tett adatok stringk�nt
	 */
	public String toString() {
		return "name:\t\t" + Control.getName(this)
		+ "\ntype:\t\tlaboratory"
		+ "\nvirologist:\t" + Control.getName(virologistOnField)
		+ "\nequipment:\t" + Control.getName(equipmentOnField);
	}
	
	/**
	 * Visszaadja a vil�gos laborat�rium mez� k�p�t
	 * @return		laborat�rium mez� ImageIcon-ja
	 */
	public ImageIcon getIMG() {
		return lab;
	}
	
	/**
	 * Visszaadja a s�t�t laborat�rium mez� k�p�t
	 * @return		laborat�rium mez� ImageIcon-ja
	 */
	public ImageIcon getDarkIMG() {
		return darkLab;
	}
	

	/**
     *  Kiv�lasztja az laboratory-hoz sz�ks�ges rajzol�st
     */
	@Override
	public void pickDraw(View v) {
		v.drawLaboratory(this);
	}
}
