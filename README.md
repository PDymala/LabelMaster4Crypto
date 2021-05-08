# LabelMaster4Crypto

 Following application is a part of Label Master 4 package. It's purpose is to create 2 data bases, one for machine learning purpose and second- for printing (as a QR) and later on- to be verified by Android app. 
 It uses newest WEKA for convenience purpose- has couple of useful modules. Model machine learning uses old version of WEKA 3.4.1. That is the only version available on Android and both, model and verification app has to have the same version.
 
 instruction on how to use
*		Mltrainingsetproduction.class - list the parameters and create CSV database - training set.
*		CsvToArff.class - change the CSV into Arff file - acceptable by WEKA machine learning
*		if needed CsvToPrintableCsv - change the CSV into CSV with printable characters -
*		createPrintableFileDb(from,to) - database of numbers and hashed to be printed as QR code ale later varified by Android APP		
*	    later on, go to LabelMaster4MLTraining to train your machine learning model with data base you created here. Such train model has to be added to Android app
	
