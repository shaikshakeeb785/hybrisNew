package org.nendrasys.core.customInterceptor;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;

import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.nendrasys.core.customService.impl.DefaultManufacturerDetailsService;
import org.nendrasys.core.model.ManufacturerDetailsModel;
/**
 * implementation for {@link PrepareInterceptor}
 */
public class ManufacturerDetailsPrepareInterceptors implements PrepareInterceptor<ManufacturerDetailsModel> {
    public static final Logger logger = LogManager.getLogger(DefaultManufacturerDetailsService.class);
    @Override
    public void onPrepare(ManufacturerDetailsModel manufacturerDetailsModel, InterceptorContext interceptorContext) {
        BasicConfigurator.configure();
        logger.info("Inside ManufacturerDetailsPrepare Interceptors");
        String name=manufacturerDetailsModel.getName();
        String modifiedName="Man"+name;
        manufacturerDetailsModel.setName(modifiedName);

    }
}
