package Controllers;

import Helpers.Functions;
import Models.CacheMemory;
import Models.MappingModel;
import Models.MemoryTraceModeling;


import javax.swing.*;

/**
 * Created by stholen on 05/06/16.
 */
public class FullAssociativeMapping extends Functions {
    int wordSize, associativityDegree = 0;
    MappingModel mm;
    CacheMemory cm;
    JTextArea slotsArea;
    JTextArea resultsArea;
    MemoryTraceModeling[] bloco;


    public FullAssociativeMapping(int wordSize, int associativityDegree, JTextArea ta_cacheMemory, JTextArea ta_results) {
        this.wordSize = wordSize;
        this.associativityDegree = associativityDegree;
        slotsArea = ta_cacheMemory;
        resultsArea = ta_results;
    }

    public void fifo() {

        bloco = new MemoryTraceModeling[associativityDegree];

        for (int i = 0; i < mm.memoryTraceMapped.size(); i++) {
            if (bloco[i % associativityDegree] == null) {
                bloco[i % associativityDegree] = mm.memoryTraceMapped.get(i);
                cm.setnMisses();
            } else if (!Functions.contains_in_array(bloco, mm.memoryTraceMapped.get(i).number)) {
                bloco[i % associativityDegree] = mm.memoryTraceMapped.get(i);
                cm.setnMisses();
            } else if (Functions.contains_in_array(bloco, mm.memoryTraceMapped.get(i).number)) {
                cm.setnHits();
            }
        }
        slotsArea.setText(printCacheMemory());
        resultsArea.setText("RESULTS FOR FULL ASSOCIATIVE - FIFO:\n\n" + cm.toString());
    }

    public void LRU() {
    }

    public String printCacheMemory() {

        String data = "\t\n", tag = "\t\n", slots = "\t\n", binary = "\t\n";

        for (int i = 0; i < bloco.length; i++) {
            if (bloco[i] != null) {
                data += "|" + String.valueOf(bloco[i].number) + "|\n";
                tag += "|" + bloco[i].tag + "|\n";
                slots += addZeroLeft(associativityDegree, binaryConverter(i)) + ":: |" + bloco[i].binary + "|\n";
            } else {
                data += "|Empty|\n";
                tag += "|Empty|\n";
                slots += addZeroLeft(associativityDegree, binaryConverter(i)) + ":: |Empty|\n";
            }
        }
        String toret = "FINAL STAGE CACHE\n\n\n";
        toret += "DATA: \t\n" + data + "\n";
        toret += "----------------------\n";
        toret += "TAG: \t\n" + tag + "\n";
        toret += "----------------------\n";
        toret += "SLOTS: \t\n" + slots + "\n";

        return toret;
    }
}
