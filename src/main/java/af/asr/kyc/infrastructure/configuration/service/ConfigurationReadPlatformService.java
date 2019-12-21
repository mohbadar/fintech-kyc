
package af.asr.kyc.infrastructure.configuration.service;


import af.asr.kyc.infrastructure.configuration.data.GlobalConfigurationData;
import af.asr.kyc.infrastructure.configuration.data.GlobalConfigurationPropertyData;

public interface ConfigurationReadPlatformService {

    GlobalConfigurationPropertyData retrieveGlobalConfiguration(Long configId);
    
    GlobalConfigurationPropertyData retrieveGlobalConfiguration(String name);

    GlobalConfigurationData retrieveGlobalConfiguration(boolean survey);

}