/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.services.impl;

import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.jalo.order.price.PriceInformation;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindPriceStrategy;
import de.hybris.platform.product.BaseCriteria;
import de.hybris.platform.sap.productconfig.services.intf.ProductConfigurationPricingStrategy;
import de.hybris.platform.util.PriceValue;

import java.util.List;

import org.apache.log4j.Logger;


/**
 * Product configuration specific implementation of {@link FindPriceStrategy} This class ensures, that the base price of
 * any configurable cart entry is correctly set to the price of the associated product configuration state.
 */
public class FindPricingForConfigurableProductsStrategy implements FindPriceStrategy
{
	private static final Logger LOG = Logger.getLogger(FindPricingForConfigurableProductsStrategy.class);
	private final CPQConfigurableChecker cpqConfigurableChecker;
	private final ProductConfigurationPricingStrategy productConfigurationPricingStrategy;
	private final FindPriceStrategy defaultPriceStrategy;

	public FindPricingForConfigurableProductsStrategy(final CPQConfigurableChecker cpqConfigurableChecker,
			final ProductConfigurationPricingStrategy productConfigurationPricingStrategy,
			final FindPriceStrategy defaultPriceStrategy)
	{
		this.cpqConfigurableChecker = cpqConfigurableChecker;
		this.productConfigurationPricingStrategy = productConfigurationPricingStrategy;
		this.defaultPriceStrategy = defaultPriceStrategy;
	}


	@Override
	public PriceValue findBasePrice(final AbstractOrderEntryModel entry) throws CalculationException
	{
		final PriceValue basePrice;
		if (getCpqConfigurableChecker().isCPQConfiguratorApplicableProduct(entry.getProduct()))
		{
			if (LOG.isDebugEnabled())
			{
				LOG.debug("Obtaining base price for configurable product " + entry.getProduct().getCode());
			}
			basePrice = getProductConfigurationPricingStrategy().calculateBasePriceForConfiguration(entry);
		}
		else
		{
			basePrice = getDefaultPriceStrategy().findBasePrice(entry);
		}
		return basePrice;
	}

	@Override
	public List<PriceInformation> getPriceInformation(final BaseCriteria baseCriteria) throws CalculationException
	{
		return getDefaultPriceStrategy().getPriceInformation(baseCriteria);
	}

	@Override
	public boolean isSLOnly()
	{
		return getDefaultPriceStrategy().isSLOnly();
	}

	protected CPQConfigurableChecker getCpqConfigurableChecker()
	{
		return this.cpqConfigurableChecker;
	}

	protected ProductConfigurationPricingStrategy getProductConfigurationPricingStrategy()
	{
		return productConfigurationPricingStrategy;
	}

	protected FindPriceStrategy getDefaultPriceStrategy()
	{
		return defaultPriceStrategy;
	}
}
