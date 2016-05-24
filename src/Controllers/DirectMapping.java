package Controllers;

import Models.CacheMemory;
import Models.MemoryTraceModeling;

import java.awt.*;
import java.util.ArrayList;


public class DirectMapping extends CacheMemory	{

	ArrayList<Integer> memoryTrace;
	int wordLength;
	Container container;

	public DirectMapping(int wordLength,Container c){
		memoryTrace = MemoryTraceColect.collect();
		this.container = c;
		for(int i : memoryTrace){
			mtm = new MemoryTraceModeling(wordLength,)
		}

	}
}



