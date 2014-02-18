package br.com.formchristus.modelo;

import br.com.formchristus.enumerated.GrupoAtividade;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tipo_atv_complementar", schema = "cadastro_basico")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TipoAtividadeComplementar implements Serializable {

    @Id
    @Column(name = "tp_atv_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Column(name = "tp_atv_nome", nullable = false)
    private String nome;
    @Enumerated
    @NotBlank
    @Column(name = "tp_atv_grupo", nullable = false)
    private GrupoAtividade grupo;

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GrupoAtividade getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoAtividade grupo) {
        this.grupo = grupo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final TipoAtividadeComplementar other = (TipoAtividadeComplementar) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
