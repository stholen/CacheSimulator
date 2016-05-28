package View;

import java.util.ArrayList;

import Helpers.Functions;
import Models.CacheMemory;
import Models.MappingModel;
import Models.MemoryTraceColect;
import Models.MemoryTraceModeling;

public class program  extends Functions{
   
	public static void main(String[] args) {
		MappingModel mm = new MappingModel(2,4);
		MemoryTraceModeling[] bloco = new MemoryTraceModeling[4];
		CacheMemory cm = new CacheMemory();
		for(int i = 0; i< mm.memoryTraceMapped.size();i++) {
			if(bloco[mm.memoryTraceMapped.get(i).mapping] ==  null) {
				bloco[mm.memoryTraceMapped.get(i).mapping] = mm.memoryTraceMapped.get(i);
				cm.setnMisses();
				//System.out.println("Palavra: "+bloco[mm.memoryTraceMapped.get(i).mapping].number);
				//System.out.println("Tag: "+bloco[mm.memoryTraceMapped.get(i).mapping].tag);
				System.out.println("mapeamento: "+bloco[mm.memoryTraceMapped.get(i).mapping].mapping);
			}else if(bloco[mm.memoryTraceMapped.get(i).mapping].mapping != mm.memoryTraceMapped.get(i).mapping) {
				bloco[mm.memoryTraceMapped.get(i).mapping] = mm.memoryTraceMapped.get(i);
				cm.setnMisses();
				//System.out.println("Palavra: "+bloco[mm.memoryTraceMapped.get(i).mapping].number);
				//System.out.println("Tag: "+bloco[mm.memoryTraceMapped.get(i).mapping].tag);
				System.out.println("mapeamento: "+bloco[mm.memoryTraceMapped.get(i).mapping].mapping);
			}else if(bloco[mm.memoryTraceMapped.get(i).mapping].mapping == mm.memoryTraceMapped.get(i).mapping) {
				//System.out.println("Palavra: "+bloco[mm.memoryTraceMapped.get(i).mapping].number);
				//System.out.println("Tag: "+bloco[mm.memoryTraceMapped.get(i).mapping].tag);
				System.out.println("mapeamento: "+bloco[mm.memoryTraceMapped.get(i).mapping].mapping);
				cm.setnHits();
			}
		}
					
			System.out.println(cm.toString());
		}

	}


