/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.facades.integrationtests;

import static org.junit.Assert.assertEquals;

import de.hybris.bootstrap.annotations.ManualTest;
import de.hybris.platform.commercefacades.storesession.StoreSessionFacade;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commerceservices.order.CommerceCartModificationException;
import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.sap.productconfig.facades.ConfigurationData;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;

import java.util.Collections;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


@SuppressWarnings("javadoc")
@ManualTest
public class CurrencyCartIntegrationTest extends CPQFacadeLayerTest
{
	private static final String TIGER_CURRENCY_ISO_CODE = "TGI";
	private static final String TIGER_CURRENCY_SAP_CODE = "TGS";
	private static final Logger LOG = Logger.getLogger(CurrencyCartIntegrationTest.class);
	private static final String USD = "USD";

	private static final String EUR = "EUR";

	private static final String QUERY_ATTRIBUTE_CART_ENTRY_KEY = "cartEntryKey";

	private static final String QUERY_GET_ENTRY_BY_PK = "GET {cartentry} where {pk}=?cartEntryKey";

	@Resource(name = "storeSessionFacade")
	private StoreSessionFacade storeSessionFacade;

	@Resource(name = "userFacade")
	private UserFacade userFacade;

	@Before
	public void setUp() throws Exception
	{
		prepareCPQData();
		useCurrency_USD();
	}

	protected void changeCurrency(final String isoCode)
	{
		storeSessionFacade.setCurrentCurrency(isoCode);
		userFacade.syncSessionCurrency();
	}

	@Test
	public void testPriceChangesInCartAfterCurrencyChange() throws CommerceCartModificationException
	{
		final ConfigurationData configData = cpqFacade.getConfiguration(KB_KEY_CPQ_HOME_THEATER);
		final String cartItemKey = cpqCartFacade.addConfigurationToCart(configData);
		Assert.assertNotNull(cartItemKey);
		final Map<String, String> params = Collections.singletonMap(QUERY_ATTRIBUTE_CART_ENTRY_KEY, cartItemKey);
		CartEntryModel cartEntry = flexibleSearchService.searchUnique(new FlexibleSearchQuery(QUERY_GET_ENTRY_BY_PK, params));
		assertEquals(Double.valueOf(1133.0), cartEntry.getBasePrice());
		assertEquals(USD, cartEntry.getOrder().getCurrency().getIsocode());

		changeCurrency(EUR);
		cartEntry = flexibleSearchService.searchUnique(new FlexibleSearchQuery(QUERY_GET_ENTRY_BY_PK, params));
		assertEquals(Double.valueOf(1246.30), cartEntry.getBasePrice());
		assertEquals(EUR, cartEntry.getOrder().getCurrency().getIsocode());
	}

	@Test
	public void testSAPCurrencyCodeDiffersFromISOCurrencyCode() throws CommerceCartModificationException
	{
		changeCurrency(TIGER_CURRENCY_ISO_CODE);
		// FixMe: if we want to test something with sap-currrency we need to move the test into sapintegration extension
		//assertEquals(TIGER_CURRENCY_SAP_CODE, commonI18NService.getCurrentCurrency().getSapCode());
		final ConfigurationData configData = cpqFacade.getConfiguration(KB_KEY_CPQ_HOME_THEATER);
		final String cartItemKey = cpqCartFacade.addConfigurationToCart(configData);
		Assert.assertNotNull(cartItemKey);
		final Map<String, String> params = Collections.singletonMap(QUERY_ATTRIBUTE_CART_ENTRY_KEY, cartItemKey);
		final CartEntryModel cartEntry = flexibleSearchService.searchUnique(new FlexibleSearchQuery(QUERY_GET_ENTRY_BY_PK, params));
		assertEquals(Double.valueOf(2266.0), cartEntry.getBasePrice());
		assertEquals(TIGER_CURRENCY_ISO_CODE, cartEntry.getOrder().getCurrency().getIsocode());
	}

}
