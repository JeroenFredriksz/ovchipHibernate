package domein;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "reiziger")
public class Reiziger {
    @Id
    int reiziger_id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;
    @OneToOne(mappedBy = "reiziger")
    private Adres adres;
    @OneToMany(mappedBy = "reiziger")
    private List<Ov_chipkaart> chipkaarten = new ArrayList<>();

    public Reiziger(int reiziger_id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
        this.reiziger_id = reiziger_id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        chipkaarten = new ArrayList<>();
    }

    public Reiziger() {

    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public void setChipkaarten(List<Ov_chipkaart> chipkaarten) {
        this.chipkaarten = chipkaarten;
    }

    public int getReiziger_id() {
        return reiziger_id;
    }

    public void setReiziger_id(int reizigerId) {
        this.reiziger_id = reizigerId;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String toString() {
        String convertedTussenVoegsel;
        if (tussenvoegsel == null) {
            convertedTussenVoegsel = "";
        }
        else {
            convertedTussenVoegsel = String.format(" %s ", tussenvoegsel);
        }
        String returnstring = String.format("reiziger id: %s, %s %s %s, %s", reiziger_id, voorletters, convertedTussenVoegsel, achternaam, geboortedatum);
        if (adres != null) {
            returnstring += "\n" + adres;
        }
        if (chipkaarten.size() != 0) {
            for (Ov_chipkaart perChipkaart : chipkaarten) {
                returnstring += "\n" + perChipkaart;
            }
        }
        return returnstring;
    }

    public void removeChipKaart (Ov_chipkaart ov_chipkaart) {
        chipkaarten.remove(ov_chipkaart);
    }

    public void addChipkaart (Ov_chipkaart ov_chipkaart) {
        chipkaarten.add(ov_chipkaart);
    }

    public List<Ov_chipkaart> getChipkaarten() {
        return chipkaarten;
    }
}
