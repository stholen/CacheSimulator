package Controllers;

import Helpers.Functions;

public class Mappings extends Functions {
	MemoryTraceModeling[] mtm;
	private int mappingOption;
	MemoryTraceModeling[] slots = new MemoryTraceModeling[4];
	public int hit, miss = 0;

	public Mappings(int[] memoryTrace, int words, int mappingOption) {
		this.mappingOption = mappingOption;
		for (int i = 0; i < memoryTrace.length; i++) {
			mtm[i] = new MemoryTraceModeling(words, memoryTrace[i]);
		}

	}

	public void directMapping() {

		for (int i = 0; i < mtm.length; i++) {
			if (slots[decimalConverter(mtm[i].mapping)] == null) {
				slots[decimalConverter(mtm[i].mapping)] = mtm[i];
			} else if (slots[decimalConverter(mtm[i].mapping)].tag
					+ slots[decimalConverter(mtm[i].mapping)].mapping == mtm[i].tag + mtm[i].mapping) {
				hit++;
			} else if (slots[decimalConverter(mtm[i].mapping)].tag
					+ slots[decimalConverter(mtm[i].mapping)].mapping != mtm[i].tag + mtm[i].mapping) {
				miss++;
				slots[decimalConverter(mtm[i].mapping)] = mtm[i];
			}

		}

	}
	
	public void fullAssociativeFIFO(){
		
	}
	public void FullAssociativeLRU(){
		
	}
}