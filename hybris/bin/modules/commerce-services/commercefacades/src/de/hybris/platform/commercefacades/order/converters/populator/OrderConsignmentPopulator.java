/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.converters.populator;

import de.hybris.platform.commercefacades.order.data.ConsignmentData;
import de.hybris.platform.commercefacades.order.data.OrderData;
import de.hybris.platform.commercefacades.order.data.OrderEntryData;
import de.hybris.platform.converters.Converters;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.OrderModel;
import de.hybris.platform.ordersplitting.model.ConsignmentEntryModel;
import de.hybris.platform.ordersplitting.model.ConsignmentModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;


/**
 * Populates consignment related attributes of order
 */
public class OrderConsignmentPopulator<SOURCE extends OrderModel, TARGET extends OrderData> implements Populator<SOURCE, TARGET>
{
	private Converter<AbstractOrderEntryModel, OrderEntryData> orderEntryConverter;
	private Converter<ConsignmentModel, ConsignmentData> consignmentConverter;

	protected Converter<ConsignmentModel, ConsignmentData> getConsignmentConverter()
	{
		return consignmentConverter;
	}

	@Required
	public void setConsignmentConverter(final Converter<ConsignmentModel, ConsignmentData> consignmentConverter)
	{
		this.consignmentConverter = consignmentConverter;
	}


	protected Converter<AbstractOrderEntryModel, OrderEntryData> getOrderEntryConverter()
	{
		return orderEntryConverter;
	}

	@Required
	public void setOrderEntryConverter(final Converter<AbstractOrderEntryModel, OrderEntryData> orderEntryConverter)
	{
		this.orderEntryConverter = orderEntryConverter;
	}

	@Override
	public void populate(final SOURCE source, final TARGET target) throws ConversionException
	{
		Assert.notNull(source, "Parameter source cannot be null.");
		Assert.notNull(target, "Parameter target cannot be null.");

		addConsignments(source, target);
		addUnconsignedEntries(source, target);
	}

	protected void addConsignments(final OrderModel source, final OrderData target)
	{
		target.setConsignments(Converters.convertAll(source.getConsignments(), getConsignmentConverter()));
	}

	protected void addUnconsignedEntries(final OrderModel source, final OrderData target)
	{
		final List<AbstractOrderEntryModel> entries = new ArrayList<AbstractOrderEntryModel>(source.getEntries());
		for (final ConsignmentModel consignmentModel : source.getConsignments())
		{
			if (CollectionUtils.isNotEmpty(consignmentModel.getConsignmentEntries()))
			{
				for (final ConsignmentEntryModel consignmentEntryModel : consignmentModel.getConsignmentEntries())
				{
					entries.remove(consignmentEntryModel.getOrderEntry());
				}
			}
		}
		target.setUnconsignedEntries(Converters.convertAll(entries, getOrderEntryConverter()));
	}
}
