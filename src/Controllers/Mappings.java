package Controllers;

public class Mappings {
	MemoryTraceModeling mtm;

	public void directMapping(int[] memoryTrace, int word) {
		for (int i = 0; i < memoryTrace.length; i++) {
			mtm = new MemoryTraceModeling(word, memoryTrace[i]);
			
		}

	}

}