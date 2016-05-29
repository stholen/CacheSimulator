package Models;

import Helpers.Functions;

import java.util.ArrayList;

public class MemoryTraceModeling extends Functions {

	public String tag;
	public String tagfack;
	public int mapping;
	public int word2 = Integer.MAX_VALUE;
	public int word3 = Integer.MAX_VALUE;
	public int word4 = Integer.MAX_VALUE;
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
			if(binary.charAt(binary.length()-1)== '0') {
				word2 = this.number+1;
			}else if(binary.charAt(binary.length()-1)== '1') {
				word2 = this.number-1;
			}
			this.mapping = number%slots;
			this.tag = this.binary.substring(0,binary.length()- (tagCut+1));
			this.validBit = true;
			break;
		case 4:
			if((binary.charAt(binary.length()-2)+""+binary.charAt(binary.length()-1)).equals("00")) {
				word2 = this.number+1;
				word3 = this.number+2;
				word4 = this.number+3;
			}else if((binary.charAt(binary.length()-2)+""+binary.charAt(binary.length()-1)).equals("01")) {
				
				word2 = this.number-1;
				word3 = this.number+1;
				word4 = this.number+2;
			}else if((binary.charAt(binary.length()-2)+""+binary.charAt(binary.length()-1)).equals("10")) {
				tagfack =binary.charAt(binary.length()-2)+""+binary.charAt(binary.length()-1);
				word2 = this.number-2;
				word3 = this.number-1;
				word4 = this.number+1;
			}else if((binary.charAt(binary.length()-2)+""+binary.charAt(binary.length()-1)).equals("11")) {
				tagfack =  binary.charAt(binary.length()-2)+""+binary.charAt(binary.length()-1);
				word2 = this.number-3;
				word3 = this.number-2;
				word4 = this.number-1;
			}
			this.mapping = number%slots;
			this.tag = this.binary.substring(0, binary.length() - (tagCut+2));
			this.validBit = true;
			break;

		}
	}

}
