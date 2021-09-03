package org.nendrasys.core.customService.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.interceptor.impl.InterceptorExecutionPolicy;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.session.SessionExecutionBody;
import de.hybris.platform.servicelayer.session.SessionService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.nendrasys.core.customDao.ManufacturerDetailsDao;
import org.nendrasys.core.customService.ManufacturerDetailsService;
import org.nendrasys.core.model.ManufacturerDetailsModel;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

/**
 * implementation for {@link ManufacturerDetailsService}
 */
public class DefaultManufacturerDetailsService implements ManufacturerDetailsService {
    public static final Logger logger = LogManager.getLogger(DefaultManufacturerDetailsService.class);

    private ManufacturerDetailsDao manufacturerDetailsDao;
    private ModelService modelService;
    private SessionService sessionService;


    @Override
    public ManufacturerDetailsModel getManufacturerDetailsById(final String id) {
        validateParameterNotNull(id, "Parameter id must not be null");
        BasicConfigurator.configure();
        logger.info("Inside ManufacturerDetailService Class");
        return manufacturerDetailsDao.getManufacturerDetailsById(id);
    }

    @Override
    public List<ManufacturerDetailsModel> getManufacturerDetailsData() {
        logger.info("Inside getManufacturerDetailsData Method");
        return manufacturerDetailsDao.getManufacturerDetailsData();
    }

    @Override
    public List<ManufacturerDetailsModel> getManufacturerDetailsPaginetion(final int CurrentPage) {
        logger.info("Inside getManufacturerDetailsPagination Method");
        return manufacturerDetailsDao.getManufacturerDetailsPaginetion(CurrentPage);
    }

    @Override
    public void registerManufacturerDetailSave(final ManufacturerDetailsModel manufacturerDetailsModel) throws ModelSavingException {
        logger.info("Inside registerManufacturerDetailSave Method");
        validateParameterNotNull(manufacturerDetailsModel, "manufacturerDetailsModel must not be null!");
        if (manufacturerDetailsModel != null) {
            final Random random = new Random();
            final int id = random.nextInt();
            final String manuId = "Manu" + id;
            manufacturerDetailsModel.setId(manuId);
            final Map<String, Object> params = ImmutableMap.of(InterceptorExecutionPolicy.DISABLED_INTERCEPTOR_TYPES,
                    ImmutableSet.of(InterceptorExecutionPolicy.InterceptorType.VALIDATE));
            getSessionService().executeInLocalViewWithParams(params, new SessionExecutionBody() {

                @Override
                public void executeWithoutResult()
                {
                    getModelService().save(manufacturerDetailsModel);

                }

            });
        }

    }

    @Override
    public CountryModel getCountryModel(final String countryIsocode) {
        validateParameterNotNull(countryIsocode, "countryIsocode must not be null!");
        logger.info("Inside getCountryModel Method");
        return manufacturerDetailsDao.getCountryModel(countryIsocode);
    }

    @Override
    public List<CountryModel> getListOfCountry() {
        return getManufacturerDetailsDao().getListOfCountry();
    }

    public ManufacturerDetailsDao getManufacturerDetailsDao() {
        return manufacturerDetailsDao;
    }

    @Required
    public void setManufacturerDetailsDao(final ManufacturerDetailsDao manufacturerDetailsDao) {
        this.manufacturerDetailsDao = manufacturerDetailsDao;
    }

    public ModelService getModelService() {
        return modelService;
    }

    @Required
    public void setModelService(final ModelService modelService) {
        this.modelService = modelService;
    }

    public SessionService getSessionService() {
        return sessionService;
    }
        @Required
    public void setSessionService(final SessionService sessionService) {
        this.sessionService = sessionService;
    }
}
