package Controllers;

import Models.CacheMemory;
import Models.MappingModel;



public abstract class DirectMapping extends CacheMemory {
	MappingModel mm;
	
	public DirectMapping(int[] memoryTrace,int wordLength) {
		mm = new MappingModel(wordLength, memoryTrace);
	}
	
public abstract void mappinger();

	
}
