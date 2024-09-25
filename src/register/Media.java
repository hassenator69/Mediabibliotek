package register;

public class Media {
    //(Medlem)
    private int medlemsNummer;
    private String forNamn;
    private String efterNamn;
    private String epostAdress;

    public int getMedlemsNummer() {
        return medlemsNummer;
    }

    public void setMedlemsNummer(int medlemsNummer) {
        this.medlemsNummer = medlemsNummer;
    }

    public String getForNamn() {
        return forNamn;
    }

    public void setForNamn(String forNamn) {
        this.forNamn = forNamn;
    }

    public String getEfterNamn() {
        return efterNamn;
    }

    public void setEfterNamn(String efterNamn) {
        this.efterNamn = efterNamn;
    }

    public String getEpostAdress() {
        return epostAdress;
    }

    public void setEpostAdress(String epostAdress) {
        this.epostAdress = epostAdress;
    }
}
