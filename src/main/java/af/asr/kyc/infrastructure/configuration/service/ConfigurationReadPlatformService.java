
package af.asr.kyc.infrastructure.configuration.service;

import org.apache.fineract.infrastructure.configuration.data.GlobalConfigurationData;
import org.apache.fineract.infrastructure.configuration.data.GlobalConfigurationPropertyData;

public interface ConfigurationReadPlatformService {

    GlobalConfigurationPropertyData retrieveGlobalConfiguration(Long configId);
    
    GlobalConfigurationPropertyData retrieveGlobalConfiguration(String name);

    GlobalConfigurationData retrieveGlobalConfiguration(boolean survey);

}