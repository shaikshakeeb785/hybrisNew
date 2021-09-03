package org.nendrasys.core.customInterceptor;

import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.servicelayer.interceptor.*;

import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.nendrasys.core.customService.impl.DefaultManufacturerDetailsService;
import org.nendrasys.core.jalo.ManufacturerDetailsAudit;
import org.nendrasys.core.model.ManufacturerDetailsAuditModel;
import org.nendrasys.core.model.ManufacturerDetailsModel;
import org.springframework.beans.factory.annotation.Required;

/**
 * implementation for {@link PrepareInterceptor}
 */
public class ManufacturerDetailsRemoveInterceptor implements RemoveInterceptor<ManufacturerDetailsModel> {
    public static final Logger logger = LogManager.getLogger(ManufacturerDetailsRemoveInterceptor.class);
    private ModelService modelService;

    @Override
    public void onRemove(ManufacturerDetailsModel manufacturerDetailsModel, InterceptorContext cxt) {
        BasicConfigurator.configure();
        logger.info("Inside ManufacturerDetailsRemoveInterceptor class in onRemoveMethod");
        ManufacturerDetailsAuditModel auditModel = cxt.getModelService().create(ManufacturerDetailsAuditModel.class);
        auditModel.setId(manufacturerDetailsModel.getId());
        auditModel.setName(manufacturerDetailsModel.getName());
        auditModel.setCity(manufacturerDetailsModel.getCity());
        modelService.save(auditModel);

    }

    public ModelService getModelService() {
        return modelService;
    }

    @Required
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }


}
