package CS170_team_project;

import java.io.*;
import java.util.*;

public class readFromFile {

    public static Map<String, Map<String, Double>> getGrades(String filePath) {
        // Map to store grades for A and B as lists of numbers
        Map<String, List<Double>> grades = new HashMap<>();
        List<String> semesters = new ArrayList<>();
        List<Double> gradeAList = new ArrayList<>();
        List<Double> gradeDList = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath)); // Opens the file to read using BufferedReader
            String line; // Stores each line
            List<String[]> data = new ArrayList<>(); // List to hold each row split into columns
            String delimiter = ","; // Set delimiter to a comma so we know where to spilt the data
           
            // Reads the file line by line
            while ((line = br.readLine()) != null) {
                // Each line is split into columns using the delimiter and added to the data list
                data.add(line.split(delimiter));
            }
            
            if (data.size() > 6) { // checks for minimum  list size
                // Row 0 contains the semester names
                semesters = getStrings(data.get(0));
                // Row 3 contains grade A percentages
                gradeAList = getNumbers(data.get(3));
                // Row 4 contains grade D percentages
                gradeDList = getNumbers(data.get(6));
            } 
            
            // Checks if there are at least 4 rows and gets data from the 4th row (index 3)
            if (data.size() > 3) {
                // Get the values from the 4th row and store them under key "A" using the helper function
                grades.put("A", getNumbers(data.get(3)));
            }

            // Checks if there are at least 5 rows and gets data from the 5th row (index 4)
            if (data.size() > 4) {
                // Get the values from the 5th row and store them under key "B" using the helper function
                grades.put("D", getNumbers(data.get(4)));
            } 

        } catch (IOException e) {
            // If there's an error while reading the file, print a message
            System.out.println("Error reading file.");
        }
        //Put everything into a map
        //Make the outer map
        Map<String, Map<String, Double>> data = new TreeMap<>();
        //For each element in the semesters array
        for (int i = 0; i < semesters.size(); i++)
        {
            //make the inner map HashMap<String, Double> innerMap
        	HashMap<String, Double> innerMap = new HashMap<>();
            //innerMap.put("A", gradeA[i])
        	innerMap.put("A", gradeAList.get(i));
            //innerMap.put("D", gradeD[i++])
        	innerMap.put("D", gradeDList.get(i));
            //data.put(element, innermap)
        	data.put(semesters.get(i), innerMap);
        }
        
        // Return the map that contains the grades
        return data; 
        
    }

    private static List<String> getStrings(String[] row) {
        List<String> strings = new ArrayList<>();
        // Start at column 3(skip the commas) and go though grabbing the strings
        for (int i = 2; i < row.length; i += 2) {
            strings.add(row[i].trim());
        }
        return strings;
    }

    private static List<Double> getNumbers(String[] row) {
        List<Double> numbers = new ArrayList<>(); // List to store the numbers

        // Start from the 5th column (index 5) and go through the rest of the row
        for (int i = 4; i < row.length; i++) {
            try {
                // Remove commas and extra spaces
                String clean = row[i].replace(",", "").trim();

                // If the value has a '%' sign, treat it as a percentage
                if (clean.contains("%")) {
                    // Remove the % sign and parse the number
                    clean = clean.replace("%", "").trim();
                    
                    // Convert the cleaned string to a double
                    double val = Double.parseDouble(clean);

                    // Add the percentage value to the list
                    numbers.add(val);
                }
            } catch (Exception e) {
                // If the value can't be converted to a number, just skip it
            }
        }

        // Return the list of numbers (percentages)
        return numbers;
    }
}
