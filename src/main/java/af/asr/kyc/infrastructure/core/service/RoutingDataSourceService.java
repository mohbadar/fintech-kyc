
package af.asr.kyc.infrastructure.core.service;

import javax.sql.DataSource;

/**
 * A service for getting hold of the appropriate {@link DataSource} connection
 * pool.
 */
public interface RoutingDataSourceService {

    DataSource retrieveDataSource();
}