package af.asr.kyc.infrastructure.core.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class JDBCDriverConfig {

    private final static String DRIVER_CLASS_PROPERTYNAME = "DRIVERCLASS_NAME" ;
    private final static String PROTOCOL_PROPERTYNAME = "PROTOCOL" ;
    private final static String SUBPROTOCOL_PROPERTYNAME = "SUB_PROTOCOL" ;
    private final static String PORT_PROPERTYNAME = "PORT" ;

    private String driverClassName ;
    private String protocol ;
    private String subProtocol ;
    private Integer port ;

    @Autowired
    ApplicationContext context ;

    @PostConstruct
    protected void init() {
        Environment environment = context.getEnvironment() ;
        driverClassName = (String)environment.getProperty(DRIVER_CLASS_PROPERTYNAME) ;
        protocol = (String) environment.getProperty(PROTOCOL_PROPERTYNAME) ;
        subProtocol = (String) environment.getProperty(SUBPROTOCOL_PROPERTYNAME) ;
        port = Integer.parseInt((String) environment.getProperty(PORT_PROPERTYNAME)) ;
    }

    public String getDriverClassName() {
        return this.driverClassName ;
    }

    public String getProtocol() {
        return this.protocol ;
    }

    public String getSubProtocol() {
        return this.subProtocol ;
    }

    public Integer getPort() {
        return this.port ;
    }

    public String constructProtocol(String schemaServer, String schemaServerPort, String schemaName) {
        final String url = new StringBuilder(protocol).append(":").append(subProtocol).append("://").append(schemaServer).append(':').append(schemaServerPort)
                .append('/').append(schemaName).toString();
        return url;
    }

}
