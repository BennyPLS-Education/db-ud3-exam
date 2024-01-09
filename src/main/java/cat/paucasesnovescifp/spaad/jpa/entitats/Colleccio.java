package cat.paucasesnovescifp.spaad.jpa.entitats;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "COLLECCIONS", schema = "biblioteca", catalog = "")
public class Colleccio {
    private String colleccio;
    private Collection<Llibre> llibres;

    @Id
    @Column(name = "COLLECCIO", nullable = false, length = 100)
    public String getColleccio() {
        return colleccio;
    }

    public void setColleccio(String colleccio) {
        this.colleccio = colleccio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colleccio colleccio1 = (Colleccio) o;
        return Objects.equals(colleccio, colleccio1.colleccio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colleccio);
    }

    @OneToMany(mappedBy = "colleccio")
    public Collection<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Collection<Llibre> llibres) {
        this.llibres = llibres;
    }

    @Override
    public String toString() {
        return "Colleccio{" +
                "colleccio='" + colleccio + '\'' +
                '}';
    }
}
