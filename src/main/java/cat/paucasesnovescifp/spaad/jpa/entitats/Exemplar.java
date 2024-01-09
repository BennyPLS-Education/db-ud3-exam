package cat.paucasesnovescifp.spaad.jpa.entitats;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "EXEMPLARS", schema = "biblioteca", catalog = "")
public class Exemplar {
    private int numExm;
    private String nreg;
    private Timestamp dataAltaExm;
    private String origenExm;
    private Llibre llibre;
    private Ubicacio ubicacio;

    @Id
    @Column(name = "NUM_EXM", nullable = false)
    public int getNumExm() {
        return numExm;
    }

    public void setNumExm(int numExm) {
        this.numExm = numExm;
    }

    @Basic
    @Column(name = "NREG", nullable = true, length = 6)
    public String getNreg() {
        return nreg;
    }

    public void setNreg(String nreg) {
        this.nreg = nreg;
    }

    @Basic
    @Column(name = "DATALTA_EXM", nullable = true)
    public Timestamp getDataAltaExm() {
        return dataAltaExm;
    }

    public void setDataAltaExm(Timestamp dataAltaExm) {
        this.dataAltaExm = dataAltaExm;
    }

    @Basic
    @Column(name = "ORIGEN_EXM", nullable = true, length = 100)
    public String getOrigenExm() {
        return origenExm;
    }

    public void setOrigenExm(String origenExm) {
        this.origenExm = origenExm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplar exemplars = (Exemplar) o;
        return numExm == exemplars.numExm &&
                Objects.equals(nreg, exemplars.nreg) &&
                Objects.equals(dataAltaExm, exemplars.dataAltaExm) &&
                Objects.equals(origenExm, exemplars.origenExm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numExm, nreg, dataAltaExm, origenExm);
    }

    @ManyToOne
    @JoinColumn(name = "FK_IDLLIB", referencedColumnName = "ID_LLIB", nullable = false)
    public Llibre getLlibre() {
        return llibre;
    }

    public void setLlibre(Llibre llibre) {
        this.llibre = llibre;
    }

    @ManyToOne
    @JoinColumn(name = "FK_UBICEXM", referencedColumnName = "UBICACIO")
    public Ubicacio getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(Ubicacio ubicacio) {
        this.ubicacio = ubicacio;
    }

    @Override
    public String toString() {
        return "Exemplar{" +
                "numExm=" + numExm +
                ", nreg='" + nreg + '\'' +
                ", dataAltaExm=" + dataAltaExm +
                ", origenExm='" + origenExm + '\'' +
                ", llibre=" + llibre +
                ", ubicacio=" + ubicacio +
                '}';
    }
}
