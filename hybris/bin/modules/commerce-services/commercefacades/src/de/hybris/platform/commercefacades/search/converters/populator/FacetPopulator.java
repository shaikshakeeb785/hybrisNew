/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.search.converters.populator;

import de.hybris.platform.commerceservices.search.facetdata.FacetData;
import de.hybris.platform.commerceservices.search.facetdata.FacetValueData;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import org.springframework.beans.factory.annotation.Required;

/**
 */
public class FacetPopulator<QUERY, STATE> implements Populator<FacetData<QUERY>, FacetData<STATE>>
{
	private Converter<FacetValueData<QUERY>, FacetValueData<STATE>> facetValueConverter;

	protected Converter<FacetValueData<QUERY>, FacetValueData<STATE>> getFacetValueConverter()
	{
		return facetValueConverter;
	}

	@Required
	public void setFacetValueConverter(final Converter<FacetValueData<QUERY>, FacetValueData<STATE>> facetValueConverter)
	{
		this.facetValueConverter = facetValueConverter;
	}

	@Override
	public void populate(final FacetData<QUERY> source, final FacetData<STATE> target)
	{
		target.setCode(source.getCode());
		target.setCategory(source.isCategory());
		target.setMultiSelect(source.isMultiSelect());
		target.setName(source.getName());
		target.setPriority(source.getPriority());
		target.setVisible(source.isVisible());

		if (source.getTopValues() != null)
		{
			target.setTopValues(Converters.convertAll(source.getTopValues(), getFacetValueConverter()));
		}

		if (source.getValues() != null)
		{
			target.setValues(Converters.convertAll(source.getValues(), getFacetValueConverter()));
		}
	}
}
