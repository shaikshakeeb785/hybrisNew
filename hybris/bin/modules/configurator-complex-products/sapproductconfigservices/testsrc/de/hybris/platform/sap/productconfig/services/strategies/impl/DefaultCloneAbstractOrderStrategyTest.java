/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.services.strategies.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.order.CartEntryModel;
import de.hybris.platform.core.model.order.CartModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.order.AbstractOrderEntryTypeService;
import de.hybris.platform.order.strategies.ordercloning.CloneAbstractOrderStrategy;
import de.hybris.platform.sap.productconfig.services.strategies.impl.DefaultCloneAbstractOrderStrategy.OrderCopyContext;
import de.hybris.platform.servicelayer.internal.model.impl.ItemModelCloneCreator;
import de.hybris.platform.servicelayer.internal.model.impl.ItemModelCloneCreator.CopyContext;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.spockframework.util.CollectionUtil;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SuppressWarnings("javadoc")
@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class DefaultCloneAbstractOrderStrategyTest
{
	private static final String ATTRIBUTE_TO_SKIP = "attributeToSkip";

	@InjectMocks
	private DefaultCloneAbstractOrderStrategy classUnderTest;

	@Mock
	private CloneAbstractOrderStrategy defaultCloneAbstractOrderStrategy;
	@Mock
	private TypeService typeService;
	@Mock
	private ItemModelCloneCreator itemModelCloneCreator;
	@Mock
	private AbstractOrderEntryTypeService abstractOrderEntryTypeService;
	@Spy
	private final List<String> skippedAttributesList = new ArrayList(Arrays.asList(ATTRIBUTE_TO_SKIP));
	@Mock
	private Set<String> skippedAttributes;
	@Mock
	private ComposedTypeModel composedType;
	@Mock
	private AbstractOrderModel sourceOrder;
	@Mock
	private AbstractOrderEntryModel sourceOrderEntry;
	@Mock
	private AbstractOrderModel targetOrder;
	@Mock
	private AbstractOrderEntryModel targetOrderEntry;

	@Before
	public void setup()
	{
		when(sourceOrder.getEntries()).thenReturn(CollectionUtil.listOf(sourceOrderEntry));
		when(targetOrder.getEntries()).thenReturn(CollectionUtil.listOf(targetOrderEntry));
		when(skippedAttributes.contains(ATTRIBUTE_TO_SKIP)).thenReturn(true);
		when(itemModelCloneCreator.copy(any(ComposedTypeModel.class), eq(sourceOrder), any(CopyContext.class)))
				.thenReturn(targetOrder);
	}

	@Test
	public void testOrderCopyContext()
	{
		final OrderCopyContext copyContextUnderTest = new OrderCopyContext(composedType, skippedAttributes);
		assertNotNull(copyContextUnderTest);
		assertTrue(copyContextUnderTest.skipAttribute(null, ATTRIBUTE_TO_SKIP));
		assertFalse(copyContextUnderTest.skipAttribute(null, "some attribute to be copied"));
		assertEquals(composedType, copyContextUnderTest.getTargetType(sourceOrderEntry));
		assertNull(copyContextUnderTest.getTargetType(sourceOrder));
	}

	@Test
	public void testCloneEntries()
	{
		classUnderTest.cloneEntries(composedType, sourceOrder);
		verify(defaultCloneAbstractOrderStrategy, times(1)).cloneEntries(composedType, sourceOrder);
	}

	@Test
	public void testClone()
	{
		final AbstractOrderModel result = classUnderTest.clone(composedType, composedType, sourceOrder, "code", CartModel.class,
				CartEntryModel.class);
		assertNotNull(result);
	}

	@Test
	public void testCloneNoTypeGiven()
	{
		final AbstractOrderModel result = classUnderTest.clone(null, null, sourceOrder, null, CartModel.class,
				CartEntryModel.class);
		assertNotNull(result);
	}

	@Test
	public void testCloneAssignableTargetTypeGiven()
	{
		final AbstractOrderModel result = classUnderTest.clone(null, null, sourceOrder, null, AbstractOrderModel.class,
				AbstractOrderEntryModel.class);
		assertNotNull(result);
	}

	@Test(expected = IllegalStateException.class)
	public void testCloneWrongTargetEntrySize()
	{
		when(targetOrder.getEntries()).thenReturn(new ArrayList());
		classUnderTest.clone(null, null, sourceOrder, null, CartModel.class, CartEntryModel.class);
	}

	@Test
	public void testCloneNullTargetEntries()
	{
		when(sourceOrder.getEntries()).thenReturn(new ArrayList());
		when(targetOrder.getEntries()).thenReturn(null);
		final AbstractOrderModel result = classUnderTest.clone(null, null, sourceOrder, null, AbstractOrderModel.class,
				AbstractOrderEntryModel.class);
		assertNotNull(result);
	}
}
