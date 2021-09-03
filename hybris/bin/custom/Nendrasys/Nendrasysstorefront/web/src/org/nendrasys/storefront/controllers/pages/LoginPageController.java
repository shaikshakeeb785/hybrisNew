/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package org.nendrasys.storefront.controllers.pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.hybris.platform.acceleratorstorefrontcommons.constants.WebConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractLoginPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.ConsentForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.GuestForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.LoginForm;
import de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.consent.data.AnonymousConsentData;
import de.hybris.platform.commercefacades.user.data.RegisterData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.nendrasys.storefront.controllers.ControllerConstants;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.nendrasys.storefront.customValidator.UserRegisterValidator;
import org.nendrasys.storefront.model.UserRegisterForm;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import static de.hybris.platform.commercefacades.constants.CommerceFacadesConstants.CONSENT_GIVEN;


/**
 * Login Controller. Handles login and register for the account flow.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginPageController extends AbstractLoginPageController {

    private static final Logger LOGGER = Logger.getLogger(LoginPageController.class);


    @Resource(name = "userRegisterValidator")
    private UserRegisterValidator userRegisterValidator;

    private static final String FORM_GLOBAL_ERROR = "form.global.error";
    private static final String CONSENT_FORM_GLOBAL_ERROR = "consent.form.global.error";

    protected static final String SPRING_SECURITY_LAST_USERNAME = "SPRING_SECURITY_LAST_USERNAME";
    private HttpSessionRequestCache httpSessionRequestCache;


    @Override
    protected String getView() {
        BasicConfigurator.configure();
        return ControllerConstants.Views.Pages.Account.AccountLoginPage;
    }

    @Override
    protected String getSuccessRedirect(final HttpServletRequest request, final HttpServletResponse response) {
        if (httpSessionRequestCache.getRequest(request, response) != null) {
            return httpSessionRequestCache.getRequest(request, response).getRedirectUrl();
        }
        return "/";
    }

    @Override
    protected AbstractPageModel getCmsPage() throws CMSItemNotFoundException {
        return getContentPageForLabelOrId("login");
    }


    @Resource(name = "httpSessionRequestCache")
    public void setHttpSessionRequestCache(final HttpSessionRequestCache accHttpSessionRequestCache) {
        this.httpSessionRequestCache = accHttpSessionRequestCache;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String doLogin(@RequestHeader(value = "referer", required = false) final String referer,
                          @RequestParam(value = "error", defaultValue = "false") final boolean loginError, final Model model,
                          final HttpServletRequest request, final HttpServletResponse response, final HttpSession session)
            throws CMSItemNotFoundException {
        if (!loginError) {
            storeReferer(referer, request, response);
        }

        return getDefaultLoginPage(loginError, session, model);

    }

    @Override
    protected String getDefaultLoginPage(final boolean loginError, final HttpSession session, final Model model) throws CMSItemNotFoundException {

        model.addAttribute(new UserRegisterForm());
        return super.getDefaultLoginPage(loginError, session, model);
    }


    protected void storeReferer(final String referer, final HttpServletRequest request, final HttpServletResponse response) {
        if (StringUtils.isNotBlank(referer) && !StringUtils.endsWith(referer, "/login")
                && StringUtils.contains(referer, request.getServerName())) {
            httpSessionRequestCache.saveRequest(request, response);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@RequestHeader(value = "referer", required = false) final String referer, final UserRegisterForm form,
                             final BindingResult bindingResult, final Model model, final HttpServletRequest request,
                             final HttpServletResponse response, final RedirectAttributes redirectModel) throws CMSItemNotFoundException {
        getLOGGER().info(form.getNewBusinessUser() + "Value of NewBusinessUser");

        userRegisterValidator.validate(form, bindingResult);
        return processRegisterUserRequest(referer, form, bindingResult, model, request, response, redirectModel);
    }

    @Override
    protected String processRegisterUserRequest(final String referer, final RegisterForm form, final BindingResult bindingResult, final Model model, final HttpServletRequest request, final HttpServletResponse response, final RedirectAttributes redirectModel) throws CMSItemNotFoundException {
        getLOGGER().info("Inside processRegisterUserRequest helperMethod");
        final UserRegisterForm userRegisterForm = (UserRegisterForm) form;
        if (bindingResult.hasErrors()) {
            form.setTermsCheck(false);
            model.addAttribute(form);
            model.addAttribute(new LoginForm());
            model.addAttribute(new GuestForm());
            GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
            return handleRegistrationError(model);
        }
        getLOGGER().info("setting the data from UserRegisterForm to RegisterData");
        final RegisterData data = new RegisterData();
        data.setFirstName(form.getFirstName());
        data.setLastName(form.getLastName());
        data.setLogin(form.getEmail());
        data.setPassword(form.getPwd());
        data.setTitleCode(form.getTitleCode());
        data.setNewBusinessUser(userRegisterForm.getNewBusinessUser());
        try {

            getCustomerFacade().register(data);
            getAutoLoginStrategy().login(form.getEmail().toLowerCase(), form.getPwd(), request, response);
            GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.CONF_MESSAGES_HOLDER,
                    "registration.confirmation.message.title");

        } catch (final DuplicateUidException e) {
            LOGGER.debug("registration failed.");
            form.setTermsCheck(false);
            model.addAttribute(form);
            model.addAttribute(new LoginForm());
            model.addAttribute(new GuestForm());
            bindingResult.rejectValue("email", "registration.error.account.exists.title");
            GlobalMessages.addErrorMessage(model, FORM_GLOBAL_ERROR);
            return handleRegistrationError(model);
        }

        // Consent form data
        try {
            final ConsentForm consentForm = form.getConsentForm();
            if (consentForm != null && consentForm.getConsentGiven()) {
                getConsentFacade().giveConsent(consentForm.getConsentTemplateId(), consentForm.getConsentTemplateVersion());
            }
        } catch (final Exception e) {
            LOGGER.error("Error occurred while creating consents during registration", e);
            GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, CONSENT_FORM_GLOBAL_ERROR);
        }

        // save anonymous-consent cookies as ConsentData
        final Cookie cookie = WebUtils.getCookie(request, WebConstants.ANONYMOUS_CONSENT_COOKIE);
        if (cookie != null) {
            try {
                final ObjectMapper mapper = new ObjectMapper();
                final List<AnonymousConsentData> anonymousConsentDataList = Arrays.asList(mapper.readValue(
                        URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8.displayName()), AnonymousConsentData[].class));
                anonymousConsentDataList.stream().filter(consentData -> CONSENT_GIVEN.equals(consentData.getConsentState()))
                        .forEach(consentData -> consentFacade.giveConsent(consentData.getTemplateCode(),
                                Integer.valueOf(consentData.getTemplateVersion())));
            } catch (final UnsupportedEncodingException e) {
                LOGGER.error(String.format("Cookie Data could not be decoded : %s", cookie.getValue()), e);
            } catch (final IOException e) {
                LOGGER.error("Cookie Data could not be mapped into the Object", e);
            } catch (final Exception e) {
                LOGGER.error("Error occurred while creating Anonymous cookie consents", e);
            }
        }

        customerConsentDataStrategy.populateCustomerConsentDataInSession();

        return REDIRECT_PREFIX + getSuccessRedirect(request, response);
    }

    @RequestMapping(value = "/register/termsandconditions", method = RequestMethod.GET)
    public String getTermsAndConditions(final Model model) throws CMSItemNotFoundException {
        final ContentPageModel pageForRequest = getCmsPageService().getPageForLabel("/termsAndConditions");
        storeCmsPageInModel(model, pageForRequest);
        setUpMetaDataForContentPage(model, pageForRequest);
        return ControllerConstants.Views.Fragments.Checkout.TermsAndConditionsPopup;
    }

    public static Logger getLOGGER() {
        return LOGGER;
    }
}
