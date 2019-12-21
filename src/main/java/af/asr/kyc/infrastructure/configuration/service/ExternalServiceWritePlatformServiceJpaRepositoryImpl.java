//
//package af.asr.kyc.infrastructure.configuration.service;
//
//import java.util.Iterator;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Set;
//
//
//import af.asr.kyc.infrastructure.configuration.data.ExternalServicesData;
//import af.asr.kyc.infrastructure.configuration.domain.ExternalServicesProperties;
//import af.asr.kyc.infrastructure.configuration.domain.ExternalServicesPropertiesRepository;
//import af.asr.kyc.infrastructure.configuration.domain.ExternalServicesPropertiesRepositoryWrapper;
//import af.asr.kyc.infrastructure.configuration.serialization.ExternalServicesPropertiesCommandFromApiJsonDeserializer;
//import af.asr.kyc.infrastructure.core.api.JsonCommand;
//import af.asr.kyc.infrastructure.core.data.CommandProcessingResultBuilder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class ExternalServiceWritePlatformServiceJpaRepositoryImpl implements ExternalServiceWritePlatformService {
//
//    @SuppressWarnings("unused")
//    private final static Logger logger = LoggerFactory.getLogger(ExternalServiceWritePlatformServiceJpaRepositoryImpl.class);
//
//    private final PlatformSecurityContext context;
//    private final ExternalServicesPropertiesRepositoryWrapper repositoryWrapper;
//    private final ExternalServicesPropertiesRepository repository;
//    private final ExternalServicesPropertiesCommandFromApiJsonDeserializer fromApiJsonDeserializer;
//    private final ExternalServicesReadPlatformService readPlatformService;
//
//    @Autowired
//    public ExternalServiceWritePlatformServiceJpaRepositoryImpl(final PlatformSecurityContext context,
//            final ExternalServicesPropertiesRepositoryWrapper repositoryWrapper, final ExternalServicesPropertiesRepository repository,
//            final ExternalServicesPropertiesCommandFromApiJsonDeserializer fromApiJsonDeserializer,
//            final ExternalServicesReadPlatformService readPlatformService) {
//
//        this.context = context;
//        this.repositoryWrapper = repositoryWrapper;
//        this.repository = repository;
//        this.fromApiJsonDeserializer = fromApiJsonDeserializer;
//        this.readPlatformService = readPlatformService;
//    }
//
//    @Transactional
//    @Override
//    public CommandProcessingResult updateExternalServicesProperties(String externalServiceName, JsonCommand command) {
//        // TODO Auto-generated method stub
//        this.context.authenticatedUser();
//        this.fromApiJsonDeserializer.validateForUpdate(command.json(), externalServiceName);
//        Set<String> keyName = this.fromApiJsonDeserializer.getNameKeys(command.json());
//        ExternalServicesData external = this.readPlatformService.getExternalServiceDetailsByServiceName(externalServiceName);
//        Long externalServiceId = external.getId();
//        Iterator<String> it = keyName.iterator();
//        Map<String, Object> changesList = new LinkedHashMap<>();
//        while (it.hasNext()) {
//            String name = it.next();
//            final ExternalServicesProperties externalServicesProperties = this.repositoryWrapper.findOneByIdAndName(externalServiceId, name,
//                    externalServiceName);
//            final Map<String, Object> changes = externalServicesProperties.update(command, name);
//            changesList.putAll(changes);
//            if (!changes.isEmpty()) {
//                this.repository.saveAndFlush(externalServicesProperties);
//            }
//        }
//        return new CommandProcessingResultBuilder() //
//                .withCommandId(command.commandId()).withEntityId(externalServiceId).with(changesList).build();
//        //
//
//    }
//
//}
