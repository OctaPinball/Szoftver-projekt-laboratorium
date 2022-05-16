package fillmaterial;

import miscellaneous.Virologist;

/**
 * A FillMaterial leszármazottja, amikor aktív a virológus a storge mezõt amire rálép elpusztítja, a Bear ágens okozza
 */
public class BearMatter implements FillMaterial{
	
	private final int priority = 2;

	 /**
     * A paraméterként kapott virológus mezõt amire rálép elpusztítja
     * @param v, a virológus, aki megkapta a medveágenst
     */
	public void fillMaterial(Virologist v) {
		
		v.getField().copyStorage();
		v.getField().destroy();
		
	}
	
	/**
     * Visszatér a prioritással
     * @return prioritás
     */
	public int getPriority() {
		return priority;
	}
}
