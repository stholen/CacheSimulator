package Models;

import java.util.ArrayList;

import Helpers.Functions;

public  class MappingModel  {
	MemoryTraceModeling mtm;
	 public ArrayList<MemoryTraceModeling> memoryTraceMapped =  new ArrayList<>();
	
	public  MappingModel(int wordLength,int slots) {
		
		for (int i = 0; i < MemoryTraceColect.collect().size(); i++) {
          mtm = new MemoryTraceModeling(wordLength, MemoryTraceColect.collect(),MemoryTraceColect.collect().get(i), slots);
          memoryTraceMapped.add(mtm);
		}

	}
}

	