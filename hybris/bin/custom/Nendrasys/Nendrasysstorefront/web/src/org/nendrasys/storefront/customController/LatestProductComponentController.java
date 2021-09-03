package org.nendrasys.storefront.customController;

import de.hybris.platform.cmsfacades.data.ProductData;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.nendrasys.core.model.LatestProductComponentModel;
import org.nendrasys.facades.CustomFacade.impl.DefaultLatestTenProductFacade;
import org.nendrasys.storefront.controllers.ControllerConstants;
import org.nendrasys.storefront.controllers.cms.AbstractAcceleratorCMSComponentController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Custom Controller for latestProductComponent. This controller is used to get LatestTenProduct from the database and display
 * on the  Page.
 */
@Controller("LatestProductComponentController")
@RequestMapping(value = ControllerConstants.Actions.Cms.LatestProductComponent)
public class LatestProductComponentController extends AbstractAcceleratorCMSComponentController<LatestProductComponentModel> {

    public static final Logger logger = LogManager.getLogger(LatestProductComponentController.class);

    @Resource(name = "defaultLatestTenProductFacade")
    private DefaultLatestTenProductFacade defaultCustomProductFacade;

    @Override
    protected void fillModel(final HttpServletRequest request, final Model model, final LatestProductComponentModel component) {
        logger.info("Inside LatestProductComponentController in fillModel method");
        BasicConfigurator.configure();
        final List<ProductData> lstLatestTenProduct = defaultCustomProductFacade.getLatestTenProduct(component.getNumberOfProduct());
        if (!CollectionUtils.isEmpty(lstLatestTenProduct)) {
            model.addAttribute("latestTenProduct", lstLatestTenProduct);
        } else {
            model.addAttribute("error", "Data Not For product");
        }
    }
}
