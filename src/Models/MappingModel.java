package Models;

import java.util.ArrayList;

import Helpers.Functions;

public  class MappingModel extends Functions {
	MemoryTraceModeling[] mtm;
	
	public  MappingModel(int wordLength,int[] memoryTrace) {
		
		for (int i = 0; i < memoryTrace.length; i++) {
			mtm[i] = new MemoryTraceModeling(wordLength, memoryTrace,memoryTrace[i]);
		}

	}
}

	