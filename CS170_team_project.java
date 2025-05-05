package CS170_team_project;

import java.util.*;

public class CS170_team_project {
    public static void main(String[] args) {
        String filePath = "C:/Users/keybl/Downloads/GradesSumm.csv";

        // Get the grades from the file
        Map<String, List<Double>> gradeData = readFromFile.getGrades(filePath);

        // Show some Grade A values
        System.out.println("Grade A Sample:");
        List<Double> gradeA = gradeData.get("A");
        if (gradeA != null) {
            int count = 0;
            for (int i = 0; i < gradeA.size(); i++) {
                System.out.println(gradeA.get(i) + "%");
                count++;
                if (count == 2) {
                    break;
                }
            }
        }

        // Show some Grade B values
        System.out.println("\nGrade B Sample:");
        List<Double> gradeB = gradeData.get("B");
        if (gradeB != null) {
            int count = 0;
            for (int i = 0; i < gradeB.size(); i++) {
                System.out.println(gradeB.get(i) + "%");
                count++;
                if (count == 2) {
                    break;
                }
            }
        }
    }
}
