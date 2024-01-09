package cat.paucasesnovescifp.spaad.jpa.entitats;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class LliAutPK implements Serializable {
    private int fkIdllib;
    private int fkIdaut;

    @Column(name = "FK_IDLLIB", nullable = false, insertable = false, updatable = false)
    @Id
    public int getFkIdllib() {
        return fkIdllib;
    }

    public void setFkIdllib(int fkIdllib) {
        this.fkIdllib = fkIdllib;
    }

    @Column(name = "FK_IDAUT", nullable = false, insertable = false, updatable = false)
    @Id
    public int getFkIdaut() {
        return fkIdaut;
    }

    public void setFkIdaut(int fkIdaut) {
        this.fkIdaut = fkIdaut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LliAutPK lliAutPK = (LliAutPK) o;
        return fkIdllib == lliAutPK.fkIdllib &&
                fkIdaut == lliAutPK.fkIdaut;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkIdllib, fkIdaut);
    }
}
