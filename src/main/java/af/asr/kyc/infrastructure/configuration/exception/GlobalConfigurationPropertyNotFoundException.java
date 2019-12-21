
package af.asr.kyc.infrastructure.configuration.exception;


import af.asr.kyc.infrastructure.core.exception.AbstractPlatformResourceNotFoundException;

/**
 * A {@link RuntimeException} thrown when global configuration properties are
 * not found.
 */
public class GlobalConfigurationPropertyNotFoundException extends AbstractPlatformResourceNotFoundException {

    public GlobalConfigurationPropertyNotFoundException(final String propertyName) {
        super("error.msg.configuration.property.invalid", "Configuration property `" + propertyName + "` does not exist", propertyName);
    }

    public GlobalConfigurationPropertyNotFoundException(final Long configId) {
        super("error.msg.configuration.id.invalid", "Configuration identifier `" + configId + "` does not exist", configId);
    }
}