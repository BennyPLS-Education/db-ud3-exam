package cat.paucasesnovescifp.spaad.jpa.entitats;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LLI_AUT", schema = "biblioteca", catalog = "")
@IdClass(LliAutPK.class)
public class LliAut {
    private int fkIdllib;
    private int fkIdaut;
    private String fkRolaut;
    private Llibre llibre;
    private Autor autor;
    private RolAutor rolAutor;

    @Id
    @Column(name = "FK_IDLLIB", nullable = false, insertable = false, updatable = false)
    public int getFkIdllib() {
        return fkIdllib;
    }

    public void setFkIdllib(int fkIdllib) {
        this.fkIdllib = fkIdllib;
    }

    @Id
    @Column(name = "FK_IDAUT", nullable = false, insertable = false, updatable = false)
    public int getFkIdaut() {
        return fkIdaut;
    }

    public void setFkIdaut(int fkIdaut) {
        this.fkIdaut = fkIdaut;
    }

    @Basic
    @Column(name = "FK_ROLAUT", nullable = true, length = 50)
    public String getFkRolaut() {
        return fkRolaut;
    }

    public void setFkRolaut(String fkRolaut) {
        this.fkRolaut = fkRolaut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LliAut lliAut = (LliAut) o;
        return fkIdllib == lliAut.fkIdllib &&
                fkIdaut == lliAut.fkIdaut &&
                Objects.equals(fkRolaut, lliAut.fkRolaut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkIdllib, fkIdaut, fkRolaut);
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
    @JoinColumn(name = "FK_IDAUT", referencedColumnName = "ID_AUT", nullable = false)
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @ManyToOne
    @JoinColumn(name = "FK_ROLAUT", referencedColumnName = "ROL", insertable = false, updatable = false)
    public RolAutor getRolAutor() {
        return rolAutor;
    }

    public void setRolAutor(RolAutor rolAutor) {
        this.rolAutor = rolAutor;
    }

    public LliAut(Llibre llibre, Autor autor, RolAutor rolAutor) {
        this.llibre = llibre;
        this.autor = autor;
        this.rolAutor = rolAutor;
    }
}
