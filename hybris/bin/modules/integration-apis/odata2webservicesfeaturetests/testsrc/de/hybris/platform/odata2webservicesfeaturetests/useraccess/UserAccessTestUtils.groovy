/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.odata2webservicesfeaturetests.useraccess

import de.hybris.platform.core.model.user.UserModel
import de.hybris.platform.integrationservices.util.IntegrationTestUtil
import de.hybris.platform.odata2webservices.constants.Odata2webservicesConstants
import de.hybris.platform.odata2webservicesfeaturetests.ws.BasicAuthRequestBuilder
import org.springframework.http.MediaType

class UserAccessTestUtils {
	protected static final String SERVICE = "TestCatalog"
	protected static final String ADMIN_USER = "userintegrationadmin"
	protected static final String PASSWORD = "password"

	protected static void givenCatalogIOExists() {
        givenCatalogItemExistsForIO(SERVICE)
	}

    protected static givenCatalogItemExistsForIO(final String objectCode) {
        IntegrationTestUtil.importImpEx(
                'INSERT_UPDATE IntegrationObject; code[unique = true]',
                "                               ; $objectCode",
                'INSERT_UPDATE IntegrationObjectItem; integrationObject(code)[unique = true]; code[unique = true]; type(code)',
                "                                   ; $objectCode                           ; Catalog            ; Catalog",
                '$returnItem=returnIntegrationObjectItem(integrationObject(code), code)',
                '$descriptor=attributeDescriptor(enclosingType(code), qualifier)',
                'INSERT_UPDATE IntegrationObjectItemAttribute; integrationObjectItem(integrationObject(code), code)[unique = true]; attributeName[unique = true]; $descriptor  ; $returnItem; unique[default = false]',
                "                                            ; $objectCode:Catalog                                                ; id                          ; Catalog:id   ;            ;",
                "                                            ; $objectCode:Catalog                                                ; name                        ; Catalog:name ;            ;",
        )
    }

    protected static void givenUserExistsWithUidAndGroups(final String uid, final String groups = "")
	{
		createUser uid, PASSWORD, groups
	}

	protected static def basicAuthRequest(String path) {
		new BasicAuthRequestBuilder()
				.extensionName(Odata2webservicesConstants.EXTENSIONNAME)
				.accept(MediaType.APPLICATION_XML_VALUE)
				.path(path)
	}

	static def createUser(String uid = ADMIN_USER, String pwd = PASSWORD, String groups = "") {
		IntegrationTestUtil.importImpEx(
				'$password=@password[translator = de.hybris.platform.impex.jalo.translators.UserPasswordTranslator]',
				'INSERT_UPDATE Employee; UID[unique = true] ; groups(uid)[mode = append] ;$password',
				"                      ; $uid               ; $groups                    ;*:$pwd"
		)
	}

    static def deleteUser(String uid) {
        IntegrationTestUtil.removeSafely(UserModel) {
            it.uid == uid
        }
    }
}
