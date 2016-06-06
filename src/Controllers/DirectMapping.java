package Controllers;

import java.awt.Component;
import java.awt.TextArea;

import javax.swing.*;

import Helpers.Functions;
import Models.CacheMemory;
import Models.MappingModel;
import Models.MemoryTraceModeling;

public class DirectMapping extends Functions {
	int wordSize, slotsAmount = 0;
	MappingModel mm;
	CacheMemory cm;
	JTextArea slotsArea;
	JTextArea resultsArea;
	MemoryTraceModeling[] bloco;

	public DirectMapping(int wordSize, int slotsAmount, JTextArea ta_cacheMemory, JTextArea ta_results) {
		this.wordSize = wordSize;
		this.slotsAmount = slotsAmount;
		this.slotsArea = ta_cacheMemory;
		this.resultsArea = ta_results;
	}

	public void fastDirectMapping() {
		mm = new MappingModel(wordSize, slotsAmount);
		cm = new CacheMemory();
		bloco = new MemoryTraceModeling[slotsAmount];
		for (int i = 0; i < mm.memoryTraceMapped.size(); i++) {
			if (bloco[mm.memoryTraceMapped.get(i).mapping] == null) {

				bloco[mm.memoryTraceMapped.get(i).mapping] = mm.memoryTraceMapped.get(i);


				cm.setnMisses();

			} else if (!bloco[mm.memoryTraceMapped.get(i).mapping].tag.equals(mm.memoryTraceMapped.get(i).tag)) {

				bloco[mm.memoryTraceMapped.get(i).mapping] = mm.memoryTraceMapped.get(i);

				cm.setnMisses();

			} else if (bloco[mm.memoryTraceMapped.get(i).mapping].tag.equals(mm.memoryTraceMapped.get(i).tag)) {

				cm.setnHits();
			}

		}

		slotsArea.setText(printCacheMemory());
		resultsArea.setText("RESULTS FOR DIRECT MAPPING:\n\n" + cm.toString());


	}

	public void slowDirectMapping() {

	}

	public String  printCacheMemory() {
		String data="\t\n",tag="\t\n",slots="\t\n",binary ="\t\n";
			for(int i = 0;i<bloco.length;i++) {
				if(bloco[i] != null) {
					data	+= "|"+String.valueOf(bloco[i].number)+"|\n";
					tag		+= "|"+bloco[i].tag+"|\n";
					slots	+= addZeroLeft(slotsAmount,binaryConverter(i))+":: |"+bloco[i].binary+"|\n";
				}else {
					data	+= "|Empty|\n";
					tag		+= "|Empty|\n";
					slots	+= addZeroLeft(slotsAmount,binaryConverter(i))+":: |Empty|\n";
				}
			}
		String toret = "FINAL STAGE CACHE\n\n\n";
		toret += "DATA: \t\n"+data+"\n";
		toret += "----------------------\n";
		toret += "TAG: \t\n" +tag+ "\n";
		toret += "----------------------\n";
		toret += "SLOTS: \t\n"+slots+"\n";

		return toret;


	}
}
