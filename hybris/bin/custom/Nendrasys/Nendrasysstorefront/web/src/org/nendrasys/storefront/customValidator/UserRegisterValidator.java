package org.nendrasys.storefront.customValidator;

import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.RegistrationValidator;
import org.nendrasys.storefront.model.UserRegisterForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
@Component("userRegisterValidator")
public class UserRegisterValidator extends RegistrationValidator  {
    @Override
    public boolean supports(final Class<?> aClass) {
        return UserRegisterForm.class.equals(aClass);
    }

    @Override
    public void validate(final Object userRegisterForm, final Errors bindingResult){
        super.validate(userRegisterForm, bindingResult);
        if(userRegisterForm!=null)
        {
            final UserRegisterForm userRegisterForm1=(UserRegisterForm)userRegisterForm;
            if(userRegisterForm1.getNewBusinessUser()==null||userRegisterForm1.getNewBusinessUser().equals(Boolean.FALSE))
            {
                bindingResult.reject("newBusinessUser","check this box");
            }
        }



    }
}
