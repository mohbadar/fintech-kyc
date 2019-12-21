
package af.asr.kyc.infrastructure.configuration.serialization;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import af.asr.kyc.infrastructure.configuration.command.UpdateGlobalConfigurationCommand;
import af.asr.kyc.infrastructure.core.exception.InvalidJsonException;
import af.asr.kyc.infrastructure.core.serialization.AbstractFromApiJsonDeserializer;
import af.asr.kyc.infrastructure.core.serialization.FromJsonHelper;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;

/**
 * Implementation of {@link } for
 * {@link UpdateGlobalConfigurationCommand}'s.
 */
@Component
public final class GlobalConfigurationCommandFromApiJsonDeserializer extends
        AbstractFromApiJsonDeserializer<UpdateGlobalConfigurationCommand> {

    /**
     * The parameters supported for this command.
     */
    private final Set<String> supportedParameters = new HashSet<>(Arrays.asList("globalConfiguration"));
    private final FromJsonHelper fromApiJsonHelper;

    @Autowired
    public GlobalConfigurationCommandFromApiJsonDeserializer(final FromJsonHelper fromApiJsonHelper) {
        this.fromApiJsonHelper = fromApiJsonHelper;
    }

    @Override
    public UpdateGlobalConfigurationCommand commandFromApiJson(final String json) {

        if (StringUtils.isBlank(json)) { throw new InvalidJsonException(); }

        final Type typeOfMap = new TypeToken<Map<String, Object>>() {}.getType();
        this.fromApiJsonHelper.checkForUnsupportedParameters(typeOfMap, json, this.supportedParameters);

        return this.fromApiJsonHelper.fromJson(json, UpdateGlobalConfigurationCommand.class);
    }
}