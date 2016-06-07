package Controllers;

import Models.CacheMemory;
import Models.MappingModel;
import Models.MemoryTraceModeling;

import javax.swing.*;

/**
 * Created by stholen on 05/06/16.
 */
public class SetAssociativeMapping {

    int wordSize=0;
    int associativityDegree = 0;
    int slots = 0;
    MappingModel mm;
    CacheMemory cm;
    JTextArea slotsArea;
    JTextArea resultsArea;
    MemoryTraceModeling[] bloco;
}
