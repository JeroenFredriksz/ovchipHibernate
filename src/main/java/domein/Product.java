package domein;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "product")
public class Product {
    @ManyToMany(mappedBy = "producten")
    private List<Ov_chipkaart> ov_chipkaarten = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_nummer;
    private String naam;
    private String beschrijving;
    private float prijs;

    public Product(int product_nummer, String naam, String beschrijving, float prijs) {
        this.product_nummer = product_nummer;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }

    public Product() {

    }

    public int getProduct_nummer() {
        return product_nummer;
    }

    public void setProduct_nummer(int productNummer) {
        this.product_nummer = productNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public float getPrijs() {
        return prijs;
    }

    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }

    public void addOvChipkaart(Ov_chipkaart ov_chipkaart) {
        ov_chipkaarten.add(ov_chipkaart);
    }

    public void removeOvChipKaart(Ov_chipkaart ov_chipkaart) {
        ov_chipkaarten.remove(ov_chipkaart);
    }

    public List<Ov_chipkaart> getOv_chipkaarten() {
        return ov_chipkaarten;
    }

    public void setOv_chipkaarten(List<Ov_chipkaart> ov_chipkaarten) {
        this.ov_chipkaarten = ov_chipkaarten;
    }

    public String toString() {
        return String.format("productId: %s, naam: %s, beschrijving: %s prijs: %S", product_nummer, naam, beschrijving, prijs);
    }
}
