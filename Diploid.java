import java.util.Random;

public class Diploid {
	Chromatid[] paternal;
	Chromatid[] maternal;
	Haploid[] dCells = new Haploid[4];
	private boolean haploidsMade;
	Random rand = new Random();

	public Diploid(int numChromatids, int alleleLength, int numAlleles) {
		paternal = new Chromatid[numChromatids];
		maternal = new Chromatid[numChromatids];
		for (int i = 0; i < numChromatids; i++) {
			paternal[i] = new Chromatid(numAlleles, alleleLength, i, rand);
			maternal[i] = new Chromatid(numAlleles, alleleLength, i, rand);
		}
	}
	
	public Diploid(Haploid a, Haploid b){
		paternal = a.getChromatids(); 
		maternal = b.getChromatids(); 
	}

	public void makeHaploids() {
		haploidsMade = true;
		// need to make 4 haploids
		Chromatid[] pA = paternal, pB = paternal;
		Chromatid[] mA = maternal, mB = maternal;

		Haploid[] hap = new Haploid[4];

		for (int i = 0; i < paternal.length; i++) {
			pA[i].crossOver(mA[i], rand);
			pB[i].crossOver(mB[i], rand);
		}

		hap[0] = new Haploid(pA, 1);
		hap[1] = new Haploid(pB, 2);
		hap[2] = new Haploid(mA, 3);
		hap[3] = new Haploid(mB, 4);

		dCells = hap;
	}

	public Haploid[] getHaploids() {
		if (!haploidsMade) {
			makeHaploids();
		}
		return dCells;
	}
	public Haploid getOneHaploid(){
		int temp = rand.nextInt() %4;
		if (temp < 0) temp +=4; 
		if(!haploidsMade){makeHaploids();}
		return dCells[temp];
		
		
	}
	

	public void print() {
		System.out.println("paternal Genes =======");
		for (int i = 0; i < paternal.length; i++) {
			Chromatid c = paternal[i];
			c.print();
		}
		System.out.println();
		System.out.println("maternal Genes =======");
		for (int i = 0; i < paternal.length; i++) {
			Chromatid c = maternal[i];
			c.print();
		}
		System.out.println();
	}

	public String toString() {
		String myString = new String();
		myString += "Diploid ===== \n\n";
		myString += "Paternal --\n";
		for (Chromatid chrom : paternal) {
			myString += chrom.toString();
		}

		myString += "\nMaternal --\n";
		for (Chromatid chrom : maternal) {
			myString += chrom.toString();
		}
		return myString;
	}

}
