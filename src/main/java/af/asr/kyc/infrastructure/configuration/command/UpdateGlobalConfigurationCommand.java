package af.asr.kyc.infrastructure.configuration.command;

import lombok.Getter;

import java.util.Map;

/**
 * Immutable command for updating global configuration settings.
 */
@Getter
public class UpdateGlobalConfigurationCommand {

    private final Map<String, Boolean> globalConfiguration;

    public UpdateGlobalConfigurationCommand(final Map<String, Boolean> globalConfigurationMap) {
        this.globalConfiguration = globalConfigurationMap;
    }

}