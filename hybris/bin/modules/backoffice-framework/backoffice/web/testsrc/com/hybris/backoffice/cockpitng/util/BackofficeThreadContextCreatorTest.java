/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved
 */
package com.hybris.backoffice.cockpitng.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.hybris.backoffice.user.BackofficeRoleService;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.CatalogVersionService;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.i18n.I18NService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.util.MediaUtil;

import java.util.Optional;
import java.util.concurrent.Semaphore;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import com.hybris.cockpitng.modules.core.impl.CockpitModuleComponentDefinitionService;


@IntegrationTest
public class BackofficeThreadContextCreatorTest extends ServicelayerTransactionalTest
{

	private static final String BACKOFFICE_ROLE = "backofficeRole";

	@Spy
	@InjectMocks
	private BackofficeThreadContextCreator creator;

	@Mock
	private CatalogVersionService catalogVersionService;

	@Mock
	private UserService userService;

	@Mock
	private I18NService i18nService;

	@Mock
	private CockpitModuleComponentDefinitionService componentDefinitionService;

	@Mock
	private BackofficeRoleService backofficeRoleService;

	@Before
	public void setUp()
	{
		initMocks(this);
		doReturn(null).when(creator).createRequestAttributesCopy();
		when(backofficeRoleService.getActiveRole()).thenReturn(Optional.of(BACKOFFICE_ROLE));
	}

	@Test
	public void verifyThreadLocalMediaRenderersCopiedFromOriginalThread() throws InterruptedException
	{
		// given
		final Semaphore executorLock = new Semaphore(0);
		final Semaphore threadLocalLock = new Semaphore(0);

		final MediaUtil.PublicMediaURLRenderer publicRendererOriginal = mock(MediaUtil.PublicMediaURLRenderer.class);
		final MediaUtil.SecureMediaURLRenderer secureRendererOriginal = mock(MediaUtil.SecureMediaURLRenderer.class);

		MediaUtil.setCurrentPublicMediaURLRenderer(publicRendererOriginal);
		MediaUtil.setCurrentSecureMediaURLRenderer(secureRendererOriginal);
		MediaUtil.setCurrentRequestSSLModeEnabled(true);

		// when
		creator.execute(() -> {
			try
			{
				threadLocalLock.acquire();

				// then
				final MediaUtil.PublicMediaURLRenderer publicRenderer = MediaUtil.getCurrentPublicMediaURLRenderer();
				final MediaUtil.SecureMediaURLRenderer secureRenderer = MediaUtil.getCurrentSecureMediaURLRenderer();
				final boolean sslEnabled = MediaUtil.isCurrentRequestSSLModeEnabled();

				assertThat(sslEnabled).isTrue();
				assertThat(publicRenderer).isSameAs(publicRendererOriginal);
				assertThat(secureRenderer).isSameAs(secureRendererOriginal);

				executorLock.release();
			}
			catch (final InterruptedException e)
			{
				throw new IllegalStateException(e);
			}
		});
		MediaUtil.unsetCurrentPublicMediaURLRenderer();
		MediaUtil.unsetCurrentSecureMediaURLRenderer();
		MediaUtil.setCurrentRequestSSLModeEnabled(false);
		threadLocalLock.release();
		executorLock.acquire();
	}

	@Test
	public void verifyBackofficeRoleCopiedFromOriginalThread() throws InterruptedException
	{
		// given
		final Semaphore executorLock = new Semaphore(0);
		final Semaphore threadLocalLock = new Semaphore(0);

		// when
		creator.execute(() -> {
			try
			{
				threadLocalLock.acquire();

				// then
				final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
				verify(backofficeRoleService).setActiveRole(captor.capture());
				assertThat(captor.getValue()).isEqualTo(BACKOFFICE_ROLE);

				executorLock.release();
			}
			catch (final InterruptedException e)
			{
				throw new IllegalStateException(e);
			}
		});
		threadLocalLock.release();
		executorLock.acquire();
	}
}
