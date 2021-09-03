/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.acceleratorservices.payment.cybersource.constants;

import de.hybris.platform.acceleratorservices.payment.constants.PaymentConstants;


/**
 * 
 */
public interface CyberSourceV7HopConstants extends PaymentConstants
{
	interface HopAppearanceProperties // NOSONAR
	{
		String BACKGROUND_URL = "hop.cybersource.appearance.backgroundImageURL";
		String COLOR_SCHEME = "hop.cybersource.appearance.colorScheme";
		String BAR_COLOR = "hop.cybersource.appearance.barColor";
		String BAR_TEXT_COLOR = "hop.cybersource.appearance.barTextColor";
		String MESSAGE_BOX_BACKGROUND_COLOR = "hop.cybersource.appearance.messageBoxBackgroundColor";
		String REQUIRED_FIELD_COLOR = "hop.cybersource.appearance.requiredFieldColor";
	}
}
