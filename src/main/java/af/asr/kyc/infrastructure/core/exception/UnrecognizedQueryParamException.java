
package af.asr.kyc.infrastructure.core.exception;

import lombok.Getter;

@Getter
public class UnrecognizedQueryParamException extends RuntimeException {

    private final String queryParamKey;
    private final String queryParamValue;
    private final Object[] supportedParams;

    public UnrecognizedQueryParamException(final String queryParamKey, final String queryParamValue, final Object... supportedParams) {
        this.queryParamKey = queryParamKey;
        this.queryParamValue = queryParamValue;
        this.supportedParams = supportedParams;
    }

}