package uzdevums1;

import javax.swing.*;
import java.io.File;
import java.time.Year;
import java.util.regex.Pattern;

public class MinkuTante {

    static String virknesParbaude(String zinojums, String noklusejums){
        String virkne;
        do {
            virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
            if (virkne == null)
                return null;
            virkne = virkne.trim();
        } while (!Pattern.matches("^[\\p{L} ]+$", virkne));
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
                            "Noraditais skaitlis ir nederiga intervala (" + min + "-" + max + ")",
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
        String izvelne;
        String filaNosaukums = System.getProperty("user.home")
                + File.separator
                + "Desktop"
                + File.separator
                + "minkas.txt";
        Minka runcis = null;

        String[] darbibuSaraksts = {
                "Izveidot kaki",
                "Izsaukt metodi",
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
                    darbibuSaraksts,
                    darbibuSaraksts[0]);

            if (izvelne == null) {
                izvelne = "Aizvert";
            }

            switch (izvelne) {
                case "Izveidot kaki":
                    String minkasVards, skirne, spalvasKrasa, saimnieks, cels;
                    int dzGads = 0;
                    boolean siksnina;

                    minkasVards = virknesParbaude("Ievadi kaka vardu!", "Rudis");
                    if (minkasVards == null) break;

                    skirne = virknesParbaude("Ievadi kaka skirnu!", "Meinkuns");
                    if (skirne == null) break;

                    spalvasKrasa = virknesParbaude("Ievadi kaka kazoka krasu!", "Ruds");
                    if (spalvasKrasa == null) break;

                    dzGads = skaitlaParbaude("Ievadi kaka dzimsanas gadu!",
                            (Year.now().getValue() - 18), Year.now().getValue());
                    if (dzGads == -1) break;

                    saimnieks = virknesParbaude("Ievadi kaka saimnieka vardu", "Antons");
                    if (saimnieks == null) break;

                    int poga = JOptionPane.showConfirmDialog(null,
                            "Vai kakim ir siksnina?",
                            "Kaka siksninas informacija",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (poga == -1) break;

                    siksnina = (poga == JOptionPane.YES_OPTION);

                    cels = virknesParbaude("Ievadi bildes nosaukumu (bez .jpg)", "rudis");
                    if (cels == null) break;

                    runcis = new Minka(minkasVards, skirne, spalvasKrasa,
                            saimnieks, dzGads, siksnina, cels);

                    JOptionPane.showMessageDialog(null,
                            "Kaķis " + minkasVards + " veiksmīgi izveidots!",
                            "Veiksme",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "Izsaukt metodi":
                    if (runcis != null) {
                        String[] metodes = {"Paglaudit", "Nolasit atributus",
                                "Pabarot", "Nolikt gulet", "Palielinat vecumu",
                                "Apskatit vecumu", "Medit"};
                        String m = (String) JOptionPane.showInputDialog(null,
                                "Izvelies metodi",
                                "Metodes izvele",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                metodes,
                                metodes[0]);

                        if (m == null) {
                            break;
                        }

                        // IZLABOTS: Pievienotas visas metodes
                        switch (m) {
                            case "Paglaudit":
                                runcis.murrat();
                                break;
                            case "Nolasit atributus":
                                JOptionPane.showMessageDialog(null,
                                        runcis.nolasitAtributus(),
                                        "Atributi",
                                        JOptionPane.INFORMATION_MESSAGE);
                                break;
                            case "Pabarot":
                                String ediens = JOptionPane.showInputDialog("Ko dot kaķim ēst?", "zivis");
                                if (ediens != null) {
                                    String rezultats = runcis.pabarot(ediens);
                                    JOptionPane.showMessageDialog(null,
                                            "Ēdiens: " + rezultats,
                                            "Pabarots",
                                            JOptionPane.INFORMATION_MESSAGE);
                                }
                                break;
                            case "Nolikt gulet":
                                String prieksmets = JOptionPane.showInputDialog("Ko likt gulēšanai?", "sedzina");
                                if (prieksmets != null) {
                                    runcis.gulet(prieksmets);
                                }
                                break;
                            case "Palielinat vecumu":
                                runcis.palielinatVecumu();
                                break;
                            case "Apskatit vecumu":
                                runcis.nolasitVecumu();
                                break;
                            case "Medit":
                                runcis.medit();
                                break;
                        }
                    } else {
                        // IZLABOTS: showMessageDialog, nevis showConfirmDialog
                        JOptionPane.showMessageDialog(null,
                                "Vispirms izveidojiet kaķi!",
                                "Kļūda",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case "Saglabat faila":
                    JOptionPane.showMessageDialog(null,
                            "Saglabāšana failā vēl nav implementēta\nCeļš: " + filaNosaukums,
                            "Informācija",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "Apskatit saglabatos kakus":
                    JOptionPane.showMessageDialog(null,
                            "Saglabāto kaķu apskate vēl nav implementēta",
                            "Informācija",
                            JOptionPane.INFORMATION_MESSAGE);
                    break;

                case "Aizvert":
                    JOptionPane.showMessageDialog(null, "Uz redzēšanos!");
                    break;
                    
            }
        } while (!izvelne.equals("Aizvert"));
    }
}