
package af.asr.kyc.infrastructure.core.exceptionmapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import af.asr.kyc.infrastructure.core.data.ApiGlobalErrorResponse;
import af.asr.kyc.infrastructure.core.exception.PlatformApiDataValidationException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * An {@link ExceptionMapper} to map {@link PlatformApiDataValidationException}
 * thrown by platform into a HTTP API friendly format.
 * 
 * The {@link PlatformApiDataValidationException} is typically thrown in data
 * validation of the parameters passed in with an api request.
 */
@Provider
@Component
@Scope("singleton")
public class PlatformApiDataValidationExceptionMapper implements ExceptionMapper<PlatformApiDataValidationException> {

    @Override
    public Response toResponse(final PlatformApiDataValidationException exception) {

        final ApiGlobalErrorResponse dataValidationErrorResponse = ApiGlobalErrorResponse.badClientRequest(
                exception.getGlobalisationMessageCode(), exception.getDefaultUserMessage(), exception.getErrors());

        return Response.status(Status.BAD_REQUEST).entity(dataValidationErrorResponse).type(MediaType.APPLICATION_JSON).build();
    }
}