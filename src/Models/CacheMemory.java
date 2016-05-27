package Models;

public class CacheMemory {

	boolean valid = false;
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
}
