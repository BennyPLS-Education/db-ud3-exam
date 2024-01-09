package cat.paucasesnovescifp.spaad.jpa.entitats;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "NACIONALITATS", schema = "biblioteca", catalog = "")
public class Nacionalitat {
    private String nacionalitat;
    private Collection<Autor> autors;

    @Id
    @Column(name = "NACIONALITAT", nullable = false, length = 50)
    public String getNacionalitat() {
        return nacionalitat;
    }

    public void setNacionalitat(String nacionalitat) {
        this.nacionalitat = nacionalitat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nacionalitat that = (Nacionalitat) o;
        return Objects.equals(nacionalitat, that.nacionalitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nacionalitat);
    }

    @OneToMany(mappedBy = "nacionalitat")
    public Collection<Autor> getAutors() {
        return autors;
    }

    public void setAutors(Collection<Autor> autors) {
        this.autors = autors;
    }

    @Override
    public String toString() {
        return "Nacionalitat{" +
                "nacionalitat='" + nacionalitat + '\'' +
                '}';
    }
}
