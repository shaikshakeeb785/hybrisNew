/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.audit.provider.impl;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.util.persistence.PersistenceUtils;

import org.junit.Before;


@IntegrationTest
public class DefaultAuditRecordsProviderJaloTest extends DefaultAuditRecordsProviderTest
{
	@Before
	@Override
	public void setUp() throws Exception
	{
		super.setUp();
		switchPersitenceLegacyMode(true);
		assertThat(PersistenceUtils.isPersistenceLegacyModeEnabled()).isTrue();
	}
}
