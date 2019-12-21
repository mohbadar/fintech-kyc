
package af.asr.kyc.infrastructure.core.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.domain.Persistable;


@MappedSuperclass
public abstract class AbstractPersistableCustom<PK extends Serializable> implements Persistable<Long> {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        /*
         * (non-Javadoc)
         * 
         * @see org.springframework.data.domain.Persistable#getId()
         */
        @Override
        public Long getId() {
                return id;
        }

        /**
         * Sets the id of the entity.
         * 
         * @param id the id to set
         */
        protected void setId(final Long id) {

                this.id = id;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.springframework.data.domain.Persistable#isNew()
         */
        @Override
        public boolean isNew() {

                return null == this.id;
        }

        //We have removed toString(), hashCode() and equals() methods. By adding them end up issues with OpenJPA
}
