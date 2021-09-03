package org.nendrasys.core.customService;

import de.hybris.platform.core.model.c2l.CountryModel;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import org.nendrasys.core.model.ManufacturerDetailsModel;


import java.util.List;

/**
 * @ManufacturerDetailsService interface contains the method which is responsible for getting Manufacturer data from the dao layer
 */
public interface ManufacturerDetailsService {
    /**
     * @param id is used to get particular data first it go to dao layer
     * @return the ManufacturerDetailsModel from the dao layer
     */
    ManufacturerDetailsModel getManufacturerDetailsById(String id);

    /**
     * @return list of ManufacturerDetailsModel from the dao layer
     */
    List<ManufacturerDetailsModel> getManufacturerDetailsData();

    /**
     * @return list of ManufacturerDetailsModel
     */
    List<ManufacturerDetailsModel> getManufacturerDetailsPaginetion(int CurrentPage);

    /**
     * this method is used to save a record into the database
     */
    void registerManufacturerDetailSave(ManufacturerDetailsModel manufacturerDetailsModel) throws ModelSavingException;

    /**
     * @param countryIsocode getting CoutryModel from the DataBase by using isocode
     * @return
     */
    CountryModel getCountryModel(String countryIsocode);

    /**
     * @return list of country
     */
    List<CountryModel> getListOfCountry();
}
