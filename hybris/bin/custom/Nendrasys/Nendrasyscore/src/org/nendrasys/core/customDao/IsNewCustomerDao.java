package org.nendrasys.core.customDao;

import de.hybris.platform.core.model.user.CustomerModel;

import java.util.Date;
import java.util.List;

public interface IsNewCustomerDao {
    /**
     * @param days no of days compare the creation time of each customerModel
     * @return List of CustomerModel which the creation time is less then passing days as param
     */
     List<CustomerModel> findAllCustomerCreationTimeLessThenSpecifieDays(final Date days);
}
