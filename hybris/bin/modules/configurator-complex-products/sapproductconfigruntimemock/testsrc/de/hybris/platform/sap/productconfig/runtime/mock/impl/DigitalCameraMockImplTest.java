/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.runtime.mock.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import de.hybris.platform.sap.productconfig.runtime.interf.model.ConfigModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.CsticModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.CsticValueModel;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.CollectionUtils;


public class DigitalCameraMockImplTest
{
	private static final BigDecimal BASE_PRICE = BigDecimal.valueOf(750);
	private final DigitalCameraMockImpl classUnderTest = new DigitalCameraMockImpl();
	private ConfigModel model;
	private CsticModel csticPixel;
	private CsticModel csticSensor;

	@Before
	public void setUp()
	{
		model = classUnderTest.createDefaultConfiguration();
		csticPixel = model.getRootInstance().getCstic(DigitalCameraMockImpl.CAMERA_PIXELS);
		csticSensor = model.getRootInstance().getCstic(DigitalCameraMockImpl.CAMERA_SENSOR);
		assertNotNull(csticPixel);
	}

	@Test
	public void testSize()
	{
		assertEquals(16, model.getRootInstance().getCstics().size());
	}

	@Test
	public void testDefaultPrice()
	{
		assertEquals(BASE_PRICE, model.getBasePrice().getPriceValue());
	}

	@Test
	public void testPriceAfterUpdate()
	{
		classUnderTest.checkModel(model);
		assertEquals(BASE_PRICE, model.getBasePrice().getPriceValue());
	}

	@Test
	public void testCheckCsticDefaultConfiguration()
	{
		classUnderTest.checkCstic(model, model.getRootInstance(), csticPixel);
		assertEquals(4, csticPixel.getAssignableValues().size());
	}

	@Test
	public void testPixelsForStandardMode()
	{
		classUnderTest.checkPixels(model.getRootInstance(), csticPixel);
		assertEquals(4, csticPixel.getAssignableValues().size());
	}

	@Test
	public void testPixelsForProfMode()
	{
		setModeProf();
		classUnderTest.checkPixels(model.getRootInstance(), csticPixel);
		assertEquals(3, csticPixel.getAssignableValues().size());
	}

	@Test
	public void testSensorForDefaultConfig()
	{
		classUnderTest.checkSensor(model.getRootInstance(), csticSensor);
		assertEquals(3, csticSensor.getAssignableValues().size());
	}

	@Test
	public void testSensorForModeProf()
	{
		setModeProf();
		classUnderTest.checkSensor(model.getRootInstance(), csticSensor);
		final List<CsticValueModel> assignableValues = csticSensor.getAssignableValues();
		assertEquals(2, assignableValues.size());
		assertEquals(DigitalCameraMockImpl.FULL_FRAME, assignableValues.get(0).getName());
	}

	@Test
	public void testSensorForModeStandard()
	{
		setModeStandard();
		classUnderTest.checkSensor(model.getRootInstance(), csticSensor);
		final List<CsticValueModel> assignableValues = csticSensor.getAssignableValues();
		assertEquals(2, assignableValues.size());
		assertEquals(DigitalCameraMockImpl.COMPACT, assignableValues.get(0).getName());
	}

	@Test
	public void testNoConflictingSensors()
	{
		setModeStandard();
		classUnderTest.checkSensor(model.getRootInstance(), csticSensor);
		final List<CsticValueModel> assignableValues = csticSensor.getAssignableValues();
		assertEquals(DigitalCameraMockImpl.COMPACT, assignableValues.get(0).getName());
		csticSensor.setSingleValue(DigitalCameraMockImpl.COMPACT);
		setModeProf();
		classUnderTest.checkSensor(model.getRootInstance(), csticSensor);
		assertTrue(CollectionUtils.isEmpty(csticSensor.getAssignedValues()));
	}

	@Test
	public void testNoConflictingSensorsFullFrame()
	{
		setModeProf();
		classUnderTest.checkSensor(model.getRootInstance(), csticSensor);

		csticSensor.setSingleValue(DigitalCameraMockImpl.FULL_FRAME);

		setModeStandard();
		classUnderTest.checkSensor(model.getRootInstance(), csticSensor);

		assertTrue(CollectionUtils.isEmpty(csticSensor.getAssignedValues()));
	}

	@Test
	public void testNoConflictingPixels()
	{
		setModeStandard();
		classUnderTest.checkPixels(model.getRootInstance(), csticPixel);

		csticPixel.setSingleValue(DigitalCameraMockImpl.P8);

		setModeProf();
		classUnderTest.checkPixels(model.getRootInstance(), csticPixel);

		assertTrue(CollectionUtils.isEmpty(csticPixel.getAssignedValues()));
	}

	protected void setModeStandard()
	{
		final CsticModel csticMode = model.getRootInstance().getCstic(DigitalCameraMockImpl.CAMERA_MODE);
		csticMode.setSingleValue(DigitalCameraMockImpl.MODE_STANDARD);
	}



	protected void setModeProf()
	{
		final CsticModel csticMode = model.getRootInstance().getCstic(DigitalCameraMockImpl.CAMERA_MODE);
		csticMode.setSingleValue(DigitalCameraMockImpl.MODE_PROF);
	}


}
