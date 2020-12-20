FileInputStream fis = null;
Properties prop = null;
try {
	fis = new FileInputStream(fileName);
	prop = new Properties();
	prop.load(fis);
} catch(FileNotFoundException fnfe) {
	fnfe.printStackTrace();
} catch(IOException ioe) {
	ioe.printStackTrace();
} finally {
	fis.close();
}
return prop;
}

public static String fetchcellValuefromcsv(int row, int col) throws IOException {

	File inputFile = new File(filename1);
	String csvvariable;
	try (CSVReader reader = new CSVReader(new FileReader(inputFile),',')) {
		List<String[]> csvBody = reader.readAll();
		// get CSV row column  and replace with by using row and column
		csvvariable = csvBody.get(row)[col];
	}
	return csvvariable;
} 

// Saves the whole package from one location to another Location
public void save() throws IOException, InterruptedException
{

	Properties prop = readpropertiesFile(filename);
	Properties properties = new Properties();

	// String source = filepath;
	String path = System.getProperty("user.dir");
	String app=path+"\\required_file\\"+item+"\\";
	File appDir = new File(app);
	// File srcDir = new File(source);


	String destination = filename1;
	// String appdestination = "D:/SW-CL-R449A-PWM-CTR-ID5NV6,8/";

	File destDir = new File(destination);
	//  File appdestinationDir = new File(appdestination);

	try {
		// FileUtils.copyDirectory(srcDir, destDir);
		FileUtils.copyDirectory(appDir, destDir);

	} catch (IOException e) {
		e.printStackTrace();
	}

	public void PropertiesSaving file()
	{
		try {
			Properties hsvdall = new Properties() {
				@Override
				public synchronized Enumeration<Object> keys() {
					return Collections.enumeration(new TreeSet<>(super.keySet())); //Sorting of the elements
				}
			};
			hsvdall.putAll(properties);
			hsvdall.store(new FileWriter(destination), null);
			// hsvdall.store(new FileWriter("C:\\Users\\sangadi\\Desktop\\huspar.csv"), null);
		} catch (IOException ex) {
			Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	// To run the .exe through code
	{
		Runtime.getRuntime().exec(filename1, null, new File(filename1+"\\new_file"));
		TimeUnit.SECONDS.sleep(5);
	}
