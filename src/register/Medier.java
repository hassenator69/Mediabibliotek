package register;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Medier {
    //(Medlemmar)

    private final List<Medlem> medlemmar;

    public Medlemmar() {
        medlemmar = new ArrayList<>();
    }

    public void addMedlem(Medlem medlem) {
        medlemmar.add(medlem);
    }

    /**
     *
     * @param index
     */
    public void removeMedlem(int index) {
        medlemmar.remove(index);

    }

    /**
     *
     * @param index
     * @return
     */
    public Medlem getMedlem(int index) {
        return medlemmar.get(index);
    }

    /**
     *
     * @return
     */
    public List<Medlem> getArrayList() {
        return medlemmar;
    }

    /**
     *
     * @param fileName
     * @throws IOException
     */
    public void readFromFile(String fileName) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String filRad;

        while ((filRad = in.readLine()) != null) {
            // Nedanstående delar upp den inlästa raden
            // i delar som skiljs åt av komman
            // Varje del återfinns på en plats
            // i den array som split-metoden
            // returnerar.
            String[] post = filRad.split(",");

            Medlem m = new Medlem();
            m.setMedlemsNummer(Integer.parseInt(post[0]));
            m.setForNamn(post[1]);
            m.setEfterNamn(post[2]);
            m.setEpostAdress(post[3]);
            this.addMedlem(m);
        }
        in.close();

    }

    /**
     *
     * @param fileName
     * @throws IOException
     */
    public void writeToFile(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < medlemmar.size(); i++) {

            Medlem m = medlemmar.get(i);
            String rad = m.getMedlemsNummer() + "," + m.getForNamn() + "," + m.getEfterNamn() + ","
                    + m.getEpostAdress();
            bw.write(rad);
            bw.newLine();
        }
        bw.close();

    }

    /**
     *
     */
    public void skrivUtInfo() {
        System.out.println("Plats\tMedlemsnr\tNamn\t\tEpost");
        for (int i = 0; i < medlemmar.size(); i++) {
            Medlem m = medlemmar.get(i);

            String info = i + "\t" + m.getMedlemsNummer() + "\t" + m.getForNamn()
                    + " " + m.getEfterNamn()
                    + ", " + m.getEpostAdress();

            System.out.println(info);
        }
    }

    //Returnerar nästa tillgängliga medlemsnummer
    public int hittaMedlemsNummer() {
        int nyttMedlemsNummer = 0;
        for (Medlem m : medlemmar){
            if (m.getMedlemsNummer() > nyttMedlemsNummer){
                nyttMedlemsNummer = m.getMedlemsNummer();
            }
        }
        return nyttMedlemsNummer + 1;
    }
    //returnerar storleken på arraylistan
    public int getAntalMedlemmar(){
        return  medlemmar.size();
    }
}
