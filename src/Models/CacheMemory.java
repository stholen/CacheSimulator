package Models;

public class CacheMemory {

	
	private int nHits,nMisses= 0;
	

	public int getnHits() {
		return nHits;
	}

	public void setnHits() {
		this.nHits ++;
	}

	public int getnMisses() {
		return nMisses;
	}

	public void setnMisses() {
		this.nMisses++;
	}
	
	@Override
	public String toString() {
		String toret = "";
		toret += "Hits: \t\t\t" + getnHits() + "\n";
		toret += "Misses: \t\t" + getnMisses() + "\n";
		toret += "Miss rate: \t\t" + (getnMisses() * 100.0) / (getnHits() + getnMisses()) + " %";
		return toret;
	}
}
