package group;

import java.io.IOException;
import java.util.ArrayList;

public class Database {

	
	ArrayList<Applicant> database;
	Reader reader;
	Searcher searcher;
	Writer writer;
	String filename;
	
	
	public Database(String filename) {
		this.filename = filename;
		database = new ArrayList<Applicant>();
		reader = new Reader(filename);
		searcher = new Searcher();
		try {
			writer = new Writer(filename, "src/searchResult.txt");
		} catch (IOException io) {
			io.printStackTrace();
		}

		read();
	}
	
	/**
	 * Reads the values from the text file into the array list
	 */
	public void read() {
		//fills up databse with the values
		reader.read(database);
	}
	
	public void search(String searchType, String searchValue) throws IOException {
		ArrayList<Applicant> temp = searcher.search(database, searchType, searchValue);
		writer.writeOutput(temp);
	}
	
	public void addApplicant() {
		
	}
	
	
}
