
package af.asr.kyc.infrastructure.configuration.serialization;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;

@Component
public class ExternalServicesPropertiesCommandFromApiJsonDeserializer {

    private final Set<String> S3SupportedParameters = S3_JSON_INPUT_PARAMS.getAllValues();
    private final Set<String> SMTPSupportedParameters = SMTP_JSON_INPUT_PARAMS.getAllValues();
    private final Set<String> SMSSupportedParameters = SMS_JSON_INPUT_PARAMS.getAllValues();
    private final Set<String> NotificationSupportedParameters = NOTIFICATION_JSON_INPUT_PARAMS.getAllValues();
    private final FromJsonHelper fromApiJsonHelper;

    @Autowired
    public ExternalServicesPropertiesCommandFromApiJsonDeserializer(final FromJsonHelper fromApiJsonHelper) {
        this.fromApiJsonHelper = fromApiJsonHelper;
    }

    public void validateForUpdate(final String json, final String externalServiceName) {
        if (StringUtils.isBlank(json)) { throw new InvalidJsonException(); }

        final Type typeOfMap = new TypeToken<Map<String, Object>>() {}.getType();
        switch (externalServiceName) {
            case "S3":
                this.fromApiJsonHelper.checkForUnsupportedParameters(typeOfMap, json, this.S3SupportedParameters);
            break;

            case "SMTP":
                this.fromApiJsonHelper.checkForUnsupportedParameters(typeOfMap, json, this.SMTPSupportedParameters);
            break;

            case "SMS":
                this.fromApiJsonHelper.checkForUnsupportedParameters(typeOfMap, json, this.SMSSupportedParameters);
            break;

            case "NOTIFICATION":
                this.fromApiJsonHelper.checkForUnsupportedParameters(typeOfMap, json, this.NotificationSupportedParameters);
            break;

            default:
                throw new ExternalServiceConfigurationNotFoundException(externalServiceName);
        }

    }

    public Set<String> getNameKeys(final String json) {
        final Type typeOfMap = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, String> jsonMap = this.fromApiJsonHelper.extractDataMap(typeOfMap, json);
        Set<String> keyNames = jsonMap.keySet();
        return keyNames;
    }
}
