package br.com.formchristus.modelo;

import br.com.formchristus.modelo.Pessoa;
import br.com.formchristus.modelo.Curso;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "coordenador",schema = "cadastro_basico")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Coordenador implements Serializable{
        @Id
        @Column(name = "coo_matricula", nullable = false)
	private String matrciula;
        @Embedded
	private Pessoa pessoa;
	@ManyToOne
        @JoinColumn(name = "cur_id", referencedColumnName = "cur_id", nullable = false)
	private Curso curso;
	 
}
 
