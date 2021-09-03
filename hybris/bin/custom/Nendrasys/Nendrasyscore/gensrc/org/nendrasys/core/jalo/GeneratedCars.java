/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jul 14, 2021, 3:42:56 PM                    ---
 * ----------------------------------------------------------------
 */
package org.nendrasys.core.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.nendrasys.core.constants.NendrasysCoreConstants;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem Cars}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedCars extends GenericItem
{
	/** Qualifier of the <code>Cars.color</code> attribute **/
	public static final String COLOR = "color";
	/** Qualifier of the <code>Cars.price</code> attribute **/
	public static final String PRICE = "price";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(COLOR, AttributeMode.INITIAL);
		tmp.put(PRICE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cars.color</code> attribute.
	 * @return the color - it mention the feed back
	 */
	public String getColor(final SessionContext ctx)
	{
		return (String)getProperty( ctx, COLOR);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cars.color</code> attribute.
	 * @return the color - it mention the feed back
	 */
	public String getColor()
	{
		return getColor( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Cars.color</code> attribute. 
	 * @param value the color - it mention the feed back
	 */
	public void setColor(final SessionContext ctx, final String value)
	{
		setProperty(ctx, COLOR,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Cars.color</code> attribute. 
	 * @param value the color - it mention the feed back
	 */
	public void setColor(final String value)
	{
		setColor( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cars.price</code> attribute.
	 * @return the price - it mention the feed back
	 */
	public String getPrice(final SessionContext ctx)
	{
		return (String)getProperty( ctx, PRICE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Cars.price</code> attribute.
	 * @return the price - it mention the feed back
	 */
	public String getPrice()
	{
		return getPrice( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Cars.price</code> attribute. 
	 * @param value the price - it mention the feed back
	 */
	public void setPrice(final SessionContext ctx, final String value)
	{
		setProperty(ctx, PRICE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Cars.price</code> attribute. 
	 * @param value the price - it mention the feed back
	 */
	public void setPrice(final String value)
	{
		setPrice( getSession().getSessionContext(), value );
	}
	
}
