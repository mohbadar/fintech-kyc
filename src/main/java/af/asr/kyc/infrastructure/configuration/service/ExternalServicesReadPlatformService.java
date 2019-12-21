
package af.asr.kyc.infrastructure.configuration.service;

import org.apache.fineract.infrastructure.configuration.data.ExternalServicesData;

public interface ExternalServicesReadPlatformService {

    ExternalServicesData getExternalServiceDetailsByServiceName(String serviceName);

}
