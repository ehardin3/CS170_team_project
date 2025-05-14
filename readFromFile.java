package CS170_team_project;

import java.io.*;
import java.util.*;

public class readFromFile {
	
//	  public static Map<Integer, Map<String, Map<String, Double>>> getGrades (String filePath)
    public static Map<String, Map<String, Double>> getGrades(String filePath) {
        // Map to store semesters and stats for A and D grades
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
            
            if (data.size() > 6) { // makes sure that there's enough lines
                // Row 0 contains the semester names
                semesters = getStrings(data.get(0));
                // Row 3 contains grade A percentages
                gradeAList = getNumbers(data.get(3));
                // Row 4 contains grade D percentages
                gradeDList = getNumbers(data.get(6));
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
/*        
        //Make a list of ordered semesters for sorting map later
        List<String> orderedSems = new ArrayList<>();
        orderedSems = orderSemestersChronologically(semesters);
        
        //Put everything into a map
        //Make the outer map
        Map<Integer, Map<String, Map<String, Double>>> sortedSemData = new TreeMap<>();
        //For each element in the semesters array
        for (int i = 0; i < semesters.size(); i++)
        {
            //make the innermost map HashMap<String, Double> innerMap
        	HashMap<String, Double> innerMap = new HashMap<>();
            //innerMap.put("A", gradeA[i])
        	innerMap.put("A", gradeAList.get(i));
            //innerMap.put("D", gradeD[i++])
        	innerMap.put("D", gradeDList.get(i));
            //Make the middle map and data.put(element, innermap)
        	Map<String, Map<String, Double>> semData = new HashMap<>();
        	semData.put(semesters.get(i), innerMap);
        	//Assign index of current semester in ordered list as location in TreeMap
        	sortedSemData.put(orderedSems.indexOf(semesters.get(i)), semData);
        }
        
        //Order the map using its position from orderedSems
        
        for(int i = 0; i < semesters.size(); i++) {
        	sortedSemData.put(i, semData);
        }
 
        // Return the map that contains the grades
        return sortedSemData;         
    }
*/
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
/*
    // Helper method which defines semesters (Spring is 1, Summer is 2, Fall is 3)
    private static int termOrder(String term) {
        switch (term) {
            case "Spring": return 1;
            case "Summer": return 2;
            case "Fall": return 3;
            default: return 0;
        }
    }
    // Method that takes list of unsorted semesters and sorts them into chronological order
    public static List<String> orderSemestersChronologically(List<String> sem)
    {
            sem.sort((s1, s2) -> {
            String[] parts1 = s1.split(" ");
            String[] parts2 = s2.split(" ");

            if (parts1.length < 2 || parts2.length < 2) return 0;

            String term1 = parts1[0];
            String term2 = parts2[0];

            int year1 = Integer.parseInt(parts1[1]);
            int year2 = Integer.parseInt(parts2[1]);

            // First compares by year
            int yearCompare = Integer.compare(year1, year2);
            if (yearCompare != 0) return yearCompare;

            // If years are the same, compares by term order
            return Integer.compare(termOrder(term1), termOrder(term2));
        });

        System.out.println("Semesters displayed in chronological order:");
        for (String s:sem)
        {
        System.out.println(" * " + s);
    }
        return sem;
*/
    
}
