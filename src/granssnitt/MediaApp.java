package granssnitt;

import register.Medier;

import java.io.IOException;

public class MediaApp {
    public static void main(String[] args) {
        Medlemmar medlemsRegister = new Medlemmar();

        MedlemsMeny meny = new MedlemsMeny();

        meny.setMedlemsRegister(medlemsRegister);// kopplar medlemsregistret till menyn

        // Nedanstående block läser in en medlemsdata från en fil.
        try {
            medlemsRegister.readFromFile(Properties.FILNAMN);
        } catch (IOException ex) {
            System.out.println("Det uppstod problem vid läsning av filen.");
        }

        int menyVal = 0;
        while (menyVal != 4) {
            menyVal = meny.visaMeny();
            switch (menyVal) {
                case 1:
                    meny.visaMedlemmar();
                    break;

                case 2:
                    meny.laggTillMedlem();
                    break;

                case 3:
                    meny.taBortMedlem();
                    break;
                case 4:
                    meny.avsluta();
                    break;
                default:
                    System.out.println("Ogiltigt val. Försök igen.");

            }

        }

    }
}
