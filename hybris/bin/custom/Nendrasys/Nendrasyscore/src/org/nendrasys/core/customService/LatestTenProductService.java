package org.nendrasys.core.customService;

import de.hybris.platform.core.model.product.ProductModel;

import java.util.List;

public interface LatestTenProductService {
    /**
     * @param productCount No of Product
     * @return ProductModel
     */
    List<ProductModel> getLatestTenProduct(int productCount);
}
