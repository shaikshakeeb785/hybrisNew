package org.nendrasys.core.customDao.impl;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.nendrasys.core.customDao.IsNewCustomerDao;
import org.springframework.beans.factory.annotation.Required;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * implementation for {@link IsNewCustomerDao}
 */
public class DefaultIsNewCustomerDao implements IsNewCustomerDao {
    public static final Logger logger = LogManager.getLogger(DefaultManufacturerDetailsDao.class);

    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<CustomerModel> findAllCustomerCreationTimeLessThenSpecifieDays(final Date days) {
        BasicConfigurator.configure();
            FlexibleSearchQuery flexibleSearchQuery=null;
                final String query = "SELECT {" + CustomerModel.PK + "} FROM {" + CustomerModel._TYPECODE + "}" + "WHERE{" + CustomerModel.CREATIONTIME + "}>=?days";
                flexibleSearchQuery = new FlexibleSearchQuery(query);
                final Map<String, Object> param = new HashMap<>();
                param.put("days", days);
                flexibleSearchQuery.addQueryParameters(param);
                final SearchResult<CustomerModel> result = getFlexibleSearchService().search(flexibleSearchQuery);
                final int resultTotalCount = result.getTotalCount();
                if (resultTotalCount == 0) {
                    throw new UnknownIdentifierException("no records");
                }
                return result.getResult();

    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }
    @Required
    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}
