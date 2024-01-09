package cat.paucasesnovescifp.spaad.jpa.entitats;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "AUTORS", schema = "biblioteca", catalog = "")
public class Autor {
    private int idAut;
    private String nomAut;
    private Timestamp dNaixAut;
    private byte[] imgAut;
    private Nacionalitat nacionalitat;
    private Collection<LliAut> lliAut;

    @Id
    @Column(name = "ID_AUT", nullable = false)
    public int getIdAut() {
        return idAut;
    }

    public void setIdAut(int idAut) {
        this.idAut = idAut;
    }

    @Basic
    @Column(name = "NOM_AUT", nullable = true, length = 100)
    public String getNomAut() {
        return nomAut;
    }

    public void setNomAut(String nomAut) {
        this.nomAut = nomAut;
    }

    @Basic
    @Column(name = "DNAIX_AUT", nullable = true)
    public Timestamp getdNaixAut() {
        return dNaixAut;
    }

    public void setdNaixAut(Timestamp dNaixAut) {
        this.dNaixAut = dNaixAut;
    }

    @Basic
    @Column(name = "IMG_AUT", nullable = true)
    public byte[] getImgAut() {
        return imgAut;
    }

    public void setImgAut(byte[] imgAut) {
        this.imgAut = imgAut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return idAut == autor.idAut &&
                Objects.equals(nomAut, autor.nomAut) &&
                Objects.equals(dNaixAut, autor.dNaixAut) &&
                Arrays.equals(imgAut, autor.imgAut);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idAut, nomAut, dNaixAut);
        result = 31 * result + Arrays.hashCode(imgAut);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "FK_NACIONALITAT", referencedColumnName = "NACIONALITAT")
    public Nacionalitat getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(Nacionalitat nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    @OneToMany(mappedBy = "autor")
    public Collection<LliAut> getLliAut() {
        return lliAut;
    }

    public void setLliAut(Collection<LliAut> lliAut) {
        this.lliAut = lliAut;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idAut=" + idAut +
                ", nomAut='" + nomAut + '\'' +
                ", dNaixAut=" + dNaixAut +
                ", imgAut=" + Arrays.toString(imgAut) +
                ", nacionalitat=" + nacionalitat +
                '}';
    }
}
