/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jul 14, 2021, 3:42:56 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorservices.jalo.promotions;

import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.promotions.jalo.ProductMultiBuyPromotion;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.acceleratorservices.jalo.promotions.AcceleratorProductMultiBuyPromotion AcceleratorProductMultiBuyPromotion}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedAcceleratorProductMultiBuyPromotion extends ProductMultiBuyPromotion
{
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(ProductMultiBuyPromotion.DEFAULT_INITIAL_ATTRIBUTES);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
}
