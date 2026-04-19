package uzdevums1;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DarbsArFailu {

    static void saglabat(Minka runcis, String failNosaukums) {
        if (runcis == null) {
            JOptionPane.showMessageDialog(null,
                    "Nav izveidots neviens kaķis!",
                    "Brīdinājums",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            FileWriter fw = new FileWriter(failNosaukums, true); // true - pievienot faila beigās
            PrintWriter pw = new PrintWriter(fw);

            pw.println(runcis.nolasitAtributus());
            pw.println("++++++++++++++++++++++++");
            pw.println();

            pw.close();


            JOptionPane.showMessageDialog(null,
                    "Ieraksts ievietots failā: " + failNosaukums,
                    "Paziņojums",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {

            JOptionPane.showMessageDialog(null,
                    "Kļūda ierakstot failā:\n" + e.getMessage(),
                    "Kļūda",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Noderīgi debugošanai
        }
    }

    static void nolasit(String failaNosaukums) {

        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.FileReader(failaNosaukums));

            StringBuilder saturs = new StringBuilder();
            String rinda;

            while ((rinda = reader.readLine()) != null) {
                saturs.append(rinda).append("\n");
            }

            reader.close();

            if (saturs.length() > 0) {
                JOptionPane.showMessageDialog(null,
                        saturs.toString(),
                        "Saglabātie kaķi",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Failā nav neviena kaķa!",
                        "Informācija",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (java.io.FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Fails nav atrasts: " + failaNosaukums,
                    "Kļūda",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Kļūda nolasot failu:\n" + e.getMessage(),
                    "Kļūda",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}