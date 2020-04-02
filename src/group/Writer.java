package group;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {

	PrintWriter databaseWriter;
	PrintWriter outputWriter;
	
	File databaseFile;
	File outputFile;
	
	public Writer(String databaseFileName, String outputFileName) throws IOException{
					
			databaseFile = new File(databaseFileName);
			outputFile = new File(outputFileName);
	}
	
	
	/**
	 * This is for printing out after a search is done
	 * @param outputList the list of Applicants being printed out
	 * @throws IOException 
	 */
	public void writeOutput(ArrayList<Applicant> outputList) throws IOException {
		
		outputWriter = new PrintWriter(outputFile);
		outputWriter.write("");
		
		//delete the file and make a new one to ensure that the output file is empty for each search
		if(outputFile.exists()) {
			System.out.println("resetting search file");
			outputFile.delete();
			outputFile.createNewFile();
			System.out.println("successfully reset file");
		}
		
		//id, first, last, address, email, phone number, education score, experience score, skill score, communication score
		//overall score
		
		for(int i = 0; i < outputList.size(); i++) {
			System.out.println("writing : " + outputList.get(i).toString());
			outputWriter.append(outputList.get(i).getId() + "\n" + 
					outputList.get(i).getFirstName() + "\n" + outputList.get(i).getLastName() + "\n" + 
					outputList.get(i).getEmail() + "\n" + outputList.get(i).getPhoneNumber() + "\n" + 
					outputList.get(i).getEducationScore() + "\n" + outputList.get(i).getExperienceScore() + "\n" + 
					outputList.get(i).getSkillScore() + "\n" + outputList.get(i).getCommunicationScore() + "\n" + 
					outputList.get(i).getOverallScore() + "\n");
			outputWriter.append("------------------------------------------------\n");
		}
		System.out.println("Successfully wrote search results");
		outputWriter.close();
	}
	
	
	public void addApplicant(Applicant applicant) throws IOException {
		databaseWriter = new PrintWriter(databaseFile);
		databaseWriter.write(applicant.getId() + "\n" + applicant.getFirstName() + "\n" + applicant.getLastName() +
				"\n" + applicant.getEmail() + "\n" + applicant.getPhoneNumber() + "\n" + applicant.getEducationScore() + 
				"\n" + applicant.getExperienceScore() + "\n" + applicant.getSkillScore() + "\n" + applicant.getCommunicationScore() +
				"\n" + applicant.getOverallScore());
		databaseWriter.write("------------------------------------------------");
		databaseWriter.close();
		
	}
	
	
	
}
