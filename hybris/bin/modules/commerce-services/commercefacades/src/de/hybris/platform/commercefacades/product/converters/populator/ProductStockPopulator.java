/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.product.converters.populator;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.product.data.StockData;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import org.springframework.beans.factory.annotation.Required;


/**
 * Populate the product data with stock information
 */
public class ProductStockPopulator<SOURCE extends ProductModel, TARGET extends ProductData> extends
		AbstractProductPopulator<SOURCE, TARGET>
{
	private Converter<ProductModel, StockData> stockConverter;

	protected Converter<ProductModel, StockData> getStockConverter()
	{
		return stockConverter;
	}

	@Required
	public void setStockConverter(final Converter<ProductModel, StockData> stockConverter)
	{
		this.stockConverter = stockConverter;
	}

	@Override
	public void populate(final SOURCE source, final TARGET target) throws ConversionException
	{
		target.setStock(getStockConverter().convert(source));
	}
}
