package br.com.formchristus.modelo;

import br.com.formchristus.enumerated.Sexo;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Embeddable
public class Pessoa {
        
	@NotBlank
        @Column(name = "pes_nome", nullable = false)
	private String nome;
        @Email
	@NotBlank
        @Column(name = "pes_email", nullable = false) 
	private String email;
        @Enumerated(EnumType.STRING)
	@NotBlank
        @Column(name = "pes_sexo", nullable = false) 
	private Sexo sexo;
        @Column(name = "pes_ativo",nullable = false)
        private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
        
        
	 
}
 
