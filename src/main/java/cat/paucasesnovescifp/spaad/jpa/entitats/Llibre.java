package cat.paucasesnovescifp.spaad.jpa.entitats;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "LLIBRES", schema = "biblioteca", catalog = "")
public class Llibre {
    private int idLlib;
    private String titol;
    private String numedicio;
    private String llocedicio;
    private Short anyEdicio;
    private String descripLlib;
    private String isbn;
    private String depLegal;
    private String signtop;
    private Timestamp dataBaixaLlib;
    private String motiubaixa;
    private Collection<Exemplar> exemplars;
    private Colleccio colleccio;
    private Departament departament;
    private Editor editor;
    private Llengua llengua;
    private Collection<LliAut> lliAuts;
    private Set<Tema> temes;

    @Id
    @Column(name = "ID_LLIB", nullable = false)
    public int getIdLlib() {
        return idLlib;
    }

    public void setIdLlib(int idLlib) {
        this.idLlib = idLlib;
    }

    @Basic
    @Column(name = "TITOL", nullable = true, length = 200)
    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    @Basic
    @Column(name = "NUMEDICIO", nullable = true, length = 20)
    public String getNumedicio() {
        return numedicio;
    }

    public void setNumedicio(String numedicio) {
        this.numedicio = numedicio;
    }

    @Basic
    @Column(name = "LLOCEDICIO", nullable = true, length = 50)
    public String getLlocedicio() {
        return llocedicio;
    }

    public void setLlocedicio(String llocedicio) {
        this.llocedicio = llocedicio;
    }

    @Basic
    @Column(name = "ANYEDICIO", nullable = true)
    public Short getAnyEdicio() {
        return anyEdicio;
    }

    public void setAnyEdicio(Short anyEdicio) {
        this.anyEdicio = anyEdicio;
    }

    @Basic
    @Column(name = "DESCRIP_LLIB", nullable = true, length = 200)
    public String getDescripLlib() {
        return descripLlib;
    }

    public void setDescripLlib(String descripLlib) {
        this.descripLlib = descripLlib;
    }

    @Basic
    @Column(name = "ISBN", nullable = true, length = 25)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "DEPLEGAL", nullable = true, length = 25)
    public String getDepLegal() {
        return depLegal;
    }

    public void setDepLegal(String depLegal) {
        this.depLegal = depLegal;
    }

    @Basic
    @Column(name = "SIGNTOP", nullable = true, length = 25)
    public String getSigntop() {
        return signtop;
    }

    public void setSigntop(String signtop) {
        this.signtop = signtop;
    }

    @Basic
    @Column(name = "DATBAIXA_LLIB", nullable = true)
    public Timestamp getDataBaixaLlib() {
        return dataBaixaLlib;
    }

    public void setDataBaixaLlib(Timestamp dataBaixaLlib) {
        this.dataBaixaLlib = dataBaixaLlib;
    }

    @Basic
    @Column(name = "MOTIUBAIXA", nullable = true, length = 200)
    public String getMotiubaixa() {
        return motiubaixa;
    }

    public void setMotiubaixa(String motiubaixa) {
        this.motiubaixa = motiubaixa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Llibre llibre = (Llibre) o;
        return idLlib == llibre.idLlib &&
                Objects.equals(titol, llibre.titol) &&
                Objects.equals(numedicio, llibre.numedicio) &&
                Objects.equals(llocedicio, llibre.llocedicio) &&
                Objects.equals(anyEdicio, llibre.anyEdicio) &&
                Objects.equals(descripLlib, llibre.descripLlib) &&
                Objects.equals(isbn, llibre.isbn) &&
                Objects.equals(depLegal, llibre.depLegal) &&
                Objects.equals(signtop, llibre.signtop) &&
                Objects.equals(dataBaixaLlib, llibre.dataBaixaLlib) &&
                Objects.equals(motiubaixa, llibre.motiubaixa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLlib, titol, numedicio, llocedicio, anyEdicio, descripLlib, isbn, depLegal, signtop, dataBaixaLlib, motiubaixa);
    }

    @OneToMany(mappedBy = "llibre")
    public Collection<Exemplar> getExemplars() {
        return exemplars;
    }

    public void setExemplars(Collection<Exemplar> exemplars) {
        this.exemplars = exemplars;
    }

    @ManyToOne
    @JoinColumn(name = "FK_COLLECCIO", referencedColumnName = "COLLECCIO")
    public Colleccio getColleccio() {
        return colleccio;
    }

    public void setColleccio(Colleccio colleccio) {
        this.colleccio = colleccio;
    }

    @ManyToOne
    @JoinColumn(name = "FK_DEPARTAMENT", referencedColumnName = "DEPARTAMENT")
    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    @ManyToOne
    @JoinColumn(name = "FK_IDEDIT", referencedColumnName = "ID_EDIT")
    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    @ManyToOne
    @JoinColumn(name = "FK_LLENGUA", referencedColumnName = "LLENGUA")
    public Llengua getLlengua() {
        return llengua;
    }

    public void setLlengua(Llengua llengua) {
        this.llengua = llengua;
    }

    @OneToMany(mappedBy = "llibre")
    public Collection<LliAut> getLliAuts() {
        return lliAuts;
    }

    public void setLliAuts(Collection<LliAut> lliAuts) {
        this.lliAuts = lliAuts;
    }

    @ManyToMany
    @JoinTable(name = "LLI_TEMA", catalog = "", schema = "biblioteca", joinColumns = @JoinColumn(name = "FK_IDLLIB", referencedColumnName = "ID_LLIB", nullable = false), inverseJoinColumns = @JoinColumn(name = "FK_TEMA", referencedColumnName = "TEMA", nullable = false))
    public Set<Tema> getTemes() {
        return temes;
    }

    public void setTemes(Set<Tema> temes) {
        this.temes = temes;
    }

    @Override
    public String toString() {
        return "Llibre{" +
                "idLlib=" + idLlib +
                ", titol='" + titol + '\'' +
                ", numedicio='" + numedicio + '\'' +
                ", llocedicio='" + llocedicio + '\'' +
                ", anyEdicio=" + anyEdicio +
                ", descripLlib='" + descripLlib + '\'' +
                ", isbn='" + isbn + '\'' +
                ", depLegal='" + depLegal + '\'' +
                ", signtop='" + signtop + '\'' +
                ", dataBaixaLlib=" + dataBaixaLlib +
                ", motiubaixa='" + motiubaixa + '\'' +
                ", colleccio=" + colleccio +
                ", departament=" + departament +
                ", editor=" + editor +
                ", llengua=" + llengua +
                '}';
    }
}
