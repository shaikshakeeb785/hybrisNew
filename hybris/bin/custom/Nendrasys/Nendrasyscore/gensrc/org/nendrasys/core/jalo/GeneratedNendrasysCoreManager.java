/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Jul 14, 2021, 3:42:56 PM                    ---
 * ----------------------------------------------------------------
 */
package org.nendrasys.core.jalo;

import de.hybris.platform.jalo.ConsistencyCheckException;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.Language;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.link.Link;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.util.PartOfHandler;
import de.hybris.platform.util.Utilities;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nendrasys.core.constants.NendrasysCoreConstants;
import org.nendrasys.core.jalo.ApparelProduct;
import org.nendrasys.core.jalo.ApparelSizeVariantProduct;
import org.nendrasys.core.jalo.ApparelStyleVariantProduct;
import org.nendrasys.core.jalo.Cars;
import org.nendrasys.core.jalo.ElectronicsColorVariantProduct;
import org.nendrasys.core.jalo.Furniture;
import org.nendrasys.core.jalo.IsNewCustomerCronjob;
import org.nendrasys.core.jalo.LatestProductComponent;
import org.nendrasys.core.jalo.ManufacturerDetails;
import org.nendrasys.core.jalo.ManufacturerDetailsAudit;

/**
 * Generated class for type <code>NendrasysCoreManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedNendrasysCoreManager extends Extension
{
	/** Relation ordering override parameter constants for ManufacturerToProduct from ((Nendrasyscore))*/
	protected static String MANUFACTURERTOPRODUCT_SRC_ORDERED = "relation.ManufacturerToProduct.source.ordered";
	protected static String MANUFACTURERTOPRODUCT_TGT_ORDERED = "relation.ManufacturerToProduct.target.ordered";
	/** Relation disable markmodifed parameter constants for ManufacturerToProduct from ((Nendrasyscore))*/
	protected static String MANUFACTURERTOPRODUCT_MARKMODIFIED = "relation.ManufacturerToProduct.markmodified";
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("newBusinessUser", AttributeMode.INITIAL);
		tmp.put("isNewCustomer", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Customer", Collections.unmodifiableMap(tmp));
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
	
	public ApparelProduct createApparelProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.APPARELPRODUCT );
			return (ApparelProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelProduct createApparelProduct(final Map attributeValues)
	{
		return createApparelProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.APPARELSIZEVARIANTPRODUCT );
			return (ApparelSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final Map attributeValues)
	{
		return createApparelSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.APPARELSTYLEVARIANTPRODUCT );
			return (ApparelStyleVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelStyleVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final Map attributeValues)
	{
		return createApparelStyleVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public Cars createCars(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.CARS );
			return (Cars)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Cars : "+e.getMessage(), 0 );
		}
	}
	
	public Cars createCars(final Map attributeValues)
	{
		return createCars( getSession().getSessionContext(), attributeValues );
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.ELECTRONICSCOLORVARIANTPRODUCT );
			return (ElectronicsColorVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ElectronicsColorVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final Map attributeValues)
	{
		return createElectronicsColorVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public Furniture createFurniture(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.FURNITURE );
			return (Furniture)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating Furniture : "+e.getMessage(), 0 );
		}
	}
	
	public Furniture createFurniture(final Map attributeValues)
	{
		return createFurniture( getSession().getSessionContext(), attributeValues );
	}
	
	public IsNewCustomerCronjob createIsNewCustomerCronjob(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.ISNEWCUSTOMERCRONJOB );
			return (IsNewCustomerCronjob)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating IsNewCustomerCronjob : "+e.getMessage(), 0 );
		}
	}
	
	public IsNewCustomerCronjob createIsNewCustomerCronjob(final Map attributeValues)
	{
		return createIsNewCustomerCronjob( getSession().getSessionContext(), attributeValues );
	}
	
	public LatestProductComponent createLatestProductComponent(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.LATESTPRODUCTCOMPONENT );
			return (LatestProductComponent)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating LatestProductComponent : "+e.getMessage(), 0 );
		}
	}
	
	public LatestProductComponent createLatestProductComponent(final Map attributeValues)
	{
		return createLatestProductComponent( getSession().getSessionContext(), attributeValues );
	}
	
	public ManufacturerDetails createManufacturerDetails(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.MANUFACTURERDETAILS );
			return (ManufacturerDetails)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ManufacturerDetails : "+e.getMessage(), 0 );
		}
	}
	
	public ManufacturerDetails createManufacturerDetails(final Map attributeValues)
	{
		return createManufacturerDetails( getSession().getSessionContext(), attributeValues );
	}
	
	public ManufacturerDetailsAudit createManufacturerDetailsAudit(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( NendrasysCoreConstants.TC.MANUFACTURERDETAILSAUDIT );
			return (ManufacturerDetailsAudit)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ManufacturerDetailsAudit : "+e.getMessage(), 0 );
		}
	}
	
	public ManufacturerDetailsAudit createManufacturerDetailsAudit(final Map attributeValues)
	{
		return createManufacturerDetailsAudit( getSession().getSessionContext(), attributeValues );
	}
	
	@Override
	public String getName()
	{
		return NendrasysCoreConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.isNewCustomer</code> attribute.
	 * @return the isNewCustomer - user is new newBusinessUser
	 */
	public Boolean isIsNewCustomer(final SessionContext ctx, final Customer item)
	{
		return (Boolean)item.getProperty( ctx, NendrasysCoreConstants.Attributes.Customer.ISNEWCUSTOMER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.isNewCustomer</code> attribute.
	 * @return the isNewCustomer - user is new newBusinessUser
	 */
	public Boolean isIsNewCustomer(final Customer item)
	{
		return isIsNewCustomer( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.isNewCustomer</code> attribute. 
	 * @return the isNewCustomer - user is new newBusinessUser
	 */
	public boolean isIsNewCustomerAsPrimitive(final SessionContext ctx, final Customer item)
	{
		Boolean value = isIsNewCustomer( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.isNewCustomer</code> attribute. 
	 * @return the isNewCustomer - user is new newBusinessUser
	 */
	public boolean isIsNewCustomerAsPrimitive(final Customer item)
	{
		return isIsNewCustomerAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.isNewCustomer</code> attribute. 
	 * @param value the isNewCustomer - user is new newBusinessUser
	 */
	public void setIsNewCustomer(final SessionContext ctx, final Customer item, final Boolean value)
	{
		item.setProperty(ctx, NendrasysCoreConstants.Attributes.Customer.ISNEWCUSTOMER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.isNewCustomer</code> attribute. 
	 * @param value the isNewCustomer - user is new newBusinessUser
	 */
	public void setIsNewCustomer(final Customer item, final Boolean value)
	{
		setIsNewCustomer( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.isNewCustomer</code> attribute. 
	 * @param value the isNewCustomer - user is new newBusinessUser
	 */
	public void setIsNewCustomer(final SessionContext ctx, final Customer item, final boolean value)
	{
		setIsNewCustomer( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.isNewCustomer</code> attribute. 
	 * @param value the isNewCustomer - user is new newBusinessUser
	 */
	public void setIsNewCustomer(final Customer item, final boolean value)
	{
		setIsNewCustomer( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.manufacturerDetails</code> attribute.
	 * @return the manufacturerDetails
	 */
	public Collection<ManufacturerDetails> getManufacturerDetails(final SessionContext ctx, final Product item)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.getManufacturerDetails requires a session language", 0 );
		}
		final List<ManufacturerDetails> items = item.getLinkedItems( 
			ctx,
			false,
			NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT,
			"ManufacturerDetails",
			ctx.getLanguage(),
			false,
			false
		);
		return items;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.manufacturerDetails</code> attribute.
	 * @return the manufacturerDetails
	 */
	public Collection<ManufacturerDetails> getManufacturerDetails(final Product item)
	{
		return getManufacturerDetails( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.manufacturerDetails</code> attribute. 
	 * @return the localized manufacturerDetails
	 */
	public Map<Language,Collection<ManufacturerDetails>> getAllManufacturerDetails(final SessionContext ctx, final Product item)
	{
		Map<Language,Collection<ManufacturerDetails>> values = item.getAllLinkedItems( 
			false,
			NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT
		);
		return values;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.manufacturerDetails</code> attribute. 
	 * @return the localized manufacturerDetails
	 */
	public Map<Language,Collection<ManufacturerDetails>> getAllManufacturerDetails(final Product item)
	{
		return getAllManufacturerDetails( getSession().getSessionContext(), item );
	}
	
	public long getManufacturerDetailsCount(final SessionContext ctx, final Product item, final Language lang)
	{
		return item.getLinkedItemsCount(
			ctx,
			false,
			NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT,
			"ManufacturerDetails",
			lang
		);
	}
	
	public long getManufacturerDetailsCount(final Product item, final Language lang)
	{
		return getManufacturerDetailsCount( getSession().getSessionContext(), item,lang );
	}
	
	public long getManufacturerDetailsCount(final SessionContext ctx, final Product item)
	{
		return getManufacturerDetailsCount( ctx, item, ctx.getLanguage() );
	}
	
	public long getManufacturerDetailsCount(final Product item)
	{
		return getManufacturerDetailsCount( getSession().getSessionContext(), item, getSession().getSessionContext().getLanguage() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.manufacturerDetails</code> attribute. 
	 * @param value the manufacturerDetails
	 */
	public void setManufacturerDetails(final SessionContext ctx, final Product item, final Collection<ManufacturerDetails> value)
	{
		new PartOfHandler<Collection<ManufacturerDetails>>()
		{
			@Override
			protected Collection<ManufacturerDetails> doGetValue(final SessionContext ctx)
			{
				return getManufacturerDetails( ctx, item );
			}
			@Override
			protected void doSetValue(final SessionContext ctx, final Collection<ManufacturerDetails> _value)
			{
				final Collection<ManufacturerDetails> value = _value;
				if ( ctx == null) 
				{
					throw new JaloInvalidParameterException( "ctx is null", 0 );
				}
				if( ctx.getLanguage() == null )
				{
					throw new JaloInvalidParameterException("GeneratedProduct.setManufacturerDetails requires a session language", 0 );
				}
				item.setLinkedItems( 
					ctx,
					false,
					NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT,
					ctx.getLanguage(),
					value,
					false,
					false,
					Utilities.getMarkModifiedOverride(MANUFACTURERTOPRODUCT_MARKMODIFIED)
				);
			}
		}.setValue( ctx, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.manufacturerDetails</code> attribute. 
	 * @param value the manufacturerDetails
	 */
	public void setManufacturerDetails(final Product item, final Collection<ManufacturerDetails> value)
	{
		setManufacturerDetails( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.manufacturerDetails</code> attribute. 
	 * @param value the manufacturerDetails
	 */
	public void setAllManufacturerDetails(final SessionContext ctx, final Product item, final Map<Language,Collection<ManufacturerDetails>> value)
	{
		new PartOfHandler<Map<Language,Collection<ManufacturerDetails>>>()
		{
			@Override
			protected Map<Language,Collection<ManufacturerDetails>> doGetValue(final SessionContext ctx)
			{
				return getAllManufacturerDetails( ctx, item );
			}
			@Override
			protected void doSetValue(final SessionContext ctx, final Map<Language,Collection<ManufacturerDetails>> _value)
			{
				final Map<Language,Collection<ManufacturerDetails>> value = _value;
				item.setAllLinkedItems( 
					getAllValuesSessionContext(ctx),
					false,
					NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT,
					value
				);
			}
		}.setValue( ctx, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.manufacturerDetails</code> attribute. 
	 * @param value the manufacturerDetails
	 */
	public void setAllManufacturerDetails(final Product item, final Map<Language,Collection<ManufacturerDetails>> value)
	{
		setAllManufacturerDetails( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to manufacturerDetails. 
	 * @param value the item to add to manufacturerDetails
	 */
	public void addToManufacturerDetails(final SessionContext ctx, final Product item, final Language lang, final ManufacturerDetails value)
	{
		if( lang == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.addToManufacturerDetails requires a language language", 0 );
		}
		item.addLinkedItems( 
			ctx,
			false,
			NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT,
			lang,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(MANUFACTURERTOPRODUCT_MARKMODIFIED)
		);
	}
	
	/**
	 * <i>Generated method</i> - Adds <code>value</code> to manufacturerDetails. 
	 * @param value the item to add to manufacturerDetails
	 */
	public void addToManufacturerDetails(final Product item, final Language lang, final ManufacturerDetails value)
	{
		addToManufacturerDetails( getSession().getSessionContext(), item, lang, value );
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from manufacturerDetails. 
	 * @param value the item to remove from manufacturerDetails
	 */
	public void removeFromManufacturerDetails(final SessionContext ctx, final Product item, final Language lang, final ManufacturerDetails value)
	{
		if( lang == null )
		{
			throw new JaloInvalidParameterException("GeneratedProduct.removeFromManufacturerDetails requires a session language", 0 );
		}
		item.removeLinkedItems( 
			ctx,
			false,
			NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT,
			lang,
			Collections.singletonList(value),
			false,
			false,
			Utilities.getMarkModifiedOverride(MANUFACTURERTOPRODUCT_MARKMODIFIED)
		);
		if( !item.getLinkedItems( ctx, false,NendrasysCoreConstants.Relations.MANUFACTURERTOPRODUCT,lang).contains( value ) )
		{
			try
			{
				value.remove( ctx );
			}
			catch( ConsistencyCheckException e )
			{
				throw new JaloSystemException(e);
			}
		}
	}
	
	/**
	 * <i>Generated method</i> - Removes <code>value</code> from manufacturerDetails. 
	 * @param value the item to remove from manufacturerDetails
	 */
	public void removeFromManufacturerDetails(final Product item, final Language lang, final ManufacturerDetails value)
	{
		removeFromManufacturerDetails( getSession().getSessionContext(), item, lang, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.newBusinessUser</code> attribute.
	 * @return the newBusinessUser - user is new newBusinessUser
	 */
	public Boolean isNewBusinessUser(final SessionContext ctx, final Customer item)
	{
		return (Boolean)item.getProperty( ctx, NendrasysCoreConstants.Attributes.Customer.NEWBUSINESSUSER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.newBusinessUser</code> attribute.
	 * @return the newBusinessUser - user is new newBusinessUser
	 */
	public Boolean isNewBusinessUser(final Customer item)
	{
		return isNewBusinessUser( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.newBusinessUser</code> attribute. 
	 * @return the newBusinessUser - user is new newBusinessUser
	 */
	public boolean isNewBusinessUserAsPrimitive(final SessionContext ctx, final Customer item)
	{
		Boolean value = isNewBusinessUser( ctx,item );
		return value != null ? value.booleanValue() : false;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.newBusinessUser</code> attribute. 
	 * @return the newBusinessUser - user is new newBusinessUser
	 */
	public boolean isNewBusinessUserAsPrimitive(final Customer item)
	{
		return isNewBusinessUserAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.newBusinessUser</code> attribute. 
	 * @param value the newBusinessUser - user is new newBusinessUser
	 */
	public void setNewBusinessUser(final SessionContext ctx, final Customer item, final Boolean value)
	{
		item.setProperty(ctx, NendrasysCoreConstants.Attributes.Customer.NEWBUSINESSUSER,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.newBusinessUser</code> attribute. 
	 * @param value the newBusinessUser - user is new newBusinessUser
	 */
	public void setNewBusinessUser(final Customer item, final Boolean value)
	{
		setNewBusinessUser( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.newBusinessUser</code> attribute. 
	 * @param value the newBusinessUser - user is new newBusinessUser
	 */
	public void setNewBusinessUser(final SessionContext ctx, final Customer item, final boolean value)
	{
		setNewBusinessUser( ctx, item, Boolean.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.newBusinessUser</code> attribute. 
	 * @param value the newBusinessUser - user is new newBusinessUser
	 */
	public void setNewBusinessUser(final Customer item, final boolean value)
	{
		setNewBusinessUser( getSession().getSessionContext(), item, value );
	}
	
}
