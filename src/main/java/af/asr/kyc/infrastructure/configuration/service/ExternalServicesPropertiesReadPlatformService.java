
package af.asr.kyc.infrastructure.configuration.service;

import java.util.Collection;

import org.apache.fineract.infrastructure.campaigns.sms.data.MessageGatewayConfigurationData;
import org.apache.fineract.infrastructure.configuration.data.ExternalServicesPropertiesData;
import org.apache.fineract.infrastructure.configuration.data.S3CredentialsData;
import org.apache.fineract.infrastructure.configuration.data.SMTPCredentialsData;
import org.apache.fineract.infrastructure.gcm.domain.NotificationConfigurationData;

public interface ExternalServicesPropertiesReadPlatformService {

    S3CredentialsData getS3Credentials();

    SMTPCredentialsData getSMTPCredentials();

    MessageGatewayConfigurationData getSMSGateway();

    Collection<ExternalServicesPropertiesData> retrieveOne(String serviceName);
    
    NotificationConfigurationData getNotificationConfiguration();

}