package Assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Assignment {

	public static void main(String[] args) throws IOException {
		String delimiter = "\n";
		StringBuilder content = new StringBuilder();
		StringBuilder sortedContent = new StringBuilder();
		int NUMBER = 1000000;
		
		//Create random number with delimiter 
		for(int i = 0; i < NUMBER; i++) {
			content.append(Math.random() + delimiter);
		}
		
		//Create a file with random number
		createFile("randomNum.txt", content.toString());
		
		//Read file and convert output to sorted array
		String[] array = readFile("randomNum.txt").split(delimiter);
		Arrays.sort(array);
		
		//Create content with sorted elements of array
		for(String s : array) {
			sortedContent.append(s + delimiter);
		}
		
		//Create a file with sorted number
		createFile("sortedNum.txt", sortedContent.toString());
	}
	
	public static void createFile(String filename, String content) {
		try (FileWriter writer = new FileWriter(filename);
	             BufferedWriter bw = new BufferedWriter(writer)) {
	            bw.write(content);

	        } catch (IOException e) {
	            System.err.format("IOException: %s%n", e);
	        }
	}
	
	public static String readFile(String filename) throws IOException {
		StringBuilder output = new StringBuilder();
		String line;
		
		try {
			FileReader fileReader = new FileReader(filename);
			BufferedReader buffReader = new BufferedReader(fileReader);
			
			while((line = buffReader.readLine()) != null) {
				output.append(line + "\n");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output.toString();
	}
}
