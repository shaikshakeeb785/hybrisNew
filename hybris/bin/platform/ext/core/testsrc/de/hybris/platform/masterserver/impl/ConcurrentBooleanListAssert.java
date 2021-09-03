/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.masterserver.impl;

import java.util.List;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;


/**
 * Helpful for check the amount of true and false elements in a list
 */
public class ConcurrentBooleanListAssert extends GenericAssert<ConcurrentBooleanListAssert, List<Boolean>>
{
	public ConcurrentBooleanListAssert(final List<Boolean> actual)
	{
		super(ConcurrentBooleanListAssert.class, actual);
	}

	public static ConcurrentBooleanListAssert assertThat(final List<Boolean> actual)
	{
		return new ConcurrentBooleanListAssert(actual);
	}

	public ConcurrentBooleanListAssert hasNumberOfTrueElements(final int elementsCount)
	{
		int trueElementsCount = 0;
		for (int i = 0; i < actual.size(); i++)
		{
			if (Boolean.TRUE.equals(actual.get(i)))
			{
				trueElementsCount++;
			}
		}
		Assertions.assertThat(trueElementsCount).isEqualTo(elementsCount);
		return this;
	}

	public ConcurrentBooleanListAssert hasNumberOfFalseElements(final int elementsCount)
	{
		int falseElementsCount = 0;
		for (int i = 0; i < actual.size(); i++)
		{
			if (Boolean.FALSE.equals(actual.get(i)))
			{
				falseElementsCount++;
			}
		}
		Assertions.assertThat(falseElementsCount).isEqualTo(elementsCount);
		return this;
	}
}
