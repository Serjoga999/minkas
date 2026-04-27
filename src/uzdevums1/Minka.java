package uzdevums1;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.time.Year;
import java.util.Random;

public class Minka {
    //Atributi
    String vards, skirne, spalvasKrasa, saimnieks;
    int vecums, medijumuSk, izsalkums;
    boolean siksnina;
    ImageIcon bilde;
    Random random = new Random();

    // Konstruktors
    public Minka(String vards,String skirne, String spalvasKrasa,
                 String saimnieks, int dzGads, boolean siksnina, String cels) {
        this.vards = vards;
        this.skirne = skirne;
        this.spalvasKrasa = spalvasKrasa;
        this.saimnieks = saimnieks;
        vecums = Year.now().getValue() - dzGads;
        medijumuSk = 0;
        izsalkums = kungis();
        this.siksnina = siksnina;
        bilde = iestatitBildi(cels);
    }

    //Metodes
    public int kungis() {
        return random.nextInt(5)+1;
    }

    public ImageIcon iestatitBildi(String cels) {
        if(!cels.endsWith(".jpg"))
            cels += ".jpg";

        URL resurss = getClass().getResource("/atteli/"+cels);
        if(resurss != null) {
            return new ImageIcon(new ImageIcon(resurss).
                    getImage().
                    getScaledInstance(100, 100, Image.SCALE_SMOOTH));

        }else {
                JOptionPane.showMessageDialog(null,
                        "Nevar atrast bildi: " +cels,
                        "Bridinajums", JOptionPane.WARNING_MESSAGE);
                return null;
            }


    }

    void murrat() {
        JOptionPane.showMessageDialog(null,
                vards + "saka 'murr murr murrr! '",
                "Pazinojums", JOptionPane.PLAIN_MESSAGE,
                bilde);
    }

    String nolasitAtributus() {
        return vards + " ir " + vecums + "gadu vecs "
                + " skirnaes kakis ar " + spalvasKrasa +
                " karsas kazoks. " + "\nKakim " +
                ((siksnina) ? "ir" : "nav") + " siksnina. " +
                "\nKaka saimnieks ir " + saimnieks+
                "\nMedijumu skaits: " + medijumuSk;
    }

    String pabarot(String ediens) {
        if(izsalkums > 0) {
            bilde = iestatitBildi("trauks");
            JOptionPane.showMessageDialog(null,
                    "Namm nammm, man garso"+
                    ediens, "Informacija", JOptionPane.INFORMATION_MESSAGE,
                     bilde);
            ediens = "Tuksa bloda";
            izsalkums--;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Esmu paredies un " +
                    " nevelos!", "Bridinajums",
                    JOptionPane.WARNING_MESSAGE);
            izsalkums = kungis();
        }
        return ediens;
    }

    //Metozu parslogosana
    void gulet() {
        JOptionPane.showMessageDialog(null,
                saimnieks + "! Aizvirsi iedot man sedzinu, nevaresu pagulet!",
                "Kluda", JOptionPane.ERROR_MESSAGE);
    }

    void gulet(String prieksmets) {
        if(prieksmets.equalsIgnoreCase("sedzina")) {
            bilde = iestatitBildi("gul");
            JOptionPane.showMessageDialog(null,
                   "zzzz...",
                    "Informacija",
                    JOptionPane.INFORMATION_MESSAGE, bilde);
        } else {
            JOptionPane.showMessageDialog(null,
                    saimnieks +
                    "! " + prieksmets +
                    " man neder gulesanai!", "Kluda",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    void palielinatVecumu() {
        if(vecums < 20) {
            vecums++;
            bilde = iestatitBildi("kuka");
            JOptionPane.showMessageDialog(null,
                    vards + " vecums palielinas par vienu gadu",
                    "Infomacija",
                    JOptionPane.INFORMATION_MESSAGE, bilde);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Sasniegts maksimalais vecums!",
                    "Bridinajums",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    void nolasitVecumu() {
        JOptionPane.showMessageDialog(
                null,
                vards + " ir " + vecums +
                " gadus vecs",
                "Informacija",
                JOptionPane.INFORMATION_MESSAGE);
    }

    void medit() {
        if((random.nextInt(3))==0) {
            medijumuSk++;
            bilde = iestatitBildi("nokira");
            JOptionPane.showMessageDialog(null,
                    "Medijums tika notverts!",
                    "Veiksme",
                    JOptionPane.INFORMATION_MESSAGE,
                    bilde);
        } else {
            bilde = iestatitBildi("aizlaidas");
            JOptionPane.showMessageDialog(null,
                    "Medijums ailaidas!",
                    "Neveiksme",
                    JOptionPane.INFORMATION_MESSAGE,
                    bilde);
        }
    }


}
