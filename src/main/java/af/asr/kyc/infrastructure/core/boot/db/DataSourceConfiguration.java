
package af.asr.kyc.infrastructure.core.boot.db;

import javax.sql.DataSource;

import af.asr.kyc.infrastructure.core.boot.JDBCDriverConfig;
import org.apache.tomcat.jdbc.pool.PoolConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for a DataSource.
 * @see DataSourceProperties about how to configure this DS
 */
@Configuration
public class DataSourceConfiguration {
	private static final Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);
	
	@Autowired
    JDBCDriverConfig config ;
	
    @Bean
    public DataSourceProperties dataSourceProperties() {
	return new DataSourceProperties(config.getDriverClassName(), config.getProtocol(), config.getSubProtocol(), config.getPort());
    }

    @Bean
    public DataSource tenantDataSourceJndi() {
	PoolConfiguration p = getProperties();
        org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource(p);
        logger.info("Created new DataSource; url=" + p.getUrl());
        return ds;
    }

    protected DataSourceProperties getProperties() {
        return dataSourceProperties();
    }
}