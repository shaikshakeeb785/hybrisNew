/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jul 14, 2021, 3:42:56 PM                    ---
 * ----------------------------------------------------------------
 */
package org.nendrasys.core.jalo;

import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.variants.jalo.VariantProduct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.nendrasys.core.constants.NendrasysCoreConstants;

/**
 * Generated class for type {@link org.nendrasys.core.jalo.Furniture Furniture}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedFurniture extends VariantProduct
{
	/** Qualifier of the <code>Furniture.color</code> attribute **/
	public static final String COLOR = "color";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(VariantProduct.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(COLOR, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Furniture.color</code> attribute.
	 * @return the color - Color of the Furniture.
	 */
	public String getColor(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedFurniture.getColor requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, COLOR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Furniture.color</code> attribute.
	 * @return the color - Color of the Furniture.
	 */
	public String getColor()
	{
		return getColor( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Furniture.color</code> attribute. 
	 * @return the localized color - Color of the Furniture.
	 */
	public Map<Language,String> getAllColor(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,COLOR,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Furniture.color</code> attribute. 
	 * @return the localized color - Color of the Furniture.
	 */
	public Map<Language,String> getAllColor()
	{
		return getAllColor( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Furniture.color</code> attribute. 
	 * @param value the color - Color of the Furniture.
	 */
	public void setColor(final SessionContext ctx, final String value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		if( ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedFurniture.setColor requires a session language", 0 );
		}
		setLocalizedProperty(ctx, COLOR,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Furniture.color</code> attribute. 
	 * @param value the color - Color of the Furniture.
	 */
	public void setColor(final String value)
	{
		setColor( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Furniture.color</code> attribute. 
	 * @param value the color - Color of the Furniture.
	 */
	public void setAllColor(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,COLOR,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Furniture.color</code> attribute. 
	 * @param value the color - Color of the Furniture.
	 */
	public void setAllColor(final Map<Language,String> value)
	{
		setAllColor( getSession().getSessionContext(), value );
	}
	
}
