package Controller;

import Model.PracticeLog;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PracticeLogger {
    public static void log(ArrayList<PracticeLog> logs) {
        if (logs == null) {
            System.out.println("Saving Failed: No logs to save");
            return;
        } try {
            FileOutputStream fos = new FileOutputStream("src/main/resources/saves/logs.txt");
            PrintWriter pw = new PrintWriter(fos);

            for (PracticeLog log : logs) {
                pw.print(log.getDate() + "-" + log.getTime() + "-");
                pw.println();
                pw.flush();
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
            System.exit(-1);
        }
    }

    public static ArrayList<PracticeLog> getLogs() {
        ArrayList<PracticeLog> logs = new ArrayList<>();
        File file = new File("src/main/resources/saves/logs.txt");

        try {
            FileInputStream fis = new FileInputStream(file);
            Scanner scnr = new Scanner(fis);
            scnr.useDelimiter("-");

            while(scnr.hasNextLine()) {
                int year = scnr.nextInt();
                int day = scnr.nextInt();
                int month = scnr.nextInt();

                int hrs = scnr.nextInt();
                int mins = scnr.nextInt();
                int secs = scnr.nextInt();

                scnr.nextLine();

                PracticeLog newLog = new PracticeLog(LocalDate.of(year, day, month), hrs, mins, secs);
                logs.add(newLog);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return logs;
    }
}
