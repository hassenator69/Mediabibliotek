package granssnitt;

import register.Medier;
import register.Media;

import java.io.IOException;
import java.util.Scanner;

public class MediaMeny {
    private Medlemmar medlemsRegister;
    private final Scanner inMatning;

    public MedlemsMeny() {
        inMatning = new Scanner(System.in);
    }

    public int visaMeny() {

        System.out.println("------ Meny ------\n");
        System.out.println("1.\tVisa medlemmar");
        System.out.println("2.\tLägg till medlem");
        System.out.println("3.\tTa bort medlem");
        System.out.println("4.\tAvsluta\n\n");
        System.out.print("Ange siffra som motvarar menyval: ");

        int valStr = inMatning.nextInt();

        return valStr;
    }

    public Medlemmar getMedlemsRegister() {
        return medlemsRegister;
    }

    public void setMedlemsRegister(Medlemmar medlemsRegister) {
        this.medlemsRegister = medlemsRegister;
    }

    public void visaMedlemmar() {
        System.out.println("--- Visa medlemmar ---");
        System.out.println("----------------------");

        medlemsRegister.skrivUtInfo();
    }

    public void laggTillMedlem() {
        System.out.println("--- Lägg till medlem ---");
        System.out.println("------------------------");
        System.out.println("Ange förnamn: ");
        String fornamn = inMatning.next();
        System.out.println("Ange efternamn: ");
        String efternamn = inMatning.next();
        System.out.println("Ange epost");
        String epost = inMatning.next();

        int medlemsnummer = medlemsRegister.hittaMedlemsNummer();

        Medlem nyMedlem = new Medlem();

        nyMedlem.setForNamn(fornamn);
        nyMedlem.setEfterNamn(efternamn);
        nyMedlem.setEpostAdress(epost);
        nyMedlem.setMedlemsNummer(medlemsnummer);

        medlemsRegister.addMedlem(nyMedlem);
    }

    public void taBortMedlem() {
        System.out.println("--- Lägg till medlem ---");
        System.out.println("------------------------");
        System.out.println("Ange platsnummer för den medlem du vill ta bort: ");
        int valdMedlem = inMatning.nextInt();
        int antalMedlemmar = medlemsRegister.getAntalMedlemmar();
        if (valdMedlem < antalMedlemmar){
            Medlem medlemSomSkaRaderas = medlemsRegister.getMedlem(valdMedlem);
            System.out.println("Vill du radera medlemmen " + medlemSomSkaRaderas.getForNamn() + " " +
                    medlemSomSkaRaderas.getEfterNamn() + "? Svara ja/nej");
            String val = inMatning.next().toLowerCase();
            if (val.equals("ja")){
                medlemsRegister.removeMedlem(valdMedlem);
                System.out.println("Medlemmen raderades.");
            } else {
                System.out.println("Ingen radering utfördes.");
            }
        } else {
            System.out.println("Var god ange en existerande medlem");
        }
    }

    public void avsluta() {
        System.out.println("--- Programmet avslutas ---");
        System.out.println("------------------------");
        try {
            medlemsRegister.writeToFile(Properties.FILNAMN);
            System.out.println("Nya medlemmar sparades till filen.");
        } catch (IOException ex) {
            System.out.println("Något gick fel när medlemmarna skulle sparas i filen " + Properties.FILNAMN);
        }

    }

}
