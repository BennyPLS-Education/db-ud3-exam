package cat.paucasesnovescifp.spaad.jpa.entitats;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "UBICACIONS", schema = "biblioteca", catalog = "")
public class Ubicacio {
    private String ubicacio;
    private Collection<Exemplar> exemplars;

    @Id
    @Column(name = "UBICACIO", nullable = false, length = 100)
    public String getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ubicacio ubicacio1 = (Ubicacio) o;
        return Objects.equals(ubicacio, ubicacio1.ubicacio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ubicacio);
    }

    @OneToMany(mappedBy = "ubicacio")
    public Collection<Exemplar> getExemplars() {
        return exemplars;
    }

    public void setExemplars(Collection<Exemplar> exemplars) {
        this.exemplars = exemplars;
    }

    @Override
    public String toString() {
        return "Ubicacio{" +
                "ubicacio='" + ubicacio + '\'' +
                '}';
    }
}
