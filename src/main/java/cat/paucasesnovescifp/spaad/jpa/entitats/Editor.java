package cat.paucasesnovescifp.spaad.jpa.entitats;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "EDITORS", schema = "biblioteca")
@NamedQuery(name="editors.all", query = "SELECT e FROM Editor e ORDER BY e.nomEdit")
public class Editor {
    private int idEdit;
    private String nomEdit;
    private String adrEdit;
    private String cpEdit;
    private String pobEdit;
    private String telEdit;
    private String faxEdit;
    private String emailEdit;
    private Collection<Llibre> llibres;

    @Id
    @Column(name = "ID_EDIT", nullable = false)
    public int getIdEdit() {
        return idEdit;
    }

    public void setIdEdit(int idEdit) {
        this.idEdit = idEdit;
    }

    @Basic
    @Column(name = "NOM_EDIT", nullable = true, length = 100)
    public String getNomEdit() {
        return nomEdit;
    }

    public void setNomEdit(String nomEdit) {
        this.nomEdit = nomEdit;
    }

    @Basic
    @Column(name = "ADR_EDIT", nullable = true, length = 200)
    public String getAdrEdit() {
        return adrEdit;
    }

    public void setAdrEdit(String adrEdit) {
        this.adrEdit = adrEdit;
    }

    @Basic
    @Column(name = "CP_EDIT", nullable = true, length = 10)
    public String getCpEdit() {
        return cpEdit;
    }

    public void setCpEdit(String cpEdit) {
        this.cpEdit = cpEdit;
    }

    @Basic
    @Column(name = "POB_EDIT", nullable = true, length = 50)
    public String getPobEdit() {
        return pobEdit;
    }

    public void setPobEdit(String pobEdit) {
        this.pobEdit = pobEdit;
    }

    @Basic
    @Column(name = "TEL_EDIT", nullable = true, length = 50)
    public String getTelEdit() {
        return telEdit;
    }

    public void setTelEdit(String telEdit) {
        this.telEdit = telEdit;
    }

    @Basic
    @Column(name = "FAX_EDIT", nullable = true, length = 50)
    public String getFaxEdit() {
        return faxEdit;
    }

    public void setFaxEdit(String faxEdit) {
        this.faxEdit = faxEdit;
    }

    @Basic
    @Column(name = "EMAIL_EDIT", nullable = true, length = 100)
    public String getEmailEdit() {
        return emailEdit;
    }

    public void setEmailEdit(String emailEdit) {
        this.emailEdit = emailEdit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editor editor = (Editor) o;
        return idEdit == editor.idEdit &&
                Objects.equals(nomEdit, editor.nomEdit) &&
                Objects.equals(adrEdit, editor.adrEdit) &&
                Objects.equals(cpEdit, editor.cpEdit) &&
                Objects.equals(pobEdit, editor.pobEdit) &&
                Objects.equals(telEdit, editor.telEdit) &&
                Objects.equals(faxEdit, editor.faxEdit) &&
                Objects.equals(emailEdit, editor.emailEdit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEdit, nomEdit, adrEdit, cpEdit, pobEdit, telEdit, faxEdit, emailEdit);
    }

    @OneToMany(mappedBy = "editor")
    public Collection<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Collection<Llibre> llibres) {
        this.llibres = llibres;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "idEdit=" + idEdit +
                ", nomEdit='" + nomEdit + '\'' +
                ", adrEdit='" + adrEdit + '\'' +
                ", cpEdit='" + cpEdit + '\'' +
                ", pobEdit='" + pobEdit + '\'' +
                ", telEdit='" + telEdit + '\'' +
                ", faxEdit='" + faxEdit + '\'' +
                ", emailEdit='" + emailEdit + '\'' +
                '}';
    }
}
