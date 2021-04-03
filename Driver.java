
public class Driver {

	public static void main(String[] args) {
		if(args.length!= 2) {
			System.exit(1);
		}
		int numChromatids = Integer.parseInt(args[0]);
		int numAlleles = Integer.parseInt(args[1]);
		
		Diploid cell = new Diploid(numChromatids, 10, numAlleles);
		Haploid[] myHaploids = new Haploid[4];
		
		myHaploids = cell.getHaploids(); 
		System.out.println(cell.toString());	
		for(Haploid hap : myHaploids) {
			System.out.println(hap.toString());
		}

	}

}
