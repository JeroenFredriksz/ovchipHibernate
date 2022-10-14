package domein;

import javax.persistence.*;

@Entity(name = "adres")
public class Adres {
    @OneToOne
    @JoinColumn(name = "reiziger_id")
    private Reiziger reiziger;
    @Id
    private int adres_id;
    private String postcode;
    private String huisnummer;
    private String straat;
    private String woonplaats;


    public Adres(Reiziger reiziger, int adres_id, String postcode, String huisnummer, String straat, String woonplaats) {
        this.reiziger = reiziger;
        this.adres_id = adres_id;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.straat = straat;
        this.woonplaats = woonplaats;

        reiziger.setAdres(this);
    }

    public Adres() {

    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    public int getAdres_id() {
        return adres_id;
    }

    public void setAdres_id(int adresId) {
        this.adres_id = adresId;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String toString() {
        return String.format("adresid: %s, %s %s %S %s", adres_id, postcode, straat, huisnummer, woonplaats);
    }
}
