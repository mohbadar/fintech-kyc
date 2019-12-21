
package af.asr.kyc.infrastructure.configuration.data;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import af.asr.kyc.infrastructure.configuration.api.GlobalConfigurationApiConstant;
import af.asr.kyc.infrastructure.core.api.JsonCommand;
import af.asr.kyc.infrastructure.core.data.ApiParameterError;
import af.asr.kyc.infrastructure.core.data.DataValidatorBuilder;
import af.asr.kyc.infrastructure.core.exception.InvalidJsonException;
import af.asr.kyc.infrastructure.core.exception.PlatformApiDataValidationException;
import af.asr.kyc.infrastructure.core.serialization.FromJsonHelper;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@Component
public class GlobalConfigurationDataValidator {

    private final FromJsonHelper fromApiJsonHelper;
	private static final Set<String> UPDATE_CONFIGURATION_DATA_PARAMETERS = new HashSet<>(
			Arrays.asList(GlobalConfigurationApiConstant.localeParamName,
					GlobalConfigurationApiConstant.dateFormatParamName, GlobalConfigurationApiConstant.ENABLED,
					GlobalConfigurationApiConstant.VALUE, GlobalConfigurationApiConstant.DATE_VALUE));

    @Autowired
    public GlobalConfigurationDataValidator(final FromJsonHelper fromApiJsonHelper) {
        this.fromApiJsonHelper = fromApiJsonHelper;
    }

    public void validateForUpdate(final JsonCommand command) {
        final String json = command.json();
        if (StringUtils.isBlank(json)) { throw new InvalidJsonException(); }

        final Type typeOfMap = new TypeToken<Map<String, Object>>() {}.getType();
        this.fromApiJsonHelper.checkForUnsupportedParameters(typeOfMap, json, UPDATE_CONFIGURATION_DATA_PARAMETERS);

        final List<ApiParameterError> dataValidationErrors = new ArrayList<>();
		final DataValidatorBuilder baseDataValidator = new DataValidatorBuilder(dataValidationErrors)
				.resource(GlobalConfigurationApiConstant.CONFIGURATION_RESOURCE_NAME);
        final JsonElement element = this.fromApiJsonHelper.parse(json);

		if (this.fromApiJsonHelper.parameterExists(GlobalConfigurationApiConstant.ENABLED, element)) {
			final boolean enabledBool = this.fromApiJsonHelper
					.extractBooleanNamed(GlobalConfigurationApiConstant.ENABLED, element);
			baseDataValidator.reset().parameter(GlobalConfigurationApiConstant.ENABLED).value(enabledBool)
					.validateForBooleanValue();
		}

		if (this.fromApiJsonHelper.parameterExists(GlobalConfigurationApiConstant.VALUE, element)) {
			final Long valueStr = this.fromApiJsonHelper.extractLongNamed(GlobalConfigurationApiConstant.VALUE,
					element);
			baseDataValidator.reset().parameter(GlobalConfigurationApiConstant.ENABLED).value(valueStr)
					.zeroOrPositiveAmount();
		}
        
		if (this.fromApiJsonHelper.parameterExists(GlobalConfigurationApiConstant.DATE_VALUE, element)) {
			final LocalDate dateValue = this.fromApiJsonHelper
					.extractLocalDateNamed(GlobalConfigurationApiConstant.DATE_VALUE, element);
			baseDataValidator.reset().parameter(GlobalConfigurationApiConstant.DATE_VALUE).value(dateValue).notNull();
		}

        if (!dataValidationErrors.isEmpty()) { throw new PlatformApiDataValidationException(dataValidationErrors); }

    }
}
