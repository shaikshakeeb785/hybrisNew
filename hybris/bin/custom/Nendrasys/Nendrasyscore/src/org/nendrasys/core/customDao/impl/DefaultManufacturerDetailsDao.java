package org.nendrasys.core.customDao.impl;

import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.core.servicelayer.data.PaginationData;
import de.hybris.platform.core.servicelayer.data.SearchPageData;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import de.hybris.platform.servicelayer.search.paginated.PaginatedFlexibleSearchParameter;
import de.hybris.platform.servicelayer.search.paginated.PaginatedFlexibleSearchService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.nendrasys.core.customDao.ManufacturerDetailsDao;

import org.nendrasys.core.model.ManufacturerDetailsModel;
import org.springframework.beans.factory.annotation.Required;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * implementation for {@link ManufacturerDetailsDao}
 */
public class DefaultManufacturerDetailsDao implements ManufacturerDetailsDao {
    public static final Logger logger = LogManager.getLogger(DefaultManufacturerDetailsDao.class);

    private FlexibleSearchService flexibleSearchService;
    private PaginatedFlexibleSearchService paginatedFlexibleSearchService;

    @Override
    public ManufacturerDetailsModel getManufacturerDetailsById(final String id) {

        BasicConfigurator.configure();
        logger.info("Inside ManufacturerDetailDao Class in getManufacturerDetailsById method");
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT {").append(ManufacturerDetailsModel.PK);
        stringBuilder.append("} FROM {").append(ManufacturerDetailsModel._TYPECODE);
        stringBuilder.append("} WHERE {").append(ManufacturerDetailsModel.ID);
        stringBuilder.append("}=?id");
        final FlexibleSearchQuery fQuery = new FlexibleSearchQuery(stringBuilder);
        fQuery.addQueryParameter("id", id);
        final SearchResult<ManufacturerDetailsModel> searchResult = getFlexibleSearchService().search(fQuery);
        return searchResult.getResult().get(0);
    }

    @Override
    public List<ManufacturerDetailsModel> getManufacturerDetailsData() {

        logger.info("Inside ManufacturerDetailDao Class in getManufacturerDetailsData method");
        final String query = "SELECT {" + ManufacturerDetailsModel.PK + "} FROM {" + ManufacturerDetailsModel._TYPECODE + "}";
        final FlexibleSearchQuery fQuery = new FlexibleSearchQuery(query);
        final SearchResult<ManufacturerDetailsModel> result = getFlexibleSearchService().search(fQuery);
        final int resultTotalCount = result.getTotalCount();
        if (resultTotalCount == 0) {
            throw new UnknownIdentifierException("no records");
        }
        return result.getResult();
    }

    @Override
    public List<ManufacturerDetailsModel> getManufacturerDetailsPaginetion(final int CurrentPage) {

        logger.info("Inside getManufacturerDetailsPaginetion method ");
        final PaginationData paginationData = new PaginationData();
        paginationData.setPageSize(10);
        paginationData.setCurrentPage(CurrentPage);
        paginationData.setNeedsTotal(true);
        final SearchPageData pageData = new SearchPageData();
        pageData.setPagination(paginationData);
        final PaginatedFlexibleSearchParameter paginatedFlexibleSearchParameter = new PaginatedFlexibleSearchParameter();
        paginatedFlexibleSearchParameter.setSearchPageData(pageData);
        final String query = "SELECT {" + ManufacturerDetailsModel.PK + "} FROM {" + ManufacturerDetailsModel._TYPECODE + "}";
        final FlexibleSearchQuery fQuery = new FlexibleSearchQuery(query);
        paginatedFlexibleSearchParameter.setFlexibleSearchQuery(fQuery);
        final SearchPageData<ManufacturerDetailsModel> manufacturerDetailsModelSearchPageData = paginatedFlexibleSearchService.search(paginatedFlexibleSearchParameter);

        return manufacturerDetailsModelSearchPageData.getResults();
    }

    @Override
    public CountryModel getCountryModel(final String isocode) {

        logger.info("Inside getCountryModel by using Isocode");
        final String query = "SELECT {" + CountryModel.PK + "} FROM {" + CountryModel._TYPECODE + "}" + "WHERE{" + CountryModel.ISOCODE + "}=?isocode";
        final FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(query);
        final Map<String, Object> param = new HashMap<>();
        param.put("isocode", isocode);
        flexibleSearchQuery.addQueryParameters(param);
        final SearchResult<CountryModel> result = getFlexibleSearchService().search(flexibleSearchQuery);
        final int resultTotalCount = result.getTotalCount();
        if (resultTotalCount == 0) {
            throw new UnknownIdentifierException("not found for this id");
        } else if (resultTotalCount > 1) {
            throw new AmbiguousIdentifierException("more than one record found");
        }
        return result.getResult().get(0);

    }

    @Override
    public List<CountryModel> getListOfCountry() {
        logger.info("Inside dao getAllCountry method");
        final String query = "SELECT {" + CountryModel.PK + "} FROM {" + CountryModel._TYPECODE + "}";

        final FlexibleSearchQuery fQuery = new FlexibleSearchQuery(query);
        final SearchResult<CountryModel> result = getFlexibleSearchService().search(fQuery);

        final int resultTotalCount = result.getTotalCount();
        if (resultTotalCount == 0) {
            throw new UnknownIdentifierException("no records");
        }
        return result.getResult()==null? Collections.emptyList():result.getResult();

    }

    public FlexibleSearchService getFlexibleSearchService() {
        return flexibleSearchService;
    }

    @Required
    public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    public PaginatedFlexibleSearchService getPaginatedFlexibleSearchService() {
        return paginatedFlexibleSearchService;
    }

    @Required
    public void setPaginatedFlexibleSearchService(final PaginatedFlexibleSearchService paginatedFlexibleSearchService) {
        this.paginatedFlexibleSearchService = paginatedFlexibleSearchService;
    }
}
