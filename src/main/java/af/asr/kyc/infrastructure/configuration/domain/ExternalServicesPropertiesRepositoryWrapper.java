
package af.asr.kyc.infrastructure.configuration.domain;

import af.asr.kyc.infrastructure.configuration.exception.ExternalServiceConfigurationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExternalServicesPropertiesRepositoryWrapper {

    private final ExternalServicesPropertiesRepository repository;

    @Autowired
    public ExternalServicesPropertiesRepositoryWrapper(final ExternalServicesPropertiesRepository repository) {
        this.repository = repository;
    }

    public ExternalServicesProperties findOneByIdAndName(Long id, String name, String externalServiceName) {
        final ExternalServicesProperties externalServicesProperties = this.repository
                .findOneByExternalServicePropertiesPK(name,id);
        if (externalServicesProperties == null) throw new ExternalServiceConfigurationNotFoundException(externalServiceName, name);
        return externalServicesProperties;
    }
}
