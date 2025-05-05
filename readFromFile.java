package CS170_team_project;

import java.io.*;
import java.util.*;

public class readFromFile {

    public static Map<String, List<Double>> getGrades(String filePath) {
        Map<String, List<Double>> grades = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            List<String[]> data = new ArrayList<>();
            String delimiter = ",";

            // Read header line to figure out delimiter
            if ((line = br.readLine()) != null) {
                if (line.contains(";")) {
                    delimiter = ";";
                }
                data.add(line.split(delimiter));
            }

            // Read rest of the lines
            while ((line = br.readLine()) != null) {
                data.add(line.split(delimiter));
            }

            // Get Grade A (row 4) and Grade B (row 5)
            if (data.size() > 3) {
                grades.put("A", getNumbers(data.get(3)));
            }
            if (data.size() > 4) {
                grades.put("B", getNumbers(data.get(4)));
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }

        return grades;
    }

    // Get numbers (percentages) from a row
    private static List<Double> getNumbers(String[] row) {
        List<Double> numbers = new ArrayList<>();
        for (int i = 4; i < row.length; i++) {
            try {
                String clean = row[i].replace("%", "").replace(",", "").trim();
                double val = Double.parseDouble(clean);
                numbers.add(val);
            } catch (Exception e) {
                // skip bad data
            }
        }
        return numbers;
    }
}
