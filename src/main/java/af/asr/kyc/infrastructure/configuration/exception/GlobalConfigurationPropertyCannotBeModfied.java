
package af.asr.kyc.infrastructure.configuration.exception;


import af.asr.kyc.infrastructure.core.exception.AbstractPlatformDomainRuleException;

public class GlobalConfigurationPropertyCannotBeModfied extends AbstractPlatformDomainRuleException {
    
    public GlobalConfigurationPropertyCannotBeModfied(final Long configId) {
        super("error.msg.configuration.id.not.modifiable", "Configuration identifier `" + configId + "` cannot be modified", new Object[] {configId});
    }

}
