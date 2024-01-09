package cat.paucasesnovescifp.spaad.jpa.entitats;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "ROLAUTORS", schema = "biblioteca", catalog = "")
public class RolAutor {
    private String rol;
    private Collection<LliAut> lliAuts;

    @Id
    @Column(name = "ROL", nullable = false, length = 50)
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolAutor rolAutor = (RolAutor) o;
        return Objects.equals(rol, rolAutor.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rol);
    }

    @OneToMany(mappedBy = "rolAutor")
    public Collection<LliAut> getLliAuts() {
        return lliAuts;
    }

    public void setLliAuts(Collection<LliAut> lliAuts) {
        this.lliAuts = lliAuts;
    }

    @Override
    public String toString() {
        return "RolAutor{" +
                "rol='" + rol + '\'' +
                '}';
    }
}
