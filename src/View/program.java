package View;

import java.util.ArrayList;

import Helpers.Functions;
import Models.MappingModel;
import Models.MemoryTraceColect;
import Models.MemoryTraceModeling;

public class program  extends Functions{
   
	public static void main(String[] args) {
		
		MappingModel mm = new MappingModel(2, MemoryTraceColect.collect(),4);

	}

}
