/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.tx;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.UnitTest;

import org.junit.Test;


@UnitTest
public class LocalCacheKeyUnitTest
{
	final LocalCacheKey singlePathKey = LocalCacheKey.create(new Object[]
			{ "single key" });
	final LocalCacheKey multiPathKey = LocalCacheKey.create(new Object[]
			{ new Object[]
					{ "multi", "key" } });
	final LocalCacheKey singlePathKeyDuplicate = LocalCacheKey.create(new Object[]
			{ "single key" });
	final LocalCacheKey multiPathKeyDuplicate = LocalCacheKey.create(new Object[]
			{ new Object[]
					{ "multi", "key" } });
	final LocalCacheKey otherSinglePathKey = LocalCacheKey.create(new Object[]
			{ "other single key" });
	final LocalCacheKey otherMultiPathKey = LocalCacheKey.create(new Object[]
			{ new Object[]
					{ "other", "key" } });

	@Test
	public void test()
	{
		assertThat(singlePathKey).isEqualTo(singlePathKey);
		assertThat(multiPathKey).isEqualTo(multiPathKey);

		assertThat(singlePathKey).isEqualTo(singlePathKeyDuplicate);
		assertThat(multiPathKey).isEqualTo(multiPathKeyDuplicate);

		assertThat(singlePathKey).isNotEqualTo(otherSinglePathKey);
		assertThat(otherSinglePathKey).isNotEqualTo(singlePathKey);

		assertThat(multiPathKey).isNotEqualTo(otherMultiPathKey);
		assertThat(otherMultiPathKey).isNotEqualTo(multiPathKey);

		assertThat(singlePathKey).isNotEqualTo(multiPathKey);
		assertThat(multiPathKey).isNotEqualTo(singlePathKey);
	}

}
