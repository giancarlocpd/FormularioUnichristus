package br.com.formchristus.modelo;

import br.com.formchristus.enumerated.TipoPessoa;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "usuario", schema = "cadastro_basico")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Usuario implements Serializable {

    @Id
    @NotBlank
    @Column(name = "usu_login", nullable = false)
    private String login;
    @NotBlank
    @Column(name = "usu_senha", nullable = false)
    private String senha;
    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "usu_tipo", nullable = false)
    private TipoPessoa tipoPessoa;
    @Column(name = "usu_periodo", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date periodo;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.login);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        return true;
    }
    
    

}
