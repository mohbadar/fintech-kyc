//
//package af.asr.kyc.infrastructure.configuration.handler;
//
//import af.asr.kyc.infrastructure.configuration.service.ExternalServiceWritePlatformService;
//import af.asr.kyc.infrastructure.core.api.JsonCommand;
//import af.asr.kyc.infrastructure.core.data.CommandProcessingResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@CommandType(entity = "EXTERNALSERVICES", action = "UPDATE")
//public class UpdateExternalServiceConfigurationCommandHandler implements NewCommandSourceHandler {
//
//    private final ExternalServiceWritePlatformService writePlatformService;
//
//    @Autowired
//    public UpdateExternalServiceConfigurationCommandHandler(final ExternalServiceWritePlatformService writePlatformService) {
//        this.writePlatformService = writePlatformService;
//    }
//
//    @Transactional
//    @Override
//    public CommandProcessingResult processCommand(final JsonCommand command) {
//        return this.writePlatformService.updateExternalServicesProperties(command.getTransactionId(), command);
//    }
//
//}
