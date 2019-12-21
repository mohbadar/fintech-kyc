
package af.asr.kyc.infrastructure.core.domain;

import lombok.Getter;

@Getter
public class Base64EncodedImage {

    private final String base64EncodedString;
    private final String fileExtension;

    public Base64EncodedImage(final String base64EncodedString, final String fileExtension) {
        this.base64EncodedString = base64EncodedString;
        this.fileExtension = fileExtension;
    }
}