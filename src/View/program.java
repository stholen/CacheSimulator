package View;

import java.util.ArrayList;
import java.util.Stack;

import Helpers.Functions;
import Models.CacheMemory;
import Models.MappingModel;
import Models.MemoryTraceColect;
import Models.MemoryTraceModeling;

public class program  extends Functions{
   
	public static void main(String[] args) {
		
		MemoryTraceModeling  mm = new MemoryTraceModeling(4, MemoryTraceColect.collect(),MemoryTraceColect.collect().get(0),4);
		System.out.println(mm.binary+"\n");
		System.out.println(mm.tag+"\n");
		System.out.println(mm.number);
		System.out.println(mm.word2);
		System.out.println(mm.word3);
		System.out.println(mm.word4);
			

	}
}


