package cat.paucasesnovescifp.spaad.jpa.entitats;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TEMES", schema = "biblioteca", catalog = "")
public class Tema {
    private String tema;
    private String temapare;
    private Set<Llibre> llibres;

    @Id
    @Column(name = "TEMA", nullable = false, length = 50)
    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Basic
    @Column(name = "TEMAPARE", nullable = true, length = 50)
    public String getTemapare() {
        return temapare;
    }

    public void setTemapare(String temapare) {
        this.temapare = temapare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tema tema1 = (Tema) o;
        return Objects.equals(tema, tema1.tema) &&
                Objects.equals(temapare, tema1.temapare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tema, temapare);
    }

    @ManyToMany(mappedBy = "temes")
    public Set<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    @Override
    public String toString() {
        return "Tema{" +
                "tema='" + tema + '\'' +
                ", temapare='" + temapare + '\'' +
                '}';
    }
}
