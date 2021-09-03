/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.jalo.order.AbstractOrderEntry;
import de.hybris.platform.order.exceptions.CalculationException;
import de.hybris.platform.order.strategies.calculation.FindPriceStrategy;
import de.hybris.platform.product.BaseCriteria;
import de.hybris.platform.sap.productconfig.services.intf.ProductConfigurationPricingStrategy;
import de.hybris.platform.util.PriceValue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


/**
 *
 */
@UnitTest
public class FindPricingForConfigurableProductsStrategyTest
{
	final private Double BASE_PRICE = Double.valueOf("111.11");

	private FindPricingForConfigurableProductsStrategy classUnderTest;

	@Mock
	private CPQConfigurableChecker cpqConfigurableChecker;

	@Mock
	private ProductConfigurationPricingStrategy productConfigurationPricingStrategy;

	@Mock
	private FindPriceStrategy defaultPriceStrategy;

	@Mock
	private AbstractOrderEntry entryItem;

	@Mock
	private ProductModel product;

	private final AbstractOrderEntryModel entry = new AbstractOrderEntryModel();
	private final PriceValue configurablePriceValue = new PriceValue("EUR", 2.0, true);
	@Mock
	private BaseCriteria baseCriteria;

	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		classUnderTest = new FindPricingForConfigurableProductsStrategy(cpqConfigurableChecker, productConfigurationPricingStrategy,
				defaultPriceStrategy);
		entry.setProduct(product);
		entry.setBasePrice(BASE_PRICE);
		given(product.getCode()).willReturn("PRODUCT_CODE");
		given(productConfigurationPricingStrategy.calculateBasePriceForConfiguration(entry)).willReturn(configurablePriceValue);
	}

	@Test
	public void testFindBasePriceNeitherKMATNorChangeableVariant() throws CalculationException
	{
		final PriceValue priceValue = new PriceValue("EUR", 1.0, true);
		classUnderTest = spy(classUnderTest);
		given(defaultPriceStrategy.findBasePrice(entry)).willReturn(priceValue);
		final PriceValue returnedPriceValue = classUnderTest.findBasePrice(entry);
		assertEquals(priceValue, returnedPriceValue);
	}

	@Test
	public void testFindBasePriceKMATorChangeableVariant() throws CalculationException, Exception
	{
		given(cpqConfigurableChecker.isCPQConfiguratorApplicableProduct(product)).willReturn(Boolean.TRUE);
		final PriceValue returnedPriceValue = classUnderTest.findBasePrice(entry);
		assertEquals(configurablePriceValue, returnedPriceValue);
	}

	@Test
	public void testGetPriceInformation() throws CalculationException
	{
		classUnderTest.getPriceInformation(baseCriteria);
		verify(defaultPriceStrategy).getPriceInformation(baseCriteria);
	}

	@Test
	public void testISLOnly()
	{
		Mockito.when(defaultPriceStrategy.isSLOnly()).thenReturn(true);
		assertTrue(classUnderTest.isSLOnly());
	}
}

