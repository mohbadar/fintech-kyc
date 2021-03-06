
package af.asr.kyc.infrastructure.configuration.exception;


import af.asr.kyc.infrastructure.core.exception.AbstractPlatformResourceNotFoundException;

public class ExternalServiceConfigurationNotFoundException extends AbstractPlatformResourceNotFoundException {

    public ExternalServiceConfigurationNotFoundException(final String serviceName) {
        super("error.msg.externalservice.servicename.invalid", "Service Name`" + serviceName + "` does not exist", serviceName);
    }

    public ExternalServiceConfigurationNotFoundException(final String externalServiceName, final String name) {
        super("error.msg.externalservice.property.invalid",
                "Parameter`" + name + "` does not exist for the ServiceName `" + externalServiceName + "`", name, externalServiceName);
    }
}
