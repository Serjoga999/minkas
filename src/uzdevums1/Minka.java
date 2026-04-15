package uzdevums1;

import javax.swing.*;
import java.util.Random;

public class Minka {
    //Atributi
    String vards, skirne, spalvasKrasa, saimnieks;
    int vecums, medijumuSk, izsalkums;
    boolean siksnina;
    ImageIcon bildite;
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
        //Trpinasim nakosaja nodarbiba

        return null;
    }

}
