package View;

import java.util.ArrayList;
import java.util.Stack;

import Controllers.DirectMapping;
import Helpers.Functions;
import Models.CacheMemory;
import Models.MappingModel;
import Models.MemoryTraceColect;
import Models.MemoryTraceModeling;

import javax.swing.*;

public class program  extends Functions{
   
	public static void main(String[] args) {

		DirectMapping dm  = new DirectMapping(2,4,new JTextArea(),new JTextArea());
		dm.fastDirectMapping();
			

	}
}


