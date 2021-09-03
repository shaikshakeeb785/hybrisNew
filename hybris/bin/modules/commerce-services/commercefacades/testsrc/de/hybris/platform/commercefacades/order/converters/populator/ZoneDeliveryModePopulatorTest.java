/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.commercefacades.order.converters.populator;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.order.data.ZoneDeliveryModeData;
import de.hybris.platform.commerceservices.util.ConverterFactory;
import de.hybris.platform.converters.impl.AbstractPopulatingConverter;
import de.hybris.platform.deliveryzone.model.ZoneDeliveryModeModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


@UnitTest
public class ZoneDeliveryModePopulatorTest
{
	private final AbstractPopulatingConverter<ZoneDeliveryModeModel, ZoneDeliveryModeData> zoneDeliveryModeConverter = new ConverterFactory<ZoneDeliveryModeModel, ZoneDeliveryModeData, ZoneDeliveryModePopulator>()
			.create(ZoneDeliveryModeData.class, new ZoneDeliveryModePopulator());

	@Before
	public void setUp()
	{
		//Do Nothing
	}

	@Test
	public void testConvert()
	{
		final ZoneDeliveryModeModel zoneDeliveryModeModel = mock(ZoneDeliveryModeModel.class);
		given(zoneDeliveryModeModel.getCode()).willReturn("code");
		given(zoneDeliveryModeModel.getName()).willReturn("name");
		given(zoneDeliveryModeModel.getDescription()).willReturn("desc");
		final ZoneDeliveryModeData zoneDeliveryModeData = zoneDeliveryModeConverter.convert(zoneDeliveryModeModel);
		Assert.assertEquals("code", zoneDeliveryModeData.getCode());
		Assert.assertEquals("name", zoneDeliveryModeData.getName());
		Assert.assertEquals("desc", zoneDeliveryModeData.getDescription());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConvertNull()
	{
		zoneDeliveryModeConverter.convert(null);
	}
}