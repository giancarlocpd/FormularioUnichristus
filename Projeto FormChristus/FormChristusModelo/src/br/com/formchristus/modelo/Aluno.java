package br.com.formchristus.modelo;

import br.com.formchristus.modelo.Pessoa;
import br.com.formchristus.modelo.Curso;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "aluno", schema = "cadastro_basico")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Aluno implements Serializable{
        @Id
        @Column(name = "alu_matricula", nullable = false)
	private String matrciula;
 
        @Embedded
	private Pessoa pessoa;
	@ManyToOne
        @JoinColumn(name = "cur_id",referencedColumnName = "cur_id",nullable = false)
	private Curso curso;

    public String getMatrciula() {
        return matrciula;
    }

    public void setMatrciula(String matrciula) {
        this.matrciula = matrciula;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.matrciula);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.matrciula, other.matrciula)) {
            return false;
        }
        return true;
    }
	 
        
}
 
