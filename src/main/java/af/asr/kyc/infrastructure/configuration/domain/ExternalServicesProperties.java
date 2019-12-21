
package af.asr.kyc.infrastructure.configuration.domain;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import af.asr.kyc.infrastructure.configuration.data.ExternalServicesPropertiesData;
import af.asr.kyc.infrastructure.configuration.service.ExternalServicesConstants;
import af.asr.kyc.infrastructure.core.api.JsonCommand;
import org.apache.commons.lang3.StringUtils;


@Entity
@Table(name = "c_external_service_properties")
public class ExternalServicesProperties {

    @EmbeddedId
    ExternalServicePropertiesPK externalServicePropertiesPK;

    @Column(name = "value", length = 250)
    private String value;

    protected ExternalServicesProperties() {

    }

    private ExternalServicesProperties(final ExternalServicePropertiesPK externalServicePropertiesPK, final String value) {
        this.externalServicePropertiesPK = externalServicePropertiesPK;

        this.value = value;

    }
    public static ExternalServicesProperties fromJson(final ExternalService externalService, final JsonCommand command) {
        final String name = command.stringValueOfParameterNamed(ExternalServicesConstants.EXTERNALSERVICEPROPERTIES_JSON_INPUT_PARAMS.NAME.getValue());
        final String value = command.stringValueOfParameterNamed(ExternalServicesConstants.EXTERNALSERVICEPROPERTIES_JSON_INPUT_PARAMS.VALUE.getValue());
        return new ExternalServicesProperties(new ExternalServicePropertiesPK(externalService.getId(), name), value);
    }

    public Map<String, Object> update(final JsonCommand command, String paramName) {
        final Map<String, Object> actualChanges = new LinkedHashMap<>(2);

        final String valueParamName = ExternalServicesConstants.EXTERNALSERVICEPROPERTIES_JSON_INPUT_PARAMS.VALUE.getValue();
        if (command.isChangeInStringParameterNamed(paramName, this.value)) {
            final String newValue = command.stringValueOfParameterNamed(paramName);
            if (paramName.equals(ExternalServicesConstants.SMTP_JSON_INPUT_PARAMS.PASSWORD.getValue()) && newValue.equals("XXXX")) {
                // If Param Name is Password and ParamValue is XXXX that means
                // the password has not been changed.
            } else {
                actualChanges.put(valueParamName, newValue);
            }
            this.value = StringUtils.defaultIfEmpty(newValue, null);
        }

        return actualChanges;
    }

    public ExternalServicesPropertiesData toData() {
        return new ExternalServicesPropertiesData(this.externalServicePropertiesPK.getName(), this.value);
    }
}
