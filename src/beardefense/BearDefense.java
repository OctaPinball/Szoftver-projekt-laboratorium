package beardefense;

import java.io.IOException;

import miscellaneous.Virologist;

/**
 * A virol�gus medve t�mad�sok elleni v�dekez� k�pess�g�t jellemz� interf�sz
 */
public interface BearDefense {

	/**
	 * A v�dekez�s m�dj�t hat�rozza meg, a lesz�rmazottakban kell implement�lni.
	 * @param bear		A t�mad� "virol�gus" (medve)
	 * @param target	A megt�madott (v�dekez�) virol�gus	
	 * @throws CloneNotSupportedException
	 * @throws IOException
	 */
	public abstract void bearAttack(Virologist bear, Virologist target) throws CloneNotSupportedException, IOException;

	/**
	 * @return	A v�dekez�si m�d prioprit�s�t adja meg
	 */
	public abstract int getPriority();
}
