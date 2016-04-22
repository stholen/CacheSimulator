package Controllers;

import Helpers.Functions;

public class MemoryTraceModeling extends Functions {

	public String tag;
	public String mapping;
	public String shifting;
	public String binary;
	private int words;
	public String word_1;
	public String word_2;
	public String word_3;
	public String word_4;
	int number;

	public MemoryTraceModeling(int word, int number) {

		this.binary = addZeroLeft(number, binaryConverter(number));
		binarySeparator();

	}

	private void binarySeparator() {
		switch (this.words) {
		case 1:
			this.shifting = "";
			this.mapping = this.binary.charAt(-2)+""+this.binary.charAt(-1);
			this.tag = this.binary.substring(0,-3);
			this.word_1 = this.binary;
			break;
		case 2:
			this.shifting = Integer.toString(this.binary.charAt(-1));
			this.mapping = this.binary.charAt(-3)+""+this.binary.charAt(-2);
			this.tag = this.binary.substring(0,-4);
			
			if(this.shifting == "1"){
				this.word_1 = this.tag+this.mapping+"0";
				this.word_2 = this.binary;
			}else if(this.shifting == "0"){
				this.word_1 = this.binary;
				this.word_2 = this.tag+this.mapping+"1";
			}
			break;
		case 4:
			this.shifting = this.binary.charAt(-2)+""+this.binary.charAt(-1);
			this.mapping = this.binary.charAt(-4)+""+this.binary.charAt(-3);
			this.tag = this.binary.substring(0,-3);
			if(this.shifting == "00"){
				this.word_1 = this.binary;
				this.word_2 = this.tag+this.mapping+"01";
				this.word_3 = this.tag+this.mapping+"10";
				this.word_4 = this.tag+this.mapping+"11";
			}else if(this.shifting == "01"){
				this.word_1 = this.tag+this.mapping+"00";
				this.word_2 = this.binary;
				this.word_3 = this.tag+this.mapping+"10";
				this.word_4 = this.tag+this.mapping+"11";
			}else if(this.shifting == "10"){
				this.word_1 = this.tag+this.mapping+"00";
				this.word_2 = this.tag+this.mapping+"01";
				this.word_3 = this.binary;
				this.word_4 = this.tag+this.mapping+"11";
			}else if(this.shifting == "11"){
				this.word_1 = this.tag+this.mapping+"00";
				this.word_2 = this.tag+this.mapping+"01";
				this.word_3 = this.tag+this.mapping+"10";
				this.word_4 = this.binary;
			}
			break;

		}
	}

}
