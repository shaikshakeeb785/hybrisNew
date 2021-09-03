/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.integrationbackoffice.dto;

import de.hybris.platform.core.model.type.AtomicTypeModel;
import de.hybris.platform.core.model.type.AttributeDescriptorModel;
import de.hybris.platform.core.model.type.CollectionTypeModel;
import de.hybris.platform.core.model.type.MapTypeModel;
import de.hybris.platform.core.model.type.TypeModel;

public class ListItemAttributeDTO extends AbstractListItemDTO
{
	private AttributeDescriptorModel attributeDescriptor;
	private TypeModel baseType;
	private TypeModel type;
	private ListItemStructureType structureType;
	private boolean isSupported;

	public ListItemAttributeDTO(final boolean selected, final boolean customUnique, final boolean autocreate,
	                            final AttributeDescriptorModel attributeDescriptor, final ListItemStructureType structureType,
	                            final String alias, final TypeModel type)
	{
		super(selected, customUnique, autocreate);
		this.attributeDescriptor = attributeDescriptor;
		this.structureType = structureType;
		final TypeModel attributeDescriptorType = findBaseType(attributeDescriptor, structureType);
		this.baseType = attributeDescriptorType;
		this.type = (type != null) ? type : attributeDescriptorType;
		this.alias = createAlias(alias);
		this.description = createDescription();
		this.isSupported = determineIsSupported();
	}

	private boolean determineIsSupported()
	{
		final AttributeDescriptorModel descriptor = this.getAttributeDescriptor();
		final boolean isMap = descriptor.getAttributeType() instanceof MapTypeModel;
		if (isMap)
		{
			final MapTypeModel mapTypeModel = (MapTypeModel) descriptor.getAttributeType();
			final Boolean localized = descriptor.getLocalized();
			final boolean isPrimitiveMap = mapTypeModel.getReturntype() instanceof AtomicTypeModel && mapTypeModel.getArgumentType() instanceof AtomicTypeModel;
			final boolean isLocalized = Boolean.TRUE.equals(localized) && mapTypeModel.getReturntype() instanceof AtomicTypeModel;
			return isPrimitiveMap || isLocalized;
		}
		else
		{
			return true;
		}
	}

	private TypeModel findBaseType(final AttributeDescriptorModel attributeDescriptor, final ListItemStructureType structureType)
	{
		TypeModel typeModel;
		if (structureType == ListItemStructureType.COLLECTION)
		{
			final CollectionTypeModel collectionType = (CollectionTypeModel) attributeDescriptor.getAttributeType();
			typeModel = collectionType.getElementType();
		}
		else if (structureType == ListItemStructureType.MAP)
		{
			typeModel = attributeDescriptor.getAttributeType();
			final MapTypeModel mapTypeModel = (MapTypeModel) attributeDescriptor.getAttributeType();
			if (mapTypeModel.getReturntype() instanceof CollectionTypeModel)
			{
				final CollectionTypeModel collectionTypeModel = (CollectionTypeModel) mapTypeModel.getReturntype();
				typeModel = collectionTypeModel.getElementType();
			}
		}
		else
		{
			typeModel = attributeDescriptor.getAttributeType();
		}
		return typeModel;
	}

	private String createAlias(final String alias)
	{
		return "".equals(alias) ? attributeDescriptor.getQualifier() : alias;
	}

	private String createDescription()
	{
		final String desc;
		if (structureType == ListItemStructureType.COLLECTION)
		{
			desc = String.format("Collection [%s]", type.getCode());
		}
		else if (structureType == ListItemStructureType.MAP)
		{
			desc = String.format("Map [%s]", type.getCode());
		}
		else
		{
			desc = type.getCode();
		}
		return desc;
	}

	public boolean isRequired()
	{
		return attributeDescriptor.getUnique() && !attributeDescriptor.getOptional();
	}

	public AttributeDescriptorModel getAttributeDescriptor()
	{
		return attributeDescriptor;
	}

	public TypeModel getBaseType()
	{
		return baseType;
	}

	public TypeModel getType()
	{
		return type;
	}

	public void setType(final TypeModel type)
	{
		this.type = type;
		this.description = createDescription();
	}

	public ListItemStructureType getStructureType()
	{
		return structureType;
	}

	@Override
	public void setAlias(final String alias)
	{
		this.alias = createAlias(alias);
	}

	public boolean isSupported()
	{
		return isSupported;
	}
}
