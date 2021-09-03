package org.nendrasys.facades.CustomFacade.impl;

import de.hybris.platform.cmsfacades.data.ProductData;
import de.hybris.platform.commercefacades.product.impl.DefaultProductFacade;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.fest.util.Collections;
import org.nendrasys.core.customService.impl.DefaultLatestTenProductService;
import org.nendrasys.facades.CustomFacade.LatestTenProductFacade;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;
/**
 * implementation for {@link LatestTenProductFacade}
 */
public class DefaultLatestTenProductFacade extends DefaultProductFacade implements LatestTenProductFacade {

    public static final Logger logger = LogManager.getLogger(DefaultLatestTenProductFacade.class);
    private DefaultLatestTenProductService defaultCustomProductService;


    @Override
    public List<ProductData> getLatestTenProduct(final int productCount) {
        BasicConfigurator.configure();
        logger.info("Inside DefaultLatestTenProductFacade in getLatestTenProduct method");
        final List<ProductModel> lstLatestProduct=defaultCustomProductService.getLatestTenProduct(productCount);
        if(!Collections.isEmpty(lstLatestProduct))
        {
            final List<ProductData> lstProductData=getProductConverter().convertAll(lstLatestProduct);
            return lstProductData;
        }
           return null;
    }

    public DefaultLatestTenProductService getDefaultCustomProductService() {
        return defaultCustomProductService;
    }
    @Required
    public void setDefaultCustomProductService(final DefaultLatestTenProductService defaultCustomProductService) {
        this.defaultCustomProductService = defaultCustomProductService;
    }



}
