package Controllers;


import java.util.ArrayList;

import Helpers.Functions;

public class Mappings  extends Functions{

	
	private ArrayList<Integer> memorytrace;
	private int[] slots;
	private int words;
	private int map;
	private int hit= 0;
	private int miss = 0;
	private String tag;
	private String binary;
	private String temp;
	private String shifting;
	
	/**
	 * Metodo para Mapeamento Diretor onde verifico cada parte do numero binario e realizo os calculos para alocar
	 * um dado numero na cache
	 * @param mt - parametro que recebe um array de numeros inteiros e que formam o Memory Trace
	 * @param slots -parametro que recebe por default o numero 4 como quantidade de slots que a aplicação irá trabalhar
	 * @param words - recebe um inteiro, definindo o tamanho da palavra
	 */
	
	public  void directMapping(int[] mt,int words){
		slots = new int[4];
		switch(words){
		case 1:
				for(int i = 0;i<mt.length;i++){
						setBinary(binaryConverter(mt[i]));
						setBinary(addZeroLeft(mt[i],binary));
						setTemp(binary.charAt(mt[i]-2)+""+binary.charAt(mt[i]-1));
						setMap(decimalConverter(temp));
						setTag(binary.substring(0,-3));
						
						if(getSlots()[map] == mt[i]){
							setHit();
						}else if(getSlots()[map] != 0 && getSlots()[map] != mt[i]  ){
							setMiss();
							getSlots()[map] = mt[i];
						}else if (getSlots()[map] == 0){
							setMiss();
							getSlots()[map] = mt[i];
						}
						
				}
			;break;
		case 2:
			for(int i = 0;i<mt.length;i++){
				binary = binaryConverter(mt[i]);
				binary = addZeroLeft(mt[i],binary);
				//shifting = binaryConverter(mt[i]).charAt(-1)+"";
				temp = binary.charAt(mt[i]-3)+""+binary.charAt(mt[i]-2);
				map = decimalConverter(temp);
				tag = binary.substring(0,-4);
				
				if(slots[map] == mt[i]){
					hit ++;
				}else if(slots[map] != 0 && slots[map] != mt[i]  ){
					miss ++;
					slots[map] = mt[i];
				}else if (slots[map] == 0){
					miss++;
					slots[map] = mt[i];
				}
				
		}
	;break;
}
}
	public ArrayList<Integer> getMemorytrace() {
		return memorytrace;
	}

	public void setMemorytrace(ArrayList<Integer> memorytrace) {
		this.memorytrace = memorytrace;
	}

	public int[] getSlots() {
		return slots;
	}

	public void setSlots(int[] slots) {
		this.slots = slots;
	}

	public int getWords() {
		return words;
	}

	public void setWords(int words) {
		this.words = words;
	}

	public int getMap() {
		return map;
	}

	public void setMap(int map) {
		this.map = map;
	}

	public int getHit() {
		return hit;
	}

	public void setHit() {
		this.hit ++;
	}

	public int getMiss() {
		return miss;
	}

	public void setMiss() {
		this.miss++;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getBinary() {
		return binary;
	}

	public void setBinary(String binary) {
		this.binary = binary;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getshifting() {
		return shifting;
	}

	public void setshifting(String shifting) {
		this.shifting = shifting;
	}
	
}