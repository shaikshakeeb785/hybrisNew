/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorservices.payment.cybersource.converters.populators.response;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

import de.hybris.platform.acceleratorservices.payment.data.CreateSubscriptionResult;
import de.hybris.platform.acceleratorservices.payment.data.OrderInfoData;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.Map;


public class OrderInfoResultPopulator extends AbstractResultPopulator<Map<String, String>, CreateSubscriptionResult>
{
	@Override
	public void populate(final Map<String, String> source, final CreateSubscriptionResult target) throws ConversionException
	{
		validateParameterNotNull(source, "Parameter [Map<String, String>] source cannot be null");
		validateParameterNotNull(target, "Parameter [CreateSubscriptionResult] target cannot be null");

		final OrderInfoData data = new OrderInfoData();
		data.setComments(source.get("comments"));
		data.setOrderNumber(source.get("orderNumber"));
		data.setOrderPageRequestToken(source.get("orderPage_requestToken"));
		data.setOrderPageTransactionType(source.get("orderPage_transactionType"));
		data.setSubscriptionTitle(source.get("subscription_title"));
		data.setTaxAmount(source.get("taxAmount"));

		target.setOrderInfoData(data);
	}
}
