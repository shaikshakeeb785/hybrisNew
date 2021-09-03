package org.nendrasys.facades.CustomFacade;

import de.hybris.platform.cmsfacades.data.ProductData;

import java.util.List;

public interface LatestTenProductFacade {

    /**
     * @param productCount No of Product
     * @return ProductData
     */
    List<ProductData> getLatestTenProduct(int productCount);
}
