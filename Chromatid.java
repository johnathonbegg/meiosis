import java.util.Random;

public class Chromatid {
	// for crossing over
	private String[] alleles; // genetic information
	private int length;
	int ID; // use to compare chomatid types

	/**
	 * 
	 * @param num determins the number of alleels this chromatid contains
	 */
	public Chromatid(int num, int length, int ID, Random rand) {
		alleles = new String[num];

		this.length = length;
		this.ID = ID;
		generateGenes(rand);

	}

	/**
	 * 
	 * @param rand
	 * @param allelesB
	 *            - set of alleles from other chromatid
	 */
	public void crossOver(Chromatid chrom, Random rand) {
		String[] allelesB = chrom.getAlleles();
		// musth have same number of alleles or not the same chromosome type
		if (alleles.length != allelesB.length) {
			return;
		}

		for (int i = 0; i < alleles.length; i++) {
			int temp = rand.nextInt();
			// swap allele
			if (temp % 2 == 0) {
				String swap = alleles[i];
				alleles[i] = chrom.getAllele(i);
				chrom.setAllele(i, swap);
			}

		}

	}

	public String[] getAlleles() {
		return alleles;
	}

	public String getAllele(int i) {
		if (i < 0 || i > alleles.length) {
			return null;
		}
		return alleles[i];
	}

	public void setAllele(int i, String A) {
		alleles[i] = A;
	}

	private void generateGenes(Random rand) {
		for (int j = 0; j < alleles.length; j++) {
			String str = new String();
			for (int i = 0; i < length; i++) {
				int temp = rand.nextInt() % 4;
				if (temp < 0)
					temp += 4;
				if (temp == 0) {
					str += "A";
				} else if (temp == 1) {
					str += "C";
				} else if (temp == 2) {
					str += "G";
				} else if (temp == 3) {
					str += "T";
				}

			}
			alleles[j] = str;
		}

	}

	public void print() {
		System.out.println("Chromatid" + ID + ": ");
		for (String str : alleles) {
			System.out.println(str);
		}
		System.out.println();
	}

	public String toString() {
		String genes = new String();
		for (String allele : alleles) {
			genes += allele + "\n";
		}

		return genes;
	}
}
