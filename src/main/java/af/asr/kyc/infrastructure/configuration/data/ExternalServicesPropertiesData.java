package af.asr.kyc.infrastructure.configuration.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class ExternalServicesPropertiesData implements Serializable {

    private String name;
    private String value;
}
