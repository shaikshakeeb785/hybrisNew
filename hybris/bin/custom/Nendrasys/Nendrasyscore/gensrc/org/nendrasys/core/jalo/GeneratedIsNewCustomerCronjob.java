/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jul 14, 2021, 3:42:56 PM                    ---
 * ----------------------------------------------------------------
 */
package org.nendrasys.core.jalo;

import de.hybris.platform.cronjob.jalo.CronJob;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.nendrasys.core.constants.NendrasysCoreConstants;

/**
 * Generated class for type {@link de.hybris.platform.cronjob.jalo.CronJob IsNewCustomerCronjob}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedIsNewCustomerCronjob extends CronJob
{
	/** Qualifier of the <code>IsNewCustomerCronjob.xDaysOld</code> attribute **/
	public static final String XDAYSOLD = "xDaysOld";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(CronJob.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(XDAYSOLD, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IsNewCustomerCronjob.xDaysOld</code> attribute.
	 * @return the xDaysOld - All the customer which is within this days that customer is new we have to do
	 *                             IsNewCustomer is true
	 */
	public Integer getXDaysOld(final SessionContext ctx)
	{
		return (Integer)getProperty( ctx, XDAYSOLD);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IsNewCustomerCronjob.xDaysOld</code> attribute.
	 * @return the xDaysOld - All the customer which is within this days that customer is new we have to do
	 *                             IsNewCustomer is true
	 */
	public Integer getXDaysOld()
	{
		return getXDaysOld( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IsNewCustomerCronjob.xDaysOld</code> attribute. 
	 * @return the xDaysOld - All the customer which is within this days that customer is new we have to do
	 *                             IsNewCustomer is true
	 */
	public int getXDaysOldAsPrimitive(final SessionContext ctx)
	{
		Integer value = getXDaysOld( ctx );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>IsNewCustomerCronjob.xDaysOld</code> attribute. 
	 * @return the xDaysOld - All the customer which is within this days that customer is new we have to do
	 *                             IsNewCustomer is true
	 */
	public int getXDaysOldAsPrimitive()
	{
		return getXDaysOldAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IsNewCustomerCronjob.xDaysOld</code> attribute. 
	 * @param value the xDaysOld - All the customer which is within this days that customer is new we have to do
	 *                             IsNewCustomer is true
	 */
	public void setXDaysOld(final SessionContext ctx, final Integer value)
	{
		setProperty(ctx, XDAYSOLD,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IsNewCustomerCronjob.xDaysOld</code> attribute. 
	 * @param value the xDaysOld - All the customer which is within this days that customer is new we have to do
	 *                             IsNewCustomer is true
	 */
	public void setXDaysOld(final Integer value)
	{
		setXDaysOld( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IsNewCustomerCronjob.xDaysOld</code> attribute. 
	 * @param value the xDaysOld - All the customer which is within this days that customer is new we have to do
	 *                             IsNewCustomer is true
	 */
	public void setXDaysOld(final SessionContext ctx, final int value)
	{
		setXDaysOld( ctx,Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>IsNewCustomerCronjob.xDaysOld</code> attribute. 
	 * @param value the xDaysOld - All the customer which is within this days that customer is new we have to do
	 *                             IsNewCustomer is true
	 */
	public void setXDaysOld(final int value)
	{
		setXDaysOld( getSession().getSessionContext(), value );
	}
	
}
