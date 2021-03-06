
package af.asr.kyc.infrastructure.core.exception;

import lombok.Getter;

/**
 * A {@link RuntimeException} thrown when unexpected server side errors happen.
 */
@Getter
public class PlatformInternalServerException extends RuntimeException {

    private final String globalisationMessageCode;
    private final String defaultUserMessage;
    private final Object[] defaultUserMessageArgs;

    public PlatformInternalServerException(final String globalisationMessageCode, final String defaultUserMessage,
            final Object... defaultUserMessageArgs) {
        this.globalisationMessageCode = globalisationMessageCode;
        this.defaultUserMessage = defaultUserMessage;
        this.defaultUserMessageArgs = defaultUserMessageArgs;
    }

}