package Controllers;

import Models.CacheMemory;
import Models.MappingModel;
import View.MainScreen;

public class DirectMapping extends CacheMemory	{
	MainScreen ms = new MainScreen();
	MappingModel mm = new MappingModel(wordLength, memoryTrace);
	
}



