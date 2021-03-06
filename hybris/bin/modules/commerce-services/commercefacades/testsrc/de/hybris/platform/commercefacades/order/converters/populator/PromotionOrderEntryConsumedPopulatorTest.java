/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.converters.populator;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.order.data.PromotionOrderEntryConsumedData;
import de.hybris.platform.commerceservices.util.ConverterFactory;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.promotions.model.PromotionOrderEntryConsumedModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


@UnitTest
public class PromotionOrderEntryConsumedPopulatorTest
{
	private final AbstractPopulatingConverter<PromotionOrderEntryConsumedModel, PromotionOrderEntryConsumedData> promotionOrderEntryConsumedConverter = new ConverterFactory<PromotionOrderEntryConsumedModel, PromotionOrderEntryConsumedData, PromotionOrderEntryConsumedPopulator>()
			.create(PromotionOrderEntryConsumedData.class, new PromotionOrderEntryConsumedPopulator());

	@Before
	public void setUp()
	{
		//Do Nothing
	}

	@Test
	public void testConvert()
	{
		final PromotionOrderEntryConsumedModel promotionOrderEntryConsumedModel = mock(PromotionOrderEntryConsumedModel.class);
		given(promotionOrderEntryConsumedModel.getCode()).willReturn("code");
		given(promotionOrderEntryConsumedModel.getAdjustedUnitPrice()).willReturn(Double.valueOf(2.0));
		given(promotionOrderEntryConsumedModel.getOrderEntryNumberWithFallback()).willReturn(Integer.valueOf(3));
		given(promotionOrderEntryConsumedModel.getQuantity()).willReturn(Long.valueOf(99));
		final PromotionOrderEntryConsumedData promotionOrderEntryConsumedData = promotionOrderEntryConsumedConverter
				.convert(promotionOrderEntryConsumedModel);
		Assert.assertEquals("code", promotionOrderEntryConsumedData.getCode());
		Assert.assertEquals(Double.valueOf(2.0), promotionOrderEntryConsumedData.getAdjustedUnitPrice());
		Assert.assertEquals(Integer.valueOf(3), promotionOrderEntryConsumedData.getOrderEntryNumber());
		Assert.assertEquals(Long.valueOf(99), promotionOrderEntryConsumedData.getQuantity());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConvertNull()
	{
		promotionOrderEntryConsumedConverter.convert(null);
	}
}
