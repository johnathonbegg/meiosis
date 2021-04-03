
public class Haploid {
	Chromatid[] chromatids; 
	int ID; 
	public Haploid(Chromatid[] chromatids, int ID) {
		this.chromatids = chromatids; 
		this.ID = ID; 
	}
	
	public void print() {
		System.out.println("Haploid #" + ID);
		for (Chromatid chrom : chromatids) {
			chrom.print();
		}
	}
	public String toString(){
		String sequence = new String();
		
		sequence += "Haploid ID " + ID + "\n"; 
		for(Chromatid chrom : chromatids){
			sequence += chrom.toString(); 
		}
		
		return sequence;
	}
	public Chromatid[] getChromatids(){
		return chromatids;
	}
	
}
