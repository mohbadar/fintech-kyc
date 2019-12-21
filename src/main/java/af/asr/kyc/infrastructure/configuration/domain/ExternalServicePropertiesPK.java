
package af.asr.kyc.infrastructure.configuration.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class ExternalServicePropertiesPK implements Serializable {

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "external_service_id")
    private Long externalServiceId;

    public ExternalServicePropertiesPK() {

    }

    public ExternalServicePropertiesPK(Long externalServiceId, String name) {
        this.externalServiceId = externalServiceId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getExternalService() {
        return externalServiceId;
    }
    
    @Override 
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		final ExternalServicePropertiesPK rhs = (ExternalServicePropertiesPK) obj;
		return new EqualsBuilder() //
				.append(this.externalServiceId, rhs.externalServiceId) //
				.append(this.name, rhs.name) //
				.isEquals();
	}

    @Override 
    public int hashCode() {
        return new HashCodeBuilder(17, 37) //
                .append(this.externalServiceId) //
                .append(this.name) //
                .toHashCode();
    }
}
