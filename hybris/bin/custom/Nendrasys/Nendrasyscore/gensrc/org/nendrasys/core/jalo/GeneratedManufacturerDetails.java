/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jul 14, 2021, 3:42:56 PM                    ---
 * ----------------------------------------------------------------
 */
package org.nendrasys.core.jalo;

import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.Country;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.TypeManager;
import de.hybris.platform.jalo.user.Address;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nendrasys.core.constants.NendrasysCoreConstants;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem ManufacturerDetails}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedManufacturerDetails extends GenericItem
{
	/** Qualifier of the <code>ManufacturerDetails.id</code> attribute **/
	public static final String ID = "id";
	/** Qualifier of the <code>ManufacturerDetails.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>ManufacturerDetails.city</code> attribute **/
	public static final String CITY = "city";
	/** Qualifier of the <code>ManufacturerDetails.country</code> attribute **/
	public static final String COUNTRY = "country";
	/** Qualifier of the <code>ManufacturerDetails.userAddressMap</code> attribute **/
	public static final String USERADDRESSMAP = "userAddressMap";
	/** Qualifier of the <code>ManufacturerDetails.product</code> attribute **/
	public static final String PRODUCT = "product";
	/** Relation ordering override parameter constants for ManufacturerToProduct from ((Nendrasyscore))*/
	protected static String MANUFACTURERTOPRODUCT_SRC_ORDERED = "relation.ManufacturerToProduct.source.ordered";
	protected static String MANUFACTURERTOPRODUCT_TGT_ORDERED = "relation.ManufacturerToProduct.target.ordered";
	/** Relation disable markmodifed parameter constants for ManufacturerToProduct from ((Nendrasyscore))*/
	protected static String MANUFACTURERTOPRODUCT_MARKMODIFIED = "relation.ManufacturerToProduct.markmodified";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(ID, AttributeMode.INITIAL);
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(CITY, AttributeMode.INITIAL);
		tmp.put(COUNTRY, AttributeMode.INITIAL);
		tmp.put(USERADDRESSMAP, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.city</code> attribute.
	 * @return the city
	 */
	public String getCity(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CITY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.city</code> attribute.
	 * @return the city
	 */
	public String getCity()
	{
		return getCity( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.city</code> attribute. 
	 * @param value the city
	 */
	public void setCity(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CITY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.city</code> attribute. 
	 * @param value the city
	 */
	public void setCity(final String value)
	{
		setCity( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.country</code> attribute.
	 * @return the country
	 */
	public Country getCountry(final SessionContext ctx)
	{
		return (Country)getProperty( ctx, COUNTRY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.country</code> attribute.
	 * @return the country
	 */
	public Country getCountry()
	{
		return getCountry( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.country</code> attribute. 
	 * @param value the country
	 */
	public void setCountry(final SessionContext ctx, final Country value)
	{
		setProperty(ctx, COUNTRY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.country</code> attribute. 
	 * @param value the country
	 */
	public void setCountry(final Country value)
	{
		setCountry( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.id</code> attribute.
	 * @return the id
	 */
	public String getId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.id</code> attribute.
	 * @return the id
	 */
	public String getId()
	{
		return getId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.id</code> attribute. 
	 * @param value the id
	 */
	public void setId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.id</code> attribute. 
	 * @param value the id
	 */
	public void setId(final String value)
	{
		setId( getSession().getSessionContext(), value );
	}
	
	/**
	 * @deprecated since 2105, use {@link Utilities#getMarkModifiedOverride(de.hybris.platform.jalo.type.RelationType)
	 */
	@Override
	@Deprecated(since = "2105", forRemoval = true)
	public boolean isMarkModifiedDisabled(final Item referencedItem)
	{
		ComposedType relationSecondEnd0 = TypeManager.getInstance().getComposedType("Product");
		if(relationSecondEnd0.isAssignableFrom(referencedItem.getComposedType()))
		{
			return Utilities.getMarkModifiedOverride(MANUFACTURERTOPRODUCT_MARKMODIFIED);
		}
		return true;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.name</code> attribute.
	 * @return the name
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.name</code> attribute.
	 * @return the name
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.name</code> attribute. 
	 * @param value the name
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.product</code> attribute.
	 * @return the product
	 */
	public Collection<Product> getProduct(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedManufacturerDetails.getProduct requires a session language", 0 );
		}
		final List<Product> items = getLinkedItems( 
			ctx,
			true,
			NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT,
			"Product",
			ctx.getLanguage(),
			false,
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.product</code> attribute.
	 * @return the product
	 */
	public Collection<Product> getProduct()
	{
		return getProduct( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.product</code> attribute. 
	 * @return the localized product
	 */
	public Map<Language,Collection<Product>> getAllProduct(final SessionContext ctx)
	{
		Map<Language,Collection<Product>> values = getAllLinkedItems( 
			true,
			NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT
		);
		return values;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.product</code> attribute. 
	 * @return the localized product
	 */
	public Map<Language,Collection<Product>> getAllProduct()
	{
		return getAllProduct( getSession().getSessionContext() );
	}
	
	public long getProductCount(final SessionContext ctx, final Language lang)
	{
		return getLinkedItemsCount(
			ctx,
			true,
			NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT,
			"Product",
			lang
		);
	}
	
	public long getProductCount(final Language lang)
	{
		return getProductCount( getSession().getSessionContext(),lang );
	}
	
	public long getProductCount(final SessionContext ctx)
	{
		return getProductCount( ctx, ctx.getLanguage() );
	}
	
	public long getProductCount()
	{
		return getProductCount( getSession().getSessionContext(), getSession().getSessionContext().getLanguage() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.product</code> attribute. 
	 * @param value the product
	 */
	public void setProduct(final SessionContext ctx, final Collection<Product> value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		if( ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedManufacturerDetails.setProduct requires a session language", 0 );
		}
		setLinkedItems( 
			ctx,
			true,
			NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT,
			ctx.getLanguage(),
			value,
			false,
			false,
			Utilities.getMarkModifiedOverride(MANUFACTURERTOPRODUCT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.product</code> attribute. 
	 * @param value the product
	 */
	public void setProduct(final Collection<Product> value)
	{
		setProduct( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.product</code> attribute. 
	 * @param value the product
	 */
	public void setAllProduct(final SessionContext ctx, final Map<Language,Collection<Product>> value)
	{
		setAllLinkedItems( 
			getAllValuesSessionContext(ctx),
			true,
			NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT,
			value
		);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.product</code> attribute. 
	 * @param value the product
	 */
	public void setAllProduct(final Map<Language,Collection<Product>> value)
	{
		setAllProduct( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to product. 
	 * @param value the item to add to product
	 */
	public void addToProduct(final SessionContext ctx, final Language lang, final Product value)
	{
		if( lang == null )
		{
			throw new JaloInvalidParameterException("GeneratedManufacturerDetails.addToProduct requires a language language", 0 );
		}
		addLinkedItems( 
			ctx,
			true,
			NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT,
			lang,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(MANUFACTURERTOPRODUCT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to product. 
	 * @param value the item to add to product
	 */
	public void addToProduct(final Language lang, final Product value)
	{
		addToProduct( getSession().getSessionContext(), lang, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from product. 
	 * @param value the item to remove from product
	 */
	public void removeFromProduct(final SessionContext ctx, final Language lang, final Product value)
	{
		if( lang == null )
		{
			throw new JaloInvalidParameterException("GeneratedManufacturerDetails.removeFromProduct requires a session language", 0 );
		}
		removeLinkedItems( 
			ctx,
			true,
			NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT,
			lang,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(MANUFACTURERTOPRODUCT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from product. 
	 * @param value the item to remove from product
	 */
	public void removeFromProduct(final Language lang, final Product value)
	{
		removeFromProduct( getSession().getSessionContext(), lang, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.userAddressMap</code> attribute.
	 * @return the userAddressMap
	 */
	public Map<String,Address> getAllUserAddressMap(final SessionContext ctx)
	{
		Map<String,Address> map = (Map<String,Address>)getProperty( ctx, USERADDRESSMAP);
		return map != null ? map : Collections.EMPTY_MAP;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufacturerDetails.userAddressMap</code> attribute.
	 * @return the userAddressMap
	 */
	public Map<String,Address> getAllUserAddressMap()
	{
		return getAllUserAddressMap( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.userAddressMap</code> attribute. 
	 * @param value the userAddressMap
	 */
	public void setAllUserAddressMap(final SessionContext ctx, final Map<String,Address> value)
	{
		setProperty(ctx, USERADDRESSMAP,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufacturerDetails.userAddressMap</code> attribute. 
	 * @param value the userAddressMap
	 */
	public void setAllUserAddressMap(final Map<String,Address> value)
	{
		setAllUserAddressMap( getSession().getSessionContext(), value );
	}
	
}
