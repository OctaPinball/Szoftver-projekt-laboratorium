package fillmaterial;

import miscellaneous.Virologist;

/**
 * A FillMaterial lesz�rmazottja, amikor akt�v a virol�gus a storge mez�t amire r�l�p elpuszt�tja, a Bear �gens okozza
 */
public class BearMatter implements FillMaterial{
	
	private final int priority = 2;

	 /**
     * A param�terk�nt kapott virol�gus mez�t amire r�l�p elpuszt�tja
     * @param v, a virol�gus, aki megkapta a medve�genst
     */
	public void fillMaterial(Virologist v) {
		
		v.getField().copyStorage();
		v.getField().destroy();
		
	}
	
	/**
     * Visszat�r a priorit�ssal
     * @return priorit�s
     */
	public int getPriority() {
		return priority;
	}
}
