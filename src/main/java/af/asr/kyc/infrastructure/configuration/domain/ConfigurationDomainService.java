
package af.asr.kyc.infrastructure.configuration.domain;

import java.util.Date;


public interface ConfigurationDomainService {

    boolean isMakerCheckerEnabledForTask(String taskPermissionCode);

    boolean isAmazonS3Enabled();

    boolean isRescheduleFutureRepaymentsEnabled();

    boolean isRescheduleRepaymentsOnHolidaysEnabled();

    boolean allowTransactionsOnHolidayEnabled();

    boolean allowTransactionsOnNonWorkingDayEnabled();

    boolean isConstraintApproachEnabledForDatatables();

    boolean isEhcacheEnabled();

//    void updateCache(CacheType cacheType);

    Long retrievePenaltyWaitPeriod();

    boolean isPasswordForcedResetEnable();

    Long retrievePasswordLiveTime();

    Long retrieveGraceOnPenaltyPostingPeriod();

    Long retrieveOpeningBalancesContraAccount();

    boolean isSavingsInterestPostingAtCurrentPeriodEnd();

    Integer retrieveFinancialYearBeginningMonth();

    public Integer retrieveMinAllowedClientsInGroup();

    public Integer retrieveMaxAllowedClientsInGroup();

    boolean isMeetingMandatoryForJLGLoans();

    int getRoundingMode();

    boolean isBackdatePenaltiesEnabled();
    
    boolean isOrganisationstartDateEnabled();
    
    Date retrieveOrganisationStartDate();
    
    boolean isPaymnetypeApplicableforDisbursementCharge();

    boolean isInterestChargedFromDateSameAsDisbursementDate();

    boolean isSkippingMeetingOnFirstDayOfMonthEnabled();
    
    Long retreivePeroidInNumberOfDaysForSkipMeetingDate();
    
    boolean isChangeEmiIfRepaymentDateSameAsDisbursementDateEnabled();
    
    boolean isDailyTPTLimitEnabled();
    
    Long getDailyTPTLimit();

    void removeGlobalConfigurationPropertyDataFromCache(String propertyName);

    boolean isSMSOTPDeliveryEnabled();

    boolean isEmailOTPDeliveryEnabled();

    Integer retrieveOTPCharacterLength();

    Integer retrieveOTPLiveTime();
}