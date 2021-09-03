package org.nendrasys.storefront.customController;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.product.data.ManufacturerDetailsData;
import de.hybris.platform.commercefacades.user.data.CountryData;
import de.hybris.platform.servicelayer.exceptions.ModelSavingException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.nendrasys.facades.CustomFacade.ManufacturerDetailesFacade;
import org.nendrasys.storefront.controllers.ControllerConstants;
import org.nendrasys.storefront.model.ManufacturerDetailsForm;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ManufacturerDetailsController extends AbstractPageController {

    public static final Logger logger = LogManager.getLogger(ManufacturerDetailsController.class);

    private static final String LIST_OF_MANUFACTURER_DETAIL_PATTERN = "/{listOfManufacturerDetails}";

    @Resource(name = "manufacturerDetailFacade")
    private ManufacturerDetailesFacade manufacturerDetailFacade;


    @GetMapping("/registerManufacturerDetails")
    public String registerManufacturerDetails(final Model model) {
        logger.info(" Inside registerManufacturerDetails Method");
        final List<CountryData> countryData = manufacturerDetailFacade.getListOfCountry();
        if (countryData.isEmpty()) {
            model.addAttribute("error", "Data Not Found");
        } else {
            model.addAttribute("countryData", countryData);
        }
        model.addAttribute("manufacturerDetails", new ManufacturerDetailsForm());
        final String labelOrId = "manufacturerReg";
        try {
            final ContentPageModel testPage = getContentPageForLabelOrId(labelOrId);
            storeCmsPageInModel(model, testPage);
            setUpMetaDataForContentPage(model, testPage);
        } catch (final CMSItemNotFoundException e) {
            e.printStackTrace();
        }
        return getViewForPage(model);
    }

    @GetMapping("/customCarouselComponentData")
    public String getCarouselComponentData(final Model model) {
        logger.info(" Inside getCarouselComponentData Method");
        final String labelOrId = "carouselPage";
        try {
            final ContentPageModel testPage = getContentPageForLabelOrId(labelOrId);
            storeCmsPageInModel(model, testPage);
            setUpMetaDataForContentPage(model, testPage);
            setUpMetaDataForContentPage(model, testPage);
        } catch (final CMSItemNotFoundException e) {
            e.printStackTrace();
        }
        return ControllerConstants.Views.Pages.CarouselData.data;
    }

    @RequestMapping(value = "/registerManufacturerDetailSave", method = RequestMethod.POST)
    public String registerManufacturerDetailSave(@ModelAttribute("manufacturerDetails") final ManufacturerDetailsForm manufacturerDetailsForm, final Model model) {
        logger.info(" Inside registerManufacturerDetailSave Method");
        if (manufacturerDetailsForm != null) {
            final ManufacturerDetailsData data = new ManufacturerDetailsData();
            data.setName(manufacturerDetailsForm.getName());
            data.setCity(manufacturerDetailsForm.getCity());
            final CountryData countrydata = new CountryData();
            countrydata.setIsocode(manufacturerDetailsForm.getCountry().getIsocode());
            data.setCountry(countrydata);
            try {
                manufacturerDetailFacade.saveManufacturerDetail(data);
            } catch (final ModelSavingException e) {
                logger.error("Exception is:" + e);
                model.addAttribute("error", "Do Not Enter Special Character");
                final List<CountryData> countryData = manufacturerDetailFacade.getListOfCountry();
                if (CollectionUtils.isEmpty(countryData)) {
                    model.addAttribute("error", "Data Not Found");
                } else {
                    model.addAttribute("countryData", countryData);
                }
                model.addAttribute("manufacturerDetails", new ManufacturerDetailsForm());
                return ControllerConstants.Views.Pages.ManufacturerData.register;
            }
            return "redirect:/listOfManufacturerDetails";
        }
        return ControllerConstants.Views.Pages.ManufacturerData.error;

    }

    @RequestMapping(value = "/getManufacturerDetailById/{id}", method = RequestMethod.GET)
    public String getManufacturerDetailsById(@PathVariable("id") final String id, final Model model) {
        BasicConfigurator.configure();
        logger.info("Inside getManufacturerDetailsById Method ");
        final ManufacturerDetailsData manufacturerDetailsData = manufacturerDetailFacade.getManufacturerDetailsById(id);
        if (manufacturerDetailsData != null) {

            model.addAttribute("detail", manufacturerDetailsData);
            return ControllerConstants.Views.Pages.ManufacturerData.data;

        } else {
            logger.error("ManufacturerDetailData Not Found For this id'" + id + "'");
            model.addAttribute("error", "ManufacturerDetailData Not Found For this id'\"+id+\"'");
        }
        return ControllerConstants.Views.Pages.ManufacturerData.data;

    }

    @RequestMapping(value = LIST_OF_MANUFACTURER_DETAIL_PATTERN, method = RequestMethod.GET)
    public String listOfManufacturerDetails(final Model model) {

        logger.info("Inside listOfManufacturerDetails Method ");
        final List<ManufacturerDetailsData> detailsDataList = manufacturerDetailFacade.getListOfManufacturerData();
        if (!detailsDataList.isEmpty()) {
            model.addAttribute("list", detailsDataList);
            return ControllerConstants.Views.Pages.ManufacturerData.list;
        } else {
            logger.error("ManufacturerDetailData Not Found ");
            model.addAttribute("error", "ManufacturerDetailData Not Found");
        }
        return ControllerConstants.Views.Pages.ManufacturerData.list;
    }

    @RequestMapping("/listOfManufacturerDetailsPagination/{currentPage}")
    public String listOfManufacturerDetailsPagination(@PathVariable("currentPage") final int currentPage, final Model model) {

        logger.info("Inside listOfManufacturerDetails Method ");
        final List<ManufacturerDetailsData> PaginationData = manufacturerDetailFacade.getManufacturerDetailsPaginetion(currentPage);
        if (!PaginationData.isEmpty()) {
            model.addAttribute("list", PaginationData);
            return ControllerConstants.Views.Pages.ManufacturerData.list;
        } else {
            logger.error("ManufacturerDetailData Not Found ");
            model.addAttribute("error", "ManufacturerDetailData Not Found");
        }
        return ControllerConstants.Views.Pages.ManufacturerData.list;
    }


}
