
package af.asr.kyc.infrastructure.configuration.data;
import java.util.Date;

/**
 * Immutable data object for global configuration property.
 */
public class GlobalConfigurationPropertyData {

    @SuppressWarnings("unused")
    private final String name;
    @SuppressWarnings("unused")
    private final boolean enabled;
    @SuppressWarnings("unused")
    private final Long value;
    @SuppressWarnings("unused")
    private final Date dateValue;
    @SuppressWarnings("unused")
    private final Long id;
    @SuppressWarnings("unused")
    private final String description;
    @SuppressWarnings("unused")
    private final boolean trapDoor;

    public GlobalConfigurationPropertyData(final String name, final boolean enabled, final Long value, final Date dateValue, final String description, 
            final boolean trapDoor) {
        this.name = name;
        this.enabled = enabled;
        this.value = value;
        this.dateValue = dateValue;
        this.id = null;
        this.description = description;
        this.trapDoor = trapDoor;
    }

    public GlobalConfigurationPropertyData(final String name, final boolean enabled, final Long value, Date dateValue, final Long id,
            final String description, final boolean isTrapDoor) {
        this.name = name;
        this.enabled = enabled;
        this.value = value;
        this.dateValue = dateValue;
        this.id = id;
        this.description = description;
        this.trapDoor = isTrapDoor;
    }

	public String getName() {
		return this.name;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public Long getValue() {
		return this.value;
	}

	public Date getDateValue() {
		return this.dateValue;
	}

	public Long getId() {
		return this.id;
	}

	public String getDescription() {
		return this.description;
	}

	public boolean isTrapDoor() {
		return this.trapDoor;
	}
    
    
}