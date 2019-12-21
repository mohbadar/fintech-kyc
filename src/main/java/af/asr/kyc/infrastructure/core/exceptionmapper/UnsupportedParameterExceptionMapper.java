
package af.asr.kyc.infrastructure.core.exceptionmapper;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import af.asr.kyc.infrastructure.core.data.ApiGlobalErrorResponse;
import af.asr.kyc.infrastructure.core.data.ApiParameterError;
import af.asr.kyc.infrastructure.core.exception.UnsupportedParameterException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * An {@link ExceptionMapper} to map {@link UnsupportedParameterException}
 * thrown by platform into a HTTP API friendly format.
 */
@Provider
@Component
@Scope("singleton")
public class UnsupportedParameterExceptionMapper implements ExceptionMapper<UnsupportedParameterException> {

    @Override
    public Response toResponse(final UnsupportedParameterException exception) {

        final List<ApiParameterError> errors = new ArrayList<>();

        for (final String parameterName : exception.getUnsupportedParameters()) {
            final StringBuilder validationErrorCode = new StringBuilder("error.msg.parameter.unsupported");
            final StringBuilder defaultEnglishMessage = new StringBuilder("The parameter ").append(parameterName).append(
                    " is not supported.");
            final ApiParameterError error = ApiParameterError.parameterError(validationErrorCode.toString(),
                    defaultEnglishMessage.toString(), parameterName, parameterName);

            errors.add(error);
        }

        final ApiGlobalErrorResponse invalidParameterError = ApiGlobalErrorResponse.badClientRequest(
                "validation.msg.validation.errors.exist", "Validation errors exist.", errors);

        return Response.status(Status.BAD_REQUEST).entity(invalidParameterError).type(MediaType.APPLICATION_JSON).build();
    }
}