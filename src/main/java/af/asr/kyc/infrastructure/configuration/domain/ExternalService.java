
package af.asr.kyc.infrastructure.configuration.domain;
import af.asr.kyc.infrastructure.core.api.JsonCommand;
import af.asr.kyc.infrastructure.core.domain.AbstractPersistableCustom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "c_external_service", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }, name = "name_UNIQUE") })
public class ExternalService extends AbstractPersistableCustom<Long> {

    @Column(name = "name", length = 50)
    private String name;

    // @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy =
    // "externalServicePropertiesPK.externalService", orphanRemoval = true)
    // private Set<ExternalServicesProperties> values;

    public static ExternalService fromJson(final JsonCommand command) {
        final String name = command.stringValueOfParameterNamed("name");
        return new ExternalService(name);
    }

    private ExternalService(final String name) {
        this.name = name;
    }

    protected ExternalService() {}

    public String name() {
        return this.name;
    }

}