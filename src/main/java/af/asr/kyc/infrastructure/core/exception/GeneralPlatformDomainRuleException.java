
package af.asr.kyc.infrastructure.core.exception;

/**
 * A {@link RuntimeException} thrown when valid api request end up violating
 * some domain rule.
 */
public final class GeneralPlatformDomainRuleException extends AbstractPlatformDomainRuleException {

    public GeneralPlatformDomainRuleException(final String globalisationMessageCode, final String defaultUserMessage,
            final Object... defaultUserMessageArgs) {
        super(globalisationMessageCode, defaultUserMessage, defaultUserMessageArgs);
    }
}