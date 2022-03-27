package fillmaterial;

import miscellaneous.Virologist;

public class NormalMatter implements FillMaterial{
	
	private static int normAminoacid = 100;
	private static int normNucleotide = 100;

	public void fillMaterial(Virologist v) {
		
		v.setAminoAcid(normAminoacid);
		v.setNucleotide(normNucleotide);
		
	}
	
}
