package danim.sample.domain;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Customer.
 */
@Entity
@Table(name = "customer")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    /**
     * Customer code
     */
    @ApiModelProperty(value = "Customer code")
    @Column(name = "c_licod")
    private String cLICOD;

    /**
     * Customer name
     */
    @ApiModelProperty(value = "Customer name")
    @Column(name = "c_linom")
    private String cLINOM;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getcLICOD() {
        return cLICOD;
    }

    public Customer cLICOD(String cLICOD) {
        this.cLICOD = cLICOD;
        return this;
    }

    public void setcLICOD(String cLICOD) {
        this.cLICOD = cLICOD;
    }

    public String getcLINOM() {
        return cLINOM;
    }

    public Customer cLINOM(String cLINOM) {
        this.cLINOM = cLINOM;
        return this;
    }

    public void setcLINOM(String cLINOM) {
        this.cLINOM = cLINOM;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        if (customer.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), customer.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Customer{" +
            "id=" + getId() +
            ", cLICOD='" + getcLICOD() + "'" +
            ", cLINOM='" + getcLINOM() + "'" +
            "}";
    }
}
