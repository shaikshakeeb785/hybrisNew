/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.configurablebundleservices.interceptor.impl;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.keygenerator.KeyGenerator;
import de.hybris.platform.configurablebundleservices.model.BundleTemplateStatusModel;

import org.apache.commons.lang.StringUtils;

import org.springframework.beans.factory.annotation.Required;


/**
 * Create a unique id for new {@link BundleTemplateStatusModel}s if not yet set
 */
public class BundleTemplateStatusIDPrepareInterceptor implements PrepareInterceptor
{

	private KeyGenerator bundleTemplateStatusIDGenerator;

	@Override
	public void onPrepare(final Object model, final InterceptorContext ctx) throws InterceptorException
	{

		if (model instanceof BundleTemplateStatusModel)
		{
			final BundleTemplateStatusModel bundleStatus = (BundleTemplateStatusModel) model;
			final String id = bundleStatus.getId();
			if (StringUtils.isEmpty(id))
			{
				bundleStatus.setId((String) this.bundleTemplateStatusIDGenerator.generate());
			}
		}
	}

	@Required
	public void setBundleTemplateStatusIDGenerator(final KeyGenerator bundleTemplateStatusIDGenerator)
	{
		this.bundleTemplateStatusIDGenerator = bundleTemplateStatusIDGenerator;
	}



}
