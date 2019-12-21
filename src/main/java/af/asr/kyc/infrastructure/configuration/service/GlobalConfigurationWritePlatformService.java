
package af.asr.kyc.infrastructure.configuration.service;


import af.asr.kyc.infrastructure.core.api.JsonCommand;
import af.asr.kyc.infrastructure.core.data.CommandProcessingResult;

public interface GlobalConfigurationWritePlatformService {

    CommandProcessingResult update(Long configId, JsonCommand command);
    void addSurveyConfig(String name);
}