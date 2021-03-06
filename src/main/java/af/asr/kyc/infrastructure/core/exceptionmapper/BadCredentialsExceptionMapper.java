
package af.asr.kyc.infrastructure.core.exceptionmapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import af.asr.kyc.infrastructure.core.data.ApiGlobalErrorResponse;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

/**
 * An {@link ExceptionMapper} to map {@link BadCredentialsException} thrown by
 * platform during authentication into a HTTP API friendly format.
 * 
 * The {@link BadCredentialsException} is thrown by spring security on platform
 * when an attempt is made to authenticate using invalid username/password
 * credentials.
 */
@Provider
@Component
@Scope("singleton")
public class BadCredentialsExceptionMapper implements ExceptionMapper<BadCredentialsException> {

    @Override
    public Response toResponse(@SuppressWarnings("unused") final BadCredentialsException exception) {
        return Response.status(Status.UNAUTHORIZED).entity(ApiGlobalErrorResponse.unAuthenticated()).type(MediaType.APPLICATION_JSON)
                .build();
    }
}