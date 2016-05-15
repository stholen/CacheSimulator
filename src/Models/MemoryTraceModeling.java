package Models;

import Helpers.Functions;

public class MemoryTraceModeling extends Functions {

	public String tag;
	public int mapping;
	private String binary;
	private int wordLenght;
	private int number;

	public MemoryTraceModeling(int wordLenght, int[] memoryTrace,int memoryTraceItem) {
		this.wordLenght = wordLenght;
		this.number = memoryTraceItem;
		this.binary = addZeroLeft(maxValue(memoryTrace), binaryConverter(memoryTraceItem));
			binarySeparator();
	}

	private void binarySeparator() {
		switch (this.wordLenght) {
		case 1:
			this.mapping = decimalConverter("" + this.binary.charAt(binary.length() - 2) + this.binary.charAt(binary.length() - 1));
			this.tag = this.binary.substring(0, binary.length() - 3);
			
			break;
		case 2:
			
			this.mapping = decimalConverter("" + this.binary.charAt(binary.length() - 3) + this.binary.charAt(binary.length() - 2));
			this.tag = this.binary.substring(0, -4);
			break;
		case 4:
			
			this.mapping = decimalConverter("" + this.binary.charAt(binary.length() - 4) + this.binary.charAt(binary.length() - 3));
			this.tag = this.binary.substring(0, binary.length() - 3);
			
			break;

		}
	}

}
