
package af.asr.kyc.infrastructure.core.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * Immutable data object representing generic enumeration value.
 * </p>
 */
@Getter
@AllArgsConstructor
public class EnumOptionData {

    private final Long id;
    private final String code;
    private final String value;
    
    
}