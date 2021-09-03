package org.nendrasys.core.customInterceptor;


import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.interceptor.ValidateInterceptor;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.nendrasys.core.model.ManufacturerDetailsModel;

import java.util.regex.Pattern;

/**
 * implementation for {@link PrepareInterceptor}
 */
public class ManufacturerDetailValidatorInterceptor implements ValidateInterceptor<ManufacturerDetailsModel> {
    public static final Logger logger = LogManager.getLogger(ManufacturerDetailValidatorInterceptor.class);

    @Override
    public void onValidate(ManufacturerDetailsModel manufacturerDetailsModel, InterceptorContext interceptorContext) throws InterceptorException {
        BasicConfigurator.configure();
        logger.info("Inside ManufacturerDetailValidatorInterceptor class in onValidate");
        boolean validResult = Pattern.matches("^[a-zA-Z0-9]+$", manufacturerDetailsModel.getName());
        if (!validResult) {
            throw new InterceptorException("name should be alphanumaric");
        }
    }
}
