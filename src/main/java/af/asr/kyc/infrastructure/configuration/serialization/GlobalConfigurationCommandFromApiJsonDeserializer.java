
package af.asr.kyc.infrastructure.configuration.serialization;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.fineract.infrastructure.configuration.command.UpdateGlobalConfigurationCommand;
import org.apache.fineract.infrastructure.core.exception.InvalidJsonException;
import org.apache.fineract.infrastructure.core.serialization.AbstractFromApiJsonDeserializer;
import org.apache.fineract.infrastructure.core.serialization.FromApiJsonDeserializer;
import org.apache.fineract.infrastructure.core.serialization.FromJsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;

/**
 * Implementation of {@link FromApiJsonDeserializer} for
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