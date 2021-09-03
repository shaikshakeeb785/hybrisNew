package org.nendrasys.facades.populators;

import de.hybris.platform.commercefacades.product.data.ManufacturerDetailsData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.nendrasys.core.model.ManufacturerDetailsModel;
import org.springframework.beans.factory.annotation.Required;

public class ManufacturerToProductPopulator implements Populator<ProductModel, ProductData> {

    Converter<ManufacturerDetailsModel, ManufacturerDetailsData> manufacturerDetailsDataConverter;

    @Override
    public void populate(ProductModel source, ProductData target) throws ConversionException {

        target.setManufacturerDetails(manufacturerDetailsDataConverter.convertAll(source.getManufacturerDetails()));


    }

    public Converter<ManufacturerDetailsModel, ManufacturerDetailsData> getManufacturerDetailsDataConverter() {
        return manufacturerDetailsDataConverter;
    }

    @Required
    public void setManufacturerDetailsDataConverter(Converter<ManufacturerDetailsModel, ManufacturerDetailsData> manufacturerDetailsDataConverter) {
        this.manufacturerDetailsDataConverter = manufacturerDetailsDataConverter;
    }
}
