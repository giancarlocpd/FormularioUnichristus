package br.com.formchristus.modelo;

import br.com.formchristus.modelo.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotBlank;
@Entity
@Table(name = "professor", schema = "cadastro_basico")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Professor implements Serializable{
        @Id
        @Column(name = "pro_matricula", nullable = false, unique = true)
	private String matrciula;
        @Embedded
	private Pessoa pessoa;
        @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(fetch = FetchType.EAGER)
        @Fetch(FetchMode.SELECT)
	private List curso;
	 
}
 
