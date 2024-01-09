package cat.paucasesnovescifp.spaad.jpa.entitats;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "LLENGUES", schema = "biblioteca", catalog = "")
public class Llengua {
    private String llengua;
    private Collection<Llibre> llibres;

    @Id
    @Column(name = "LLENGUA", nullable = false, length = 50)
    public String getLlengua() {
        return llengua;
    }

    public void setLlengua(String llengua) {
        this.llengua = llengua;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Llengua llengua1 = (Llengua) o;
        return Objects.equals(llengua, llengua1.llengua);
    }

    @Override
    public int hashCode() {
        return Objects.hash(llengua);
    }

    @OneToMany(mappedBy = "llengua")
    public Collection<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Collection<Llibre> llibres) {
        this.llibres = llibres;
    }

    @Override
    public String toString() {
        return "Llengua{" +
                "llengua='" + llengua + '\'' +
                '}';
    }
}
