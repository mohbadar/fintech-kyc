
package af.asr.kyc.infrastructure.configuration.service;


import af.asr.kyc.infrastructure.configuration.data.ExternalServicesData;

public interface ExternalServicesReadPlatformService {

    ExternalServicesData getExternalServiceDetailsByServiceName(String serviceName);

}
