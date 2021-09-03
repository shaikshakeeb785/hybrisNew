package org.nendrasys.core.customDao.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.daos.impl.DefaultProductDao;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.nendrasys.core.customDao.LatestTenProductDao;


import java.util.List;
/**
 * implementation for {@link LatestTenProductDao}
 */
public class DefaultLatestTenProductDao extends DefaultProductDao implements LatestTenProductDao {

    public static final Logger logger = LogManager.getLogger(DefaultLatestTenProductDao.class);
    private FlexibleSearchService flexibleSearchService;

    public DefaultLatestTenProductDao(final String typecode) {
        super(typecode);
    }

    public List<ProductModel> getLatestTenProduct(final int productCount) {
        logger.info("Inside DefaultLatestTenProductDao in getLatestTenProduct method");
        BasicConfigurator.configure();
        final FlexibleSearchQuery flexibleSearchQuery;
        final String query = "SELECT {" + ProductModel.PK + "} FROM {" + ProductModel._TYPECODE  + "} ORDER BY {"+ProductModel.CREATIONTIME+"} desc ";
        flexibleSearchQuery = new FlexibleSearchQuery(query);
        flexibleSearchQuery.setCount(productCount);
        final SearchResult<ProductModel> result =getFlexibleSearchService().search(flexibleSearchQuery);
        final int resultTotalCount = result.getTotalCount();
        if (resultTotalCount == 0) {
            throw new UnknownIdentifierException("no records");
        }
        return result.getResult();
    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }

    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}
