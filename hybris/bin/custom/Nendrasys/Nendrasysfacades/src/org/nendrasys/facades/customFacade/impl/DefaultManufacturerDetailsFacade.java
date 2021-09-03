package org.nendrasys.facades.CustomFacade.impl;

import de.hybris.platform.commercefacades.product.data.ManufacturerDetailsData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import de.hybris.platform.servicelayer.exceptions.ModelSavingException;

import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.nendrasys.core.customService.impl.DefaultManufacturerDetailsService;
import org.nendrasys.core.model.ManufacturerDetailsModel;
import org.nendrasys.facades.CustomFacade.ManufacturerDetailesFacade;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;

import java.util.List;

/**
 * implementation for {@link ManufacturerDetailesFacade}
 */
public class DefaultManufacturerDetailsFacade implements ManufacturerDetailesFacade {


    public static final Logger logger = LogManager.getLogger(DefaultManufacturerDetailsFacade.class);

    private ModelService modelService;
    private DefaultManufacturerDetailsService defaultManufacturerDetailsService;
    private Converter<ManufacturerDetailsModel, ManufacturerDetailsData> manufacturerDetailsDataConverter;
    private Converter<CountryModel, CountryData> countryModelDataConverter;

    @Override
    public ManufacturerDetailsData getManufacturerDetailsById(String id) {
        BasicConfigurator.configure();
        logger.error("Inside getManufacturerDetailsById inside facade class");
        ManufacturerDetailsModel details = getDefaultManufacturerDetailsService().getManufacturerDetailsById(id);
        if (details != null) {
            ManufacturerDetailsData data = getManufacturerDetailsDataConverter().convert(details);
            return data;
        } else {
            logger.error("Data Not Found For This Id'" + id + "'");
        }
        return null;
    }

    @Override
    public List<ManufacturerDetailsData> getListOfManufacturerData() {
        logger.error("Inside getListOfManufacturerData Method");
        final List<ManufacturerDetailsModel> allManufacturerDetail = getDefaultManufacturerDetailsService().getManufacturerDetailsData();

        if (!allManufacturerDetail.isEmpty()) {
            final List<ManufacturerDetailsData> allManufacturerDetailData = getManufacturerDetailsDataConverter().convertAll(allManufacturerDetail);
            return allManufacturerDetailData;
        } else {
            logger.error("Data Not Found For ManufacturerDetail List");
        }
        return null;
    }

    @Override
    public List<ManufacturerDetailsData> getManufacturerDetailsPaginetion(int CurrentPage) {
        final List<ManufacturerDetailsModel> allManufacturerDetail = getDefaultManufacturerDetailsService().getManufacturerDetailsPaginetion(CurrentPage);

        if (!allManufacturerDetail.isEmpty()) {
            final List<ManufacturerDetailsData> allManufacturerDetailData = getManufacturerDetailsDataConverter().convertAll(allManufacturerDetail);
            return allManufacturerDetailData;
        } else {
            logger.error("Data Not Found For ManufacturerDetail List");
        }
        return null;
    }

    @Override
    public void saveManufacturerDetail(final ManufacturerDetailsData manufacturerDetailsData) throws ModelSavingException {
        logger.info("Inside saveManufacturerDetail Method ");
        Assert.notNull(manufacturerDetailsData, "Parameter manufacturerDetailsData cannot be null.");
        if (manufacturerDetailsData != null) {
            ManufacturerDetailsModel manufacturerDetailsModel = modelService.create(ManufacturerDetailsModel.class);
            manufacturerDetailsModel.setCity(manufacturerDetailsData.getCity());
            manufacturerDetailsModel.setName(manufacturerDetailsData.getName());
            CountryModel countryModel = defaultManufacturerDetailsService.getCountryModel(manufacturerDetailsData.getCountry().getIsocode());
            if (countryModel != null) {
                manufacturerDetailsModel.setCountry(countryModel);
                defaultManufacturerDetailsService.registerManufacturerDetailSave(manufacturerDetailsModel);
            }
        }

    }

    @Override
    public List<CountryData> getListOfCountry() {
        logger.info("Inside getListOfCountry Method");
        List<CountryModel> countryList = null;
        countryList = defaultManufacturerDetailsService.getListOfCountry();
        if (!countryList.isEmpty()) {
            List<CountryData> listData = getCountryModelDataConverter().convertAll(countryList);
            return listData;
        }
        return null;
    }


    public DefaultManufacturerDetailsService getDefaultManufacturerDetailsService() {
        return defaultManufacturerDetailsService;
    }

    @Required
    public void setDefaultManufacturerDetailsService(DefaultManufacturerDetailsService defaultManufacturerDetailsService) {
        this.defaultManufacturerDetailsService = defaultManufacturerDetailsService;
    }

    public Converter<ManufacturerDetailsModel, ManufacturerDetailsData> getManufacturerDetailsDataConverter() {
        return manufacturerDetailsDataConverter;
    }

    @Required
    public void setManufacturerDetailsDataConverter(Converter<ManufacturerDetailsModel, ManufacturerDetailsData> manufacturerDetailsDataConverter) {
        this.manufacturerDetailsDataConverter = manufacturerDetailsDataConverter;

    }

    public ModelService getModelService() {
        return modelService;
    }

    @Required
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    public Converter<CountryModel, CountryData> getCountryModelDataConverter() {
        return countryModelDataConverter;
    }

    @Required
    public void setCountryModelDataConverter(Converter<CountryModel, CountryData> countryModelDataConverter) {
        this.countryModelDataConverter = countryModelDataConverter;
    }
}
