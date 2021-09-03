/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.enumeration;

import de.hybris.platform.core.HybrisEnumValue;


/**
 * ArticleApprovalStatusEnum - Stub
 */
public enum ArticleApprovalStatusEnumStub implements HybrisEnumValue
{

	/**
	 * enum value for ArticleApprovalStatus.check.
	 */
	CHECK("check"),
	/**
	 * enum value for ArticleApprovalStatus.approved.
	 */
	APPROVED("approved"),
	/**
	 * enum value for ArticleApprovalStatus.unapproved.
	 */
	UNAPPROVED("unapproved");


	private final String code;

	/**
	 * Creates a new enum value for this enum type.
	 *
	 * @param code the enum value code
	 */
	private ArticleApprovalStatusEnumStub(final String code)
	{
		this.code = code.intern();
	}


	/**
	 * Gets the code of this enum value.
	 *
	 * @return code of value
	 */
	@Override
	public String getCode()
	{
		return this.code;
	}

	/**
	 * Gets the type this enum value belongs to.
	 *
	 * @return code of type
	 */
	@Override
	public String getType()
	{
		return "ArticleApprovalStatus";
	}

}
