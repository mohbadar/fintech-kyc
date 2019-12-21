
package af.asr.kyc.infrastructure.core.exception;

import lombok.Getter;

/**
 * A {@link RuntimeException} thrown when data integrity problems happen due to
 * state modifying actions.
 */
@Getter
public class PlatformDataIntegrityException extends RuntimeException {

    private final String globalisationMessageCode;
    private final String defaultUserMessage;
    private final String parameterName;
    private final Object[] defaultUserMessageArgs;

    public PlatformDataIntegrityException(final String globalisationMessageCode, final String defaultUserMessage,
            final Object... defaultUserMessageArgs) {
        this.globalisationMessageCode = globalisationMessageCode;
        this.defaultUserMessage = defaultUserMessage;
        this.parameterName = null;
        this.defaultUserMessageArgs = defaultUserMessageArgs;
    }

    public PlatformDataIntegrityException(final String globalisationMessageCode, final String defaultUserMessage,
            final String parameterName, final Object... defaultUserMessageArgs) {
        this.globalisationMessageCode = globalisationMessageCode;
        this.defaultUserMessage = defaultUserMessage;
        this.parameterName = parameterName;
        this.defaultUserMessageArgs = defaultUserMessageArgs;
    }

}