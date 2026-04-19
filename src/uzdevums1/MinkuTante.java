package uzdevums1;

import javax.swing.*;
import java.io.File;
import java.time.Year;
import java.util.regex.Pattern;


public class MinkuTante {

    static String virknesParbaude(String zinojums, String noklusejums){
        String virkne;

        do {
            virkne = JOptionPane.showInputDialog(zinojums,noklusejums);
            if (virkne ==null)
                return null;

            virkne = virkne.trim();
        }while (!Pattern.matches("^[\\p{L} ]+$", virkne));

        return virkne;

    }

    static int skaitlaParbaude(String zinojums, int min, int max) {
        String ievade;
        int skaitlis;
        while (true) {
            ievade = JOptionPane.showInputDialog(zinojums, min);
            if (ievade == null) {
                return -1;
            }
                try {
                    skaitlis = Integer.parseInt(ievade);
                    if (skaitlis < min || skaitlis > max) {
                        JOptionPane.showMessageDialog(null,
                                "Noraditais skaitli ir nederiga intervala",
                                "Nekorekti dati",
                                JOptionPane.WARNING_MESSAGE);
                        continue;
                    }
                    return skaitlis;

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Netika ievadits vesels skaitlis",
                            "Nekorekti dati",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

    }

    public static void main(String[] args) {

        String izvelne, filaNosaukums =
                System.getProperty("user.home")
                        + File.separator
                        + "Desktop"
                        + File.separator
                        + "minkas.txt";
        Minka runcis = null;

        String[] darbubuSaraksts = {
                "Izveidot kaki",
                "Izsauk metodi",
                "Saglabat faila",
                "Apskatit saglabatos kakus",
                "Aizvert"};

        do {

            izvelne = (String) JOptionPane.showInputDialog(
                    null,
                    "Izvelies darbibu",
                    "Darbibas izvele",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    darbubuSaraksts,
                    darbubuSaraksts[0]);
            if (izvelne == null) {
                izvelne = "Aizvert";
            }

            switch (izvelne) {
                case "Izveidot kaki":
                    String minkasVards, skirne, spalvasKrasa, saimnieks, cels;
                    int dzGads = 0;
                    boolean siksnina;
                    

                    minkasVards = virknesParbaude("Ievadi kaka vardu!", "Rudis");
                    skirne = virknesParbaude("Ievadi kaka skirnu!", "Meinkuns");
                    spalvasKrasa = virknesParbaude("Ievadi kaka kazoka krasu!", "Ruds");
                    dzGads = skaitlaParbaude("Ievadi kaka dzimsanas gadu!",
                            (Year.now().getValue() - 18), Year.now().getValue());
                    saimnieks = virknesParbaude("Ievadi kaka saimnieka vardu", "Antons");
                    int poga = JOptionPane.showConfirmDialog(null,
                        "vai kakim ir siksnina","Kaka siksninas informacija",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(poga == -1)
                        break;

                    siksnina = (poga == 0)? true : false;
                    cels = virknesParbaude("ievadi bildes nosaukumu",
                            "rud");
                    runcis = new Minka(minkasVards,skirne,spalvasKrasa,
                            saimnieks, dzGads,siksnina,cels);
                    break;
            }

        }while (!izvelne.equals("Aizvert"));

    }
}