package org.nendrasys.core.customDao;

import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

public interface LatestTenProductDao {
    /**
     * @param productCount No of Product
     * @return ProductModel
     */
    List<ProductModel> getLatestTenProduct(int productCount);
}
