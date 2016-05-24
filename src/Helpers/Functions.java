package Helpers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Classe criada para agregar func�oes que ajudam em calculos e outras necessidades no decorrer da aplicacao
 * a mesma e caracterizada como uma classe de ajuda.
 * @author emerson.mendes
 *
 */

public class Functions {
	
	int decimal,max= 0;
	String binary;
	
	/**
	 * Metodo que convert um valor decimal do tipo "int" para um binario de tipo "String" 
	 * @param value  -  parametro que recebe um decimal de tipo "inteiro"
	 * @return - retorna um binario de tipo "String"
	 */
	
	protected String binaryConverter(int value){
		binary = Integer.toString(value,2);
		return binary;
	}
	
	/**
	 * Metodo que convert um valor binario do tipo "String" para um decimal de tipo "int"
	 * @param value - parametro que recebe um binario de tipo "String"
	 * @return - retorna um decimal de tipo "inteiro"
	 */
	
	protected int decimalConverter(String value){
		decimal = Integer.parseInt(value,2);
		return decimal;
	}
	
	/**
	 * Metodo que avalia o tamanho necessario para se representar um binario, 
	 * adcionando "zeros" a esquerda quando se faz necessario
	 * @param number - Parametro que recebe o numero do memory trace para que 
	 * @param binary - parametro que recebe um numero binario de tipo "String"
	 * @return - retona um binario de tipo "String"
	 */
	protected String addZeroLeft(int number,String binary){
		 int width = (int) Math.ceil((Math.log(number)/Math.log(2)))-binary.length();
		 if(width > 0){
			 for(int i = 0;i<width;i++){
				 binary = "0"+binary;
			 }
		 }
		
		return binary;
	}
	
	protected int maxValue(ArrayList<Integer> array){
		for(int i : array){
			if(i>max){
				max = i;
			}
		}
		return max;
	}
	public void desableComponets(Container obj,Boolean boo){
		try{
			for(Component cp : obj.getComponents()){
				cp.setEnabled(boo);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		
	
	}

}
