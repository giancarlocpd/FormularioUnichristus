package br.com.formchristus.modelo;

import br.com.formchristus.modelo.AtividadeComplementar;
import br.com.formchristus.modelo.Aluno;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "formulario_a4", schema = "formularios")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FormularioA4 implements Serializable {

    @Id
    @Column(name = "for_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinColumn(name = "atv_id", referencedColumnName = "atv_id", nullable = false)
    private AtividadeComplementar atividade;

    @ManyToMany
    @JoinColumn(name = "alu_matricula", referencedColumnName = "alu_matricula")
    private Aluno aluno;

    public Long getID() {
        return id;
    }

    public void setID(Long ID) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtividadeComplementar getAtividade() {
        return atividade;
    }

    public void setAtividade(AtividadeComplementar atividade) {
        this.atividade = atividade;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FormularioA4 other = (FormularioA4) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
