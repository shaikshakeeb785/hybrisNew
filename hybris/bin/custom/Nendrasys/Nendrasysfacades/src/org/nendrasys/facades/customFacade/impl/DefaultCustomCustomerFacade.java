package org.nendrasys.facades.CustomFacade.impl;

import de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.core.model.user.CustomerModel;

public class DefaultCustomCustomerFacade extends DefaultCustomerFacade
{
    @Override
    protected void setCommonPropertiesForRegister(final RegisterData registerData, final CustomerModel customerModel) {
        super.setCommonPropertiesForRegister(registerData, customerModel);
        customerModel.setNewBusinessUser(registerData.getNewBusinessUser());
    }
}
