
package af.asr.kyc.infrastructure.configuration.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

final class ExternalServicesConfigurationApiResourceSwagger {
    private ExternalServicesConfigurationApiResourceSwagger() {

    }

    @ApiModel(value = "PutExternalServiceRequest")
    public static final class PutExternalServiceRequest{
        private PutExternalServiceRequest() {

        }
        @ApiModelProperty(example = "test@mifos.org")
        public String username;
        @ApiModelProperty(example = "XXXX")
        public String password;
    }
}
