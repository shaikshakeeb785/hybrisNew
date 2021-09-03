/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.services.strategies.impl;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNull;

import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.core.model.order.AbstractOrderModel;
import de.hybris.platform.core.model.type.ComposedTypeModel;
import de.hybris.platform.order.AbstractOrderEntryTypeService;
import de.hybris.platform.order.strategies.ordercloning.CloneAbstractOrderStrategy;
import de.hybris.platform.servicelayer.internal.model.impl.ItemModelCloneCreator;
import de.hybris.platform.servicelayer.internal.model.impl.ItemModelCloneCreator.CopyContext;
import de.hybris.platform.servicelayer.type.TypeService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;


/**
 * Default implementation of CloneAbstractOrderStrategy
 */
public class DefaultCloneAbstractOrderStrategy implements CloneAbstractOrderStrategy
{
	private static final Logger LOG = Logger.getLogger(DefaultCloneAbstractOrderStrategy.class.getName());
	private final CloneAbstractOrderStrategy cloneAbstractOrderStrategy;
	private final TypeService typeService;
	private final ItemModelCloneCreator itemModelCloneCreator;
	private final AbstractOrderEntryTypeService abstractOrderEntryTypeService;
	private final Set<String> skippedAttributes;

	/**
	 * Default Constructor
	 *
	 * @param cloneAbstractOrderStrategy
	 *           default strategy, which will be called
	 * @param typeService
	 * @param itemModelCloneCreator
	 * @param abstractOrderEntryTypeService
	 * @param skippedAttributes
	 */
	public DefaultCloneAbstractOrderStrategy(final CloneAbstractOrderStrategy cloneAbstractOrderStrategy,
			final TypeService typeService, final ItemModelCloneCreator itemModelCloneCreator,
			final AbstractOrderEntryTypeService abstractOrderEntryTypeService, final List<String> skippedAttributes)
	{
		super();
		this.cloneAbstractOrderStrategy = cloneAbstractOrderStrategy;
		this.typeService = typeService;
		this.itemModelCloneCreator = itemModelCloneCreator;
		this.abstractOrderEntryTypeService = abstractOrderEntryTypeService;
		this.skippedAttributes = new HashSet<String>(skippedAttributes);
	}

	@Override
	public <T extends AbstractOrderModel> T clone(final ComposedTypeModel orderType, final ComposedTypeModel entryType,
			final AbstractOrderModel original, final String code, final Class abstractOrderClassResult,
			final Class abstractOrderEntryClassResult)
	{
		validateParameterNotNull(original, "original must not be null!");
		validateParameterNotNull(abstractOrderClassResult, "abstractOrderClassResult must not be null!");
		validateParameterNotNull(abstractOrderEntryClassResult, "abstractOrderEntryClassResult must not be null!");

		final ComposedTypeModel orderTypeResolved = getOrderType(orderType, original, abstractOrderClassResult);
		final ComposedTypeModel entryTypeResolved = getOrderEntryType(entryType, original, abstractOrderClassResult,
				abstractOrderEntryClassResult);

		LOG.debug("Attributes configured for skipping during clone: " + skippedAttributes);
		final OrderCopyContext copyContext = new OrderCopyContext(entryTypeResolved, skippedAttributes);

		final T orderClone = (T) itemModelCloneCreator.copy(orderTypeResolved, original, copyContext);
		if (code != null)
		{
			orderClone.setCode(code);
		}
		postProcess(original, orderClone);
		return orderClone;
	}

	@Override
	public <T extends AbstractOrderEntryModel> Collection<T> cloneEntries(final ComposedTypeModel entriesType,
			final AbstractOrderModel original)
	{
		return cloneAbstractOrderStrategy.cloneEntries(entriesType, original);
	}

	protected <T extends AbstractOrderModel> ComposedTypeModel getOrderType(final ComposedTypeModel orderType,
			final AbstractOrderModel original, final Class<T> clazz)
	{
		if (orderType != null)
		{
			return orderType;
		}

		if (clazz.isAssignableFrom(original.getClass()))
		{
			return typeService.getComposedTypeForClass(original.getClass());

		}

		return typeService.getComposedTypeForClass(clazz);
	}

	protected <E extends AbstractOrderEntryModel, T extends AbstractOrderModel> ComposedTypeModel getOrderEntryType(
			final ComposedTypeModel entryType, final AbstractOrderModel original, final Class<T> orderClazz, final Class<E> clazz)
	{
		if (entryType != null)
		{
			return entryType;
		}

		if (orderClazz.isAssignableFrom(original.getClass()))
		{
			return abstractOrderEntryTypeService.getAbstractOrderEntryType(original);
		}

		return typeService.getComposedTypeForClass(clazz);
	}

	protected void postProcess(final AbstractOrderModel original, final AbstractOrderModel copy)
	{
		copyTotalTaxValues(original, copy);
		copyCalculatedFlag(original, copy);
	}

	protected void copyTotalTaxValues(final AbstractOrderModel original, final AbstractOrderModel copy)
	{
		copy.setTotalTaxValues(original.getTotalTaxValues());

	}


	protected void copyCalculatedFlag(final AbstractOrderModel original, final AbstractOrderModel copy)
	{
		copy.setCalculated(original.getCalculated());

		final List<AbstractOrderEntryModel> originalEntries = original.getEntries();
		final List<AbstractOrderEntryModel> copyEntries = copy.getEntries();

		final int copyEntriesSize = copyEntries == null ? 0 : copyEntries.size();

		if (originalEntries.size() != copyEntriesSize)
		{
			throw new IllegalStateException(
					"different entry numbers in original and copied order ( " + originalEntries.size() + "<>" + copyEntriesSize + ")");
		}

		normalizeEntriesNumbers(originalEntries);

		for (int i = 0; i < copyEntriesSize; i++)
		{
			final AbstractOrderEntryModel originalEntry = originalEntries.get(i);
			final AbstractOrderEntryModel copyEntry = copyEntries.get(i);
			copyEntry.setCalculated(originalEntry.getCalculated());
		}
	}

	protected static void normalizeEntriesNumbers(final List<AbstractOrderEntryModel> allEntries)
	{
		for (int i = 0; i < allEntries.size(); i++)
		{
			final AbstractOrderEntryModel oEntry = allEntries.get(i);
			oEntry.setEntryNumber(Integer.valueOf(i));
		}
	}

	/**
	 * CopyContext extension to account for order entries and skipped attributes in this document context
	 */
	public static class OrderCopyContext extends CopyContext
	{
		private final ComposedTypeModel entryType;
		private final Set<String> skippedAttributes;

		public OrderCopyContext(final ComposedTypeModel entryType, final Set<String> skippedAttributes)
		{
			this.entryType = entryType;
			this.skippedAttributes = skippedAttributes;
		}

		@Override
		public ComposedTypeModel getTargetType(final ItemModel originalModel)
		{
			if (originalModel instanceof AbstractOrderEntryModel)
			{
				return entryType;
			}
			return super.getTargetType(originalModel);
		}

		@Override
		protected boolean skipAttribute(final Object original, final String qualifier)
		{
			if (skippedAttributes.contains(qualifier))
			{
				return true;
			}
			else
			{
				return super.skipAttribute(original, qualifier);
			}
		}
	}

}
