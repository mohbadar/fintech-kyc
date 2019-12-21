
package af.asr.kyc.infrastructure.configuration.service;

import af.asr.kyc.infrastructure.core.api.JsonCommand;
import af.asr.kyc.infrastructure.core.data.CommandProcessingResult;

public interface ExternalServiceWritePlatformService {

    CommandProcessingResult updateExternalServicesProperties(String externalServiceName, JsonCommand command);

}
