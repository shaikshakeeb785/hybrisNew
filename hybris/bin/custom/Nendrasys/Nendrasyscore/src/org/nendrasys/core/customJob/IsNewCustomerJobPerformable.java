package org.nendrasys.core.customJob;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobHistoryModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.CronJobService;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.nendrasys.core.customDao.IsNewCustomerDao;
import org.nendrasys.core.model.IsNewCustomerCronjobModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.util.CollectionUtils;


/**
 * A Cron Job  have to check for users who got registered in last 10 days then the register user last 10 days set attribute
 * isNewCustomer is true and save into the database by using ModelService
 */
public class IsNewCustomerJobPerformable extends AbstractJobPerformable<IsNewCustomerCronjobModel> {
    public static final Logger logger = LogManager.getLogger(IsNewCustomerJobPerformable.class);

    private final String MSG_INFO_JOB_ABORTED = "JOB IS ABORTED";
    private IsNewCustomerDao isNewCustomerDao;
    @Autowired
    private CronJobService cronJobService;
    Date date = null;

    @Override
    public boolean isAbortable() {
        return true;
    }

    @Override
    public PerformResult perform(final IsNewCustomerCronjobModel isNewCustomerCronjobModel) {

        logger.info("Inside IsNewCustomerJobPerformable perform method");
        BasicConfigurator.configure();
        final int noOfDays = isNewCustomerCronjobModel.getXDaysOld();
        if (noOfDays != 0) {
            if (isNewCustomerCronjobModel.getCronJobHistoryEntries().size() <= 1) {
                final Calendar cal = Calendar.getInstance();
                cal.add(Calendar.DAY_OF_MONTH, -noOfDays);
                date = cal.getTime();

                logger.info(" isNewCustomerCronjobModel end time" + isNewCustomerCronjobModel.getEndTime());
            } else {
                final CronJobHistoryModel cronJobHistoryModel;
                cronJobHistoryModel = isNewCustomerCronjobModel.getCronJobHistoryEntries().get(isNewCustomerCronjobModel.getCronJobHistoryEntries().size() - 2);
                date = cronJobHistoryModel.getEndTime();
                logger.info(" isNewCustomerCronjobModel end time" + isNewCustomerCronjobModel.getEndTime());
            }
            final List<CustomerModel> getAllNewCustomersList = getIsNewCustomerDao().findAllCustomerCreationTimeLessThenSpecifieDays(date);
            if (!CollectionUtils.isEmpty(getAllNewCustomersList) || getAllNewCustomersList != null) {
                isNewCustomerList(getAllNewCustomersList);
            }
        }
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);


    }

    protected void isNewCustomerList(final List<CustomerModel> getAllNewCustomersList) {
        final List<CustomerModel> isNewCustomerList = new ArrayList<>();

        for (final CustomerModel customerModel : getAllNewCustomersList) {
            customerModel.setIsNewCustomer(true);
            isNewCustomerList.add(customerModel);
        }

        if (!CollectionUtils.isEmpty(isNewCustomerList)) {
            try {
                modelService.saveAll(isNewCustomerList);
            } catch (final ModelSavingException e) {
                logger.error("DATA NOT SAVED");
                throw new ModelSavingException("SOME THING WENT WRONG DATA NOT SAVED");

            }
        }
    }

    public IsNewCustomerDao getIsNewCustomerDao() {
        return isNewCustomerDao;
    }

    @Required
    public void setIsNewCustomerDao(final IsNewCustomerDao isNewCustomerDao) {
        this.isNewCustomerDao = isNewCustomerDao;
    }


}

