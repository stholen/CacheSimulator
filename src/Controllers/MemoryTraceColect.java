package Controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MemoryTraceColect {

	  public static ArrayList<Integer> collect() {
	    
		  ArrayList<Integer> memoryTrace = new ArrayList<>();
	       Scanner entrada;
	    try {
	      
	    	entrada = new Scanner(new File("/home/stholen/workspace/CacheSimulator/src/Models/memoryTrace"));
	        while (entrada.hasNextLine()) {
	        memoryTrace.add(entrada.nextInt());
	       
	      }
	        if(memoryTrace.isEmpty()){
	        	JOptionPane.showMessageDialog(null, "Arquivo MemoryTrace vazio \n Preenchimento Obrigatorio","Error",JOptionPane.ERROR_MESSAGE);
	        }
	      entrada.close();
	    } catch (IOException e) {
         JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	    	
	    }
	    
	    return memoryTrace;

	    
	  }
	}