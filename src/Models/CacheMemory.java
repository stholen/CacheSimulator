package Models;

import java.text.DecimalFormat;

import javax.swing.plaf.DesktopIconUI;

public class CacheMemory {

	
	private int nHits,nMisses= 0;
	private double speedUp = 0;
	
	

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
		
		DecimalFormat df = new DecimalFormat("0.##");
		String toret = "";
		toret += "Hits: \t" + getnHits() + "\n";
		toret += "Misses: \t" + getnMisses() + "\n";
		toret += "Miss rate: \t" + df.format((getnMisses() * 100.0) / (getnHits() + getnMisses())) + " %\n";
		toret += "Hit rate: \t" + df.format((getnHits()* 100.0) / (getnHits() + getnMisses())) + " %\n";
		return toret;
	}
}
