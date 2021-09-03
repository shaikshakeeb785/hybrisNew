package org.nendrasys.core.customDao;

import de.hybris.platform.core.model.c2l.CountryModel;
import org.nendrasys.core.model.ManufacturerDetailsModel;

import java.util.List;

/**
 * @ManufacturerDetailsDao interface contains the method which is responsible for getting data by using flexible search query
 */
public interface ManufacturerDetailsDao {

    /**
     * @param id is used to get particular record from the data base
     * @return the ManufacturerDetailsModel
     */
    ManufacturerDetailsModel getManufacturerDetailsById(String id);

    /**
     * @return list of ManufacturerDetailsModel
     */
    List<ManufacturerDetailsModel> getManufacturerDetailsData();

    /**
     * @return list of ManufacturerDetailsModel
     */
    List<ManufacturerDetailsModel> getManufacturerDetailsPaginetion(int CurrentPage);

    /**
     * @param countryIsocode getting countryModel using isocode
     * @return
     */
    CountryModel getCountryModel(String countryIsocode);

    /**
     * @return getting list of data
     */
    List<CountryModel> getListOfCountry();

}
