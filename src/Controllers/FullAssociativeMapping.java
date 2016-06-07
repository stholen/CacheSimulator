package Controllers;

import Helpers.Functions;
import Models.CacheMemory;
import Models.MappingModel;
import Models.MemoryTraceModeling;


import javax.swing.*;
import java.util.Stack;

/**
 * Created by stholen on 05/06/16.
 */
public class FullAssociativeMapping extends Functions {
    int wordSize=0;
    int associativityDegree = 0;
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
        mm = new MappingModel(wordSize,associativityDegree);
        cm = new CacheMemory();
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

        mm = new MappingModel(wordSize,associativityDegree);
        cm = new CacheMemory();
        Stack<MemoryTraceModeling> lista = new Stack<>();
        MemoryTraceModeling[] bloco = new MemoryTraceModeling[associativityDegree];

        for (int i = 0; i < mm.memoryTraceMapped.size(); i++) {

            if (lista.isEmpty()) {
                lista.push(mm.memoryTraceMapped.get(i));
                bloco[i] = mm.memoryTraceMapped.get(i);
                JOptionPane.showMessageDialog(null,bloco[i].number);
                cm.setnMisses();
            } else if (!lista.isEmpty() && !lista.contains(mm.memoryTraceMapped.get(i).tag)) {

                if (lista.size() >= associativityDegree) {
                    lista.pop();
                    lista.push(mm.memoryTraceMapped.get(i));
                    JOptionPane.showMessageDialog(null, bloco[i].number);
                    cm.setnMisses();

                } else {
                    lista.push(mm.memoryTraceMapped.get(i));
                    JOptionPane.showMessageDialog(null, bloco[i].number);
                    cm.setnMisses();
                }
            } else if (!lista.isEmpty() && lista.contains(mm.memoryTraceMapped.get(i).tag)) {
                lista.remove(mm.memoryTraceMapped.get(i));
                lista.push(mm.memoryTraceMapped.get(i));
                JOptionPane.showMessageDialog(null, bloco[i].number);
                cm.getnHits();
            }
        }

        //slotsArea.setText(printCacheMemory());
        resultsArea.setText("RESULTS FOR FULL ASSOCIATIVE - LRU:\n\n" + cm.toString());
    }

    public String printCacheMemory() {

        String data = "\t\n", tag = "\t\n", slots = "\t\n", binary = "\t\n";

        for (int i = 0; i < bloco.length; i++) {
           /* if (bloco[i] != null) {
                data += "|" + String.valueOf(bloco[i].number) + "|\n";
                tag += "|" + bloco[i].tag + "|\n";
                slots += addZeroLeft(associativityDegree, binaryConverter(i)) + ":: |" + bloco[i].binary + "|\n";
            } else {
                data += "|Empty|\n";
                tag += "|Empty|\n";
                slots += addZeroLeft(associativityDegree, binaryConverter(i)) + ":: |Empty|\n";
            }*/
            System.out.println(i);
        }
        String toret = "FINAL STAGE CACHE\n\n\n";
        toret += "DATA: \t\n" + data + "\n";
        toret += "----------------------\n";
        toret += "TAG: \t\n" + tag + "\n";
        toret += "----------------------\n";
        toret += "GA: \t\n" + slots + "\n";

        return toret;
    }
}
