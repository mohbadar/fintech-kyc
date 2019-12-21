
package af.asr.kyc.infrastructure.configuration.api;

import af.asr.kyc.infrastructure.configuration.data.GlobalConfigurationPropertyData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


final class GlobalConfigurationApiResourceSwagger {
    private GlobalConfigurationApiResourceSwagger() {

    }

    @ApiModel(value = "GetGlobalConfigurationsResponse")
    public static final class GetGlobalConfigurationsResponse {
        private GetGlobalConfigurationsResponse(){}
        public List<GlobalConfigurationPropertyData> globalConfiguration;
    }

    @ApiModel(value = "PutGlobalConfigurationsRequest")
    public static final class PutGlobalConfigurationsRequest {
        private PutGlobalConfigurationsRequest(){}
        @ApiModelProperty(example = "true")
        public boolean enabled;
        @ApiModelProperty(example = "2")
        public Long value;
    }

    @ApiModel(value = "PutGlobalConfigurationsResponse")
    public static final class PutGlobalConfigurationsResponse {
        private PutGlobalConfigurationsResponse(){}
        final class PutGlobalConfigurationsResponsechangesSwagger{
            private PutGlobalConfigurationsResponsechangesSwagger() {}
            @ApiModelProperty(example = "true")
            public boolean enabled;
        }
        @ApiModelProperty(example = "4")
        public Long resourceId;
        public PutGlobalConfigurationsResponsechangesSwagger changes;
    }

}
