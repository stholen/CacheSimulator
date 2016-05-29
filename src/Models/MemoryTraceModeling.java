package Models;

import Helpers.Functions;

import java.util.ArrayList;

public class MemoryTraceModeling extends Functions {

	public String tag;
	public int mapping;
	public boolean validBit= false;
	private	int slots;
	public String binary;
	private int wordLenght;
	public int number;
	private int tagCut;
	

	public MemoryTraceModeling(int wordLenght, ArrayList<Integer> memoryTrace,int memoryTraceItem,int slots) {
		this.wordLenght = wordLenght;
		this.slots = slots;
		this.number = memoryTraceItem; 
		this.binary = addZeroLeft(maxValue(memoryTrace), binaryConverter(memoryTraceItem));
		tagCut = (int) Math.ceil((Math.log(slots)/Math.log(2)));
		binarySeparator();
	}

	private void binarySeparator() {
		switch (this.wordLenght) {
		case 1:
			this.mapping = number%slots;
			this.tag = this.binary.substring(0, binary.length() - tagCut);
			this.validBit = true;
			break;
		case 2:
			
			this.mapping = number%slots;
			this.tag = this.binary.substring(0,binary.length()- (tagCut+1));
			this.validBit = true;
			break;
		case 4:
			
			this.mapping = number%slots;
			this.tag = this.binary.substring(0, binary.length() - (tagCut+2));
			this.validBit = true;
			break;

		}
	}

}
