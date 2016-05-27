package Models;

import java.util.ArrayList;

import Helpers.Functions;

public  class MappingModel  {
	MemoryTraceModeling[] mtm;
	ArrayList<Object> memoryTraceMapped =  new ArrayList<>();
	
	public  MappingModel(int wordLength,ArrayList<Integer> memoryTrace,int slots) {
		
		for (int i = 0; i < memoryTrace.size(); i++) {
			memoryTraceMapped.add(mtm[i] = new MemoryTraceModeling(wordLength,memoryTrace,memoryTrace.get(i),slots));
		}

	}
}

	