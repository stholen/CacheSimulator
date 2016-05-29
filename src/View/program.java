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
		int amountSlots = 4;
		MappingModel mm = new MappingModel(1,amountSlots);
		CacheMemory cm = new CacheMemory();

	
		Stack<MemoryTraceModeling> lista = new Stack<>();
		MemoryTraceModeling[] bloco = new MemoryTraceModeling[amountSlots];
		
		
			for (int i = 0; i < mm.memoryTraceMapped.size(); i++) {
				  
				if(lista.isEmpty()){
					lista.push(mm.memoryTraceMapped.get(i));
					bloco[i] = mm.memoryTraceMapped.get(i);
					System.out.println(lista.get(i).binary);
					
					cm.setnMisses();
				}else if(!lista.isEmpty() && !lista.contains(mm.memoryTraceMapped.get(i).tag)) {
					
					if(lista.size() >= amountSlots) {
						lista.pop();
						lista.push(mm.memoryTraceMapped.get(i));
						cm.setnMisses();
					
					}else {
						lista.push(mm.memoryTraceMapped.get(i));
						cm.setnMisses();
					}
				}else if(!lista.isEmpty() && lista.contains(mm.memoryTraceMapped.get(i).tag)) {
					lista.remove(mm.memoryTraceMapped.get(i));
					lista.push(mm.memoryTraceMapped.get(i));
					cm.getnHits();
				}
			}
			
			

	}
}


