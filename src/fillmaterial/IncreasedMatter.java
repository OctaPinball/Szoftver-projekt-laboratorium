package fillmaterial;

import miscellaneous.Virologist;

public class IncreasedMatter implements FillMaterial{
	
	private static int incAminoacid = 100;
	private static int incNucleotide = 100;

	public void fillMaterial(Virologist v) {
		
		v.setAminoAcid(incAminoacid);
		v.setNucleotide(incNucleotide);
		
	}
	
}
