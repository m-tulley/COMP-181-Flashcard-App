package Controller;

import Model.TestLog;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TestLogger {
    public static void log(ArrayList<TestLog> tests) {
        if (tests == null) {
            System.out.println("Saving Failed: No tests to save");
            return;
        } try {
            FileOutputStream fos = new FileOutputStream("src/main/resources/saves/tests.txt");
            PrintWriter pw = new PrintWriter(fos);

            for (TestLog log : tests) {
                pw.print(log.getDate() + "-" + log.getDeckName() + "-" + Math.round((log.getPercentageCorrect()/10)*10) + "-");
                pw.println();
                pw.flush();
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
            System.exit(-1);
        }
    }

    public static ArrayList<TestLog> getLogs() {
        ArrayList<TestLog> tests = new ArrayList<>();
        File file = new File("src/main/resources/saves/tests.txt");

        try {
            FileInputStream fis = new FileInputStream(file);
            Scanner scnr = new Scanner(fis);
            scnr.useDelimiter("-");

            while(scnr.hasNextLine()) {
                int year = scnr.nextInt();
                int day = scnr.nextInt();
                int month = scnr.nextInt();

                String deckName = scnr.next();
                double percentCorrect = scnr.nextDouble();

                scnr.nextLine();

                TestLog newLog = new TestLog(deckName, percentCorrect, LocalDate.of(year, day, month));
                tests.add(newLog);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return tests;
    }
}
