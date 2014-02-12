package br.com.formchristus.modelo;

import br.com.formchristus.enumerated.TipoPessoa;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "usuario",schema = "cadastro_basico")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Usuario implements Serializable{
        
        @Id
        @Column(name = "usu_login",nullable = false)
	private String login;
	@Column(name = "usu_senha",nullable = false) 
	private String senha;
	@Enumerated(EnumType.STRING)
        @Column(name = "usu_tipo",nullable = false)
	private TipoPessoa tipoPessoa;
	 
	private Date periodo;
	 
}
 
