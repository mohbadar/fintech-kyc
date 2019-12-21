
package af.asr.kyc.infrastructure.core.domain;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.openjpa.jdbc.sql.BooleanRepresentationFactory;
import org.apache.openjpa.jdbc.sql.MySQLDictionary;

public class MySQLDictionaryCustom extends MySQLDictionary {

        public MySQLDictionaryCustom(){
                super();
            this.supportsSubselect = true;
            this.booleanRepresentation = BooleanRepresentationFactory.BOOLEAN;
            this.supportsGetGeneratedKeys = false ;
            this.allowsAliasInBulkClause = true ;
            this.useWildCardForCount = true ;
        }
        
        @Override
        public void connectedConfiguration(Connection conn) throws SQLException {
                super.connectedConfiguration(conn);
                this.supportsSubselect = true;
                this.supportsGetGeneratedKeys = false ;
                this.allowsAliasInBulkClause = true ;
                this.useWildCardForCount = true ;
        }
}
