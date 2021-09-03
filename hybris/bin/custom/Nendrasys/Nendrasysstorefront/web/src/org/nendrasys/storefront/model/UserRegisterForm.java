package org.nendrasys.storefront.model;

import de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm;

public class UserRegisterForm extends RegisterForm {
    private Boolean newBusinessUser;

    public Boolean getNewBusinessUser() {
        return newBusinessUser;
    }

    public void setNewBusinessUser(final Boolean newBusinessUser) {
        this.newBusinessUser = newBusinessUser;
    }
}
