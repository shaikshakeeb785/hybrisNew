package org.nendrasys.core.customService.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.impl.DefaultProductService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.nendrasys.core.customDao.impl.DefaultLatestTenProductDao;
import org.nendrasys.core.customService.LatestTenProductService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;
/**
 * implementation for {@link LatestTenProductService}
 */
public class DefaultLatestTenProductService extends DefaultProductService implements LatestTenProductService {


    public static final Logger logger = LogManager.getLogger(DefaultLatestTenProductService.class);
       private DefaultLatestTenProductDao defaultLatestTenProductDao;
    @Override
    public List<ProductModel> getLatestTenProduct(final int productCount) {
        BasicConfigurator.configure();
        logger.info("Inside DefaultLatestTenProductService in getLatestTenProduct method");
        return defaultLatestTenProductDao.getLatestTenProduct(productCount);
    }

    public DefaultLatestTenProductDao getDefaultLatestTenProductDao() {
        return defaultLatestTenProductDao;
    }
 @Required
    public void setDefaultLatestTenProductDao(final DefaultLatestTenProductDao defaultLatestTenProductDao) {
        this.defaultLatestTenProductDao = defaultLatestTenProductDao;
    }
}
