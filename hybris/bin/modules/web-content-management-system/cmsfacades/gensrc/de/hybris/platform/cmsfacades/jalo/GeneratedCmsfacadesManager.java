/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jul 14, 2021, 3:42:56 PM                    ---
 * ----------------------------------------------------------------
 *  
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.cmsfacades.jalo;

import de.hybris.platform.cmsfacades.constants.CmsfacadesConstants;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.extension.Extension;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type <code>CmsfacadesManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedCmsfacadesManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	@Override
	public String getName()
	{
		return CmsfacadesConstants.EXTENSIONNAME;
	}
	
}
