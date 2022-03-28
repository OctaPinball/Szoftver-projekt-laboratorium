package field;

import java.util.ArrayList;

import miscellaneous.*;

/**
 * A Field oszt�ly lesz�rmazottja, az ilyen t�pus� mez�kre l�pve tudj�k a virol�gusok felt�lteni k�szleteiket.
 */
public class Storage extends Field{
	
	/**
	 * A Field oszt�ly stepOn f�ggv�ny�t kieg�sz�ti, azzal hogy felt�lti a virol�gus �sszes nyersanyag k�szlet�t
	 * @param virologist		a mez�re l�p� virol�gus
	 */
	@Override
	public void stepOn(Virologist virologist) {
		ArrayList<Object> par = new ArrayList<Object>();
		par.add(virologist);
		Logger.enter(this, "stepOn", par);
		
		
		super.stepOn(virologist);
		virologist.getFillMaterial().fillMaterial(virologist);
		
		
		Logger.exit(this, "stepOn", null);
	}
}
