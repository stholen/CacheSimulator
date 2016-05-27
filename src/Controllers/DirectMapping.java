package Controllers;

import java.util.ArrayList;

import Models.CacheMemory;
import Models.MappingModel;
import Models.MemoryTraceModeling;

public abstract class DirectMapping extends CacheMemory {
	MemoryTraceModeling[] mtm;
	ArrayList<Object> memoryTraceMapped =  new ArrayList<>();
	public DirectMapping(int wordLength,ArrayList<Integer> memoryTrace,int slots) {
		for (int i = 0; i < memoryTrace.size(); i++) {
			memoryTraceMapped.add(mtm[i] = new MemoryTraceModeling(wordLength,memoryTrace,memoryTrace.get(i),slots));
		}
	}
	
	abstract void mapper();
	

}
