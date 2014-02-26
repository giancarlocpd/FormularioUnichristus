package br.com.formchristus.modelo;

import br.com.formchristus.modelo.Aluno;
import br.com.formchristus.modelo.AtividadeComplementar;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "inscricao", schema = "cadastro_basico")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Inscricao implements Serializable {

    @Id
    @Column(name = "ins_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinColumn(name = "alu_matricula", referencedColumnName = "alu_matricula", nullable = false)
    private Aluno aluno;

    @OneToOne
    @JoinColumn(name = "atv_id", referencedColumnName = "atv_id", nullable = false)
    private AtividadeComplementar atividade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

 

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AtividadeComplementar getAtividade() {
        return atividade;
    }

    public void setAtividade(AtividadeComplementar atividade) {
        this.atividade = atividade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Inscricao other = (Inscricao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

  

}
