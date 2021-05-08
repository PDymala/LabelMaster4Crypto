package weka;
import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

public class CsvToArff {

	public static void main(String[] args) throws IOException {
	
		
		//Changing CSV into ARFF type of file needed for WEKA machine learning.
		
		CSVLoader loader = new CSVLoader();
		loader.setSource(new File("Trainingset_hash_50000_9_32mixOfHashes.csv"));
		Instances data = loader.getDataSet();
		
		
		ArffSaver saver = new ArffSaver();
		saver.setInstances(data);
		saver.setFile(new File("Trainingset_hash_50000_9_32mixOfHashes.arff"));
		saver.writeBatch();
		
		
		
	}

}
