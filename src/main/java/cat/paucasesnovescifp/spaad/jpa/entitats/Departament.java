package cat.paucasesnovescifp.spaad.jpa.entitats;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "DEPARTAMENTS", schema = "biblioteca", catalog = "")
public class Departament {
    private String departament;
    private Collection<Llibre> llibres;

    @Id
    @Column(name = "DEPARTAMENT", nullable = false, length = 100)
    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departament that = (Departament) o;
        return Objects.equals(departament, that.departament);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departament);
    }

    @OneToMany(mappedBy = "departament")
    public Collection<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Collection<Llibre> llibres) {
        this.llibres = llibres;
    }

    @Override
    public String toString() {
        return "Departament{" +
                "departament='" + departament + '\'' +
                '}';
    }
}
