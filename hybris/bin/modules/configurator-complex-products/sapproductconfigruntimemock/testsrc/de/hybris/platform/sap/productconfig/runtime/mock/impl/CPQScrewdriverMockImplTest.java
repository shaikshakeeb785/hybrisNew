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

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.sap.productconfig.runtime.interf.model.ConfigModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.CsticGroupModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.CsticModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.CsticValueModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.impl.CsticValueModelImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


@SuppressWarnings("javadoc")
@UnitTest
public class CPQScrewdriverMockImplTest
{
	private static final BigDecimal BASE_PRICE = BigDecimal.valueOf(160);
	private CPQScrewdriverMockImpl classUnderTest;
	private ConfigModel model;
	private CsticModel csticCol;

	@Before
	public void setUp()
	{
		classUnderTest = (CPQScrewdriverMockImpl) new RunTimeConfigMockFactory()
				.createConfigMockForProductCode("CONF_SCREWDRIVER_S");
		model = classUnderTest.createDefaultConfiguration();
		csticCol = model.getRootInstance().getCstic(CPQScrewdriverMockImpl.CONF_SCREWDRIVER_COL);
	}

	private List<CsticValueModel> setAssignedValue(final String value)
	{
		final List<CsticValueModel> assignedValues = new ArrayList<>();
		final CsticValueModel csticValue = new CsticValueModelImpl();
		csticValue.setName(value);
		assignedValues.add(csticValue);

		return assignedValues;
	}

	@Test
	public void testSize()
	{
		assertEquals(12, model.getRootInstance().getCstics().size());
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
	public void testColorProfessional()
	{
		setMode(CPQScrewdriverMockImpl.CONF_SCREWDRIVER_PROFESSIONAL);
		testForColor(CPQScrewdriverMockImpl.CONF_SCREWDRIVER_BLUE);
	}

	@Test
	public void testColorStandard()
	{
		setMode(CPQScrewdriverMockImpl.CONF_SCREWDRIVER_STANDARD);
		testForColor(CPQScrewdriverMockImpl.CONF_SCREWDRIVER_GREEN);
	}

	@Test
	public void testColorWithoutMode()
	{
		setMode(null);
		final List<CsticValueModel> assignedValues = csticCol.getAssignedValues();
		assertEquals(0, assignedValues.size());
	}

	@Test
	public void testGroupsCreated()
	{
		final List<CsticGroupModel> groups = model.getRootInstance().getCsticGroups();
		assertEquals(4, groups.size());

		CsticGroupModel genGroup = groups.get(0);
		assertEquals("_GEN", genGroup.getName());
		assertEquals(0, genGroup.getCsticNames().size());

		genGroup = groups.get(1);
		assertEquals("1", genGroup.getName());
		assertEquals(2, genGroup.getCsticNames().size());

		genGroup = groups.get(2);
		assertEquals("2", genGroup.getName());
		assertEquals(6, genGroup.getCsticNames().size());

		genGroup = groups.get(3);
		assertEquals("3", genGroup.getName());
		assertEquals(4, genGroup.getCsticNames().size());
	}

	protected void setMode(final String newMode)
	{
		final CsticModel csticMode = model.getRootInstance().getCstic(CPQScrewdriverMockImpl.CONF_SCREWDRIVER_MODE);
		csticMode.setSingleValue(newMode);
		classUnderTest.checkColor(model.getRootInstance(), csticCol);
	}

	protected void testForColor(final String color)
	{
		final List<CsticValueModel> assignedValues = csticCol.getAssignedValues();
		assertEquals(1, assignedValues.size());
		assertEquals(color, assignedValues.get(0).getName());
	}
}
