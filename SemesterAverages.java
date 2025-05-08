import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class SemesterAverages {
    public static void main(String[] args) {
        // this is the treeMap will keep the semesters sorted automatically
        TreeMap<String, Double> semesterToPercentA = new TreeMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("grades.csv"));
            String headerLine = reader.readLine(); // the first line has semester names
            String dataLine = reader.readLine();   // the second line has percent A grades

            if (headerLine != null && dataLine != null) {
                String[] headers = headerLine.split(",");
                String[] percents = dataLine.split(",");

                // it sstart at column 6 where semester data begins
                for (int i = 6; i < headers.length; i++) {
                    String semester = headers[i].trim();
                    String rawPercent = percents[i].replace("%", "").trim();

                    try {
                        double percentA = Double.parseDouble(rawPercent);
                        semesterToPercentA.put(semester, percentA);
                    } catch (NumberFormatException e) {
                        System.out.println("Couldn't parse percent for " + semester);
                    }
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // this wil print results
        System.out.println("Percent A grades by semester (sorted):");
        for (String semester : semesterToPercentA.keySet()) {
            System.out.println(semester + ": " + semesterToPercentA.get(semester) + "% A");
        }
    }
}
