
package af.asr.kyc.infrastructure.core.exceptionmapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import af.asr.kyc.infrastructure.core.data.ApiGlobalErrorResponse;
import af.asr.kyc.infrastructure.core.exception.PlatformInternalServerException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * An {@link ExceptionMapper} to map {@link PlatformInternalServerException}
 * thrown by platform into a HTTP API friendly format.
 * 
 * The {@link PlatformInternalServerException} is thrown when an api call
 * results in unexpected server side exceptions.
 */
@Provider
@Component
@Scope("singleton")
public class PlatformInternalServerExceptionMapper implements ExceptionMapper<PlatformInternalServerException> {

    @Override
    public Response toResponse(final PlatformInternalServerException exception) {

        final ApiGlobalErrorResponse notFoundErrorResponse = ApiGlobalErrorResponse.serverSideError(exception.getGlobalisationMessageCode(),
                exception.getDefaultUserMessage(), exception.getDefaultUserMessageArgs());
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(notFoundErrorResponse).type(MediaType.APPLICATION_JSON).build();
    }
}