
package af.asr.kyc.infrastructure.configuration.service;

import af.asr.kyc.infrastructure.configuration.data.ExternalServicesPropertiesData;
import af.asr.kyc.infrastructure.configuration.data.S3CredentialsData;
import af.asr.kyc.infrastructure.configuration.data.SMTPCredentialsData;

import java.util.Collection;


public interface ExternalServicesPropertiesReadPlatformService {

    S3CredentialsData getS3Credentials();

    SMTPCredentialsData getSMTPCredentials();

//    MessageGatewayConfigurationData getSMSGateway();

    Collection<ExternalServicesPropertiesData> retrieveOne(String serviceName);
    
//    NotificationConfigurationData getNotificationConfiguration();

}