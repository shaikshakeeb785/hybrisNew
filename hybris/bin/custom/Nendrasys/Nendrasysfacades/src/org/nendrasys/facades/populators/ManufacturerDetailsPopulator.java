package org.nendrasys.facades.populators;

import de.hybris.platform.commercefacades.product.data.ManufacturerDetailsData;
import de.hybris.platform.commercefacades.user.data.AddressData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.model.user.AddressModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.nendrasys.core.attributeHandler.CarsTotalAmountPaidHandler;
import org.nendrasys.core.model.ManufacturerDetailsModel;
import org.springframework.beans.factory.annotation.Required;

import java.util.Map;

/**
 * @ManufacturerDetailsPoplator class is responsible for converting ManufacturerDetailsModel to ManufacturerDetailsData
 */
public class ManufacturerDetailsPopulator implements Populator<ManufacturerDetailsModel, ManufacturerDetailsData> {
    public static final Logger logger = LogManager.getLogger(CarsTotalAmountPaidHandler.class);
    Converter<CountryModel, CountryData> countryDataConverter;
    Converter<AddressModel, AddressData> AddressDataConverter;

    @Override
    public void populate(ManufacturerDetailsModel source, ManufacturerDetailsData target) throws ConversionException {
        BasicConfigurator.configure();
        logger.info("inside Populate method which is used to set the values from source to target");
        target.setId(source.getId());
        target.setName(source.getName());
        target.setCity(source.getCity());
        target.setCountry(getCountryDataConverter().convert(source.getCountry()));
        Map<String, AddressModel> map = source.getUserAddressMap();
        AddressModel model = map.get("Address Line1");
        if (model != null) {
            target.setUserAddressMap(getAddressDataConverter().convert(model));

        }
    }

    public Converter<CountryModel, CountryData> getCountryDataConverter() {
        return countryDataConverter;
    }

    @Required
    public void setCountryDataConverter(Converter<CountryModel, CountryData> countryDataConverter) {
        this.countryDataConverter = countryDataConverter;
    }

    public Converter<AddressModel, AddressData> getAddressDataConverter() {
        return AddressDataConverter;
    }

    @Required
    public void setAddressDataConverter(Converter<AddressModel, AddressData> addressDataConverter) {
        AddressDataConverter = addressDataConverter;
    }
}
