/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jul 14, 2021, 3:42:56 PM                    ---
 * ----------------------------------------------------------------
 */
package org.nendrasys.core.jalo;

import de.hybris.platform.cms2.jalo.contents.components.SimpleCMSComponent;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.nendrasys.core.constants.NendrasysCoreConstants;

/**
 * Generated class for type {@link org.nendrasys.core.jalo.LatestProductComponent LatestProductComponent}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedLatestProductComponent extends SimpleCMSComponent
{
	/** Qualifier of the <code>LatestProductComponent.numberOfProduct</code> attribute **/
	public static final String NUMBEROFPRODUCT = "numberOfProduct";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(SimpleCMSComponent.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(NUMBEROFPRODUCT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LatestProductComponent.numberOfProduct</code> attribute.
	 * @return the numberOfProduct - Top 10 latest product
	 */
	public Integer getNumberOfProduct(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, NUMBEROFPRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LatestProductComponent.numberOfProduct</code> attribute.
	 * @return the numberOfProduct - Top 10 latest product
	 */
	public Integer getNumberOfProduct()
	{
		return getNumberOfProduct( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LatestProductComponent.numberOfProduct</code> attribute. 
	 * @return the numberOfProduct - Top 10 latest product
	 */
	public int getNumberOfProductAsPrimitive(final SessionContext ctx)
	{
		Integer value = getNumberOfProduct( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>LatestProductComponent.numberOfProduct</code> attribute. 
	 * @return the numberOfProduct - Top 10 latest product
	 */
	public int getNumberOfProductAsPrimitive()
	{
		return getNumberOfProductAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LatestProductComponent.numberOfProduct</code> attribute. 
	 * @param value the numberOfProduct - Top 10 latest product
	 */
	public void setNumberOfProduct(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, NUMBEROFPRODUCT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LatestProductComponent.numberOfProduct</code> attribute. 
	 * @param value the numberOfProduct - Top 10 latest product
	 */
	public void setNumberOfProduct(final Integer value)
	{
		setNumberOfProduct( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LatestProductComponent.numberOfProduct</code> attribute. 
	 * @param value the numberOfProduct - Top 10 latest product
	 */
	public void setNumberOfProduct(final SessionContext ctx, final int value)
	{
		setNumberOfProduct( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>LatestProductComponent.numberOfProduct</code> attribute. 
	 * @param value the numberOfProduct - Top 10 latest product
	 */
	public void setNumberOfProduct(final int value)
	{
		setNumberOfProduct( getSession().getSessionContext(), value );
	}
	
}
