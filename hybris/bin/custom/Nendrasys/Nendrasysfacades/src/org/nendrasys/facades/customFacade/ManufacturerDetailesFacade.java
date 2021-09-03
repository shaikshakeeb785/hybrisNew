package org.nendrasys.facades.CustomFacade;

import de.hybris.platform.commercefacades.product.data.ManufacturerDetailsData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;


import java.util.List;

public interface ManufacturerDetailesFacade {

    /**
     * @param id getting particular from the service layer
     * @return manufacturerDetailsData
     */
    ManufacturerDetailsData getManufacturerDetailsById(String id);

    /**
     * @return ListOfManufacturerDetailsData
     */
    List<ManufacturerDetailsData> getListOfManufacturerData();

    /**
     * @return list of ManufacturerDetailsModel
     */
    List<ManufacturerDetailsData> getManufacturerDetailsPaginetion(int CurrentPage);

    /**
     * @param manufacturerDetailData saving manufacturing Details in database passing data from the form
     * @throws InterceptorException
     */
    void saveManufacturerDetail(ManufacturerDetailsData manufacturerDetailData) throws ModelSavingException;

    /**
     * @return list of country
     */
    List<CountryData> getListOfCountry();

}
