/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */

package de.hybris.platform.integrationservices

import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.integrationservices.model.IntegrationObjectModel
import de.hybris.platform.integrationservices.util.IntegrationTestUtil
import de.hybris.platform.servicelayer.ServicelayerSpockSpecification
import org.junit.Test
import spock.lang.Issue
import spock.lang.Unroll

@IntegrationTest
class StandardAttributeModelingIntegrationTest extends ServicelayerSpockSpecification {

    private static final def IO = 'StandardIO'

    def setupSpec() {
        IntegrationTestUtil.importImpEx(
                'INSERT_UPDATE IntegrationObject; code[unique = true]',
                "                               ; $IO",
                'INSERT_UPDATE IntegrationObjectItem; integrationObject(code)[unique = true]; code[unique = true]; type(code)',
                "                                   ; $IO                                   ; SavedQuery         ; SavedQuery",
                "                                   ; $IO                                   ; Order              ; Order",
                "                                   ; $IO                                   ; Product            ; Product")
    }

    def cleanupSpec() {
        IntegrationTestUtil.removeAll IntegrationObjectModel
    }

    @Issue('https://jira.hybris.com/browse/IAPI-3889')
    @Test
    def 'attribute with an incorrect enum reference does not throw exception in the validator'() {
        when:
        IntegrationTestUtil.importImpEx(
                'INSERT_UPDATE IntegrationObject; code[unique = true]; integrationType(code)',
                '; EnumReferenceIO; INBOUND',
                'INSERT_UPDATE IntegrationObjectItem; integrationObject(code)[unique = true]; code[unique = true] ; type(code)          ; root[default = false];',
                '                                   ; EnumReferenceIO                       ; PhoneContactInfo    ; PhoneContactInfo    ;                      ;',
                '                                   ; EnumReferenceIO                       ; TestEnum            ; TestEnum            ;                      ;',
                '$item = integrationObjectItem(integrationObject(code), code)',
                '$descriptor = attributeDescriptor(enclosingType(code), qualifier)',
                '$attributeType = returnIntegrationObjectItem(integrationObject(code), code)',
                'INSERT_UPDATE IntegrationObjectItemAttribute; $item[unique = true]                ; attributeName[unique = true]; $descriptor                 ; $attributeType                      ;',
                '                                            ; EnumReferenceIO:PhoneContactInfo    ; phoneNumber                 ; PhoneContactInfo:phoneNumber;                                     ;',
                '                                            ; EnumReferenceIO:PhoneContactInfo    ; type                        ; PhoneContactInfo:type       ; EnumReferenceIO:TestEnum            ;',
                '                                            ; EnumReferenceIO:TestEnum            ; code                        ; TestEnum:code               ;                                     ;'
        )
        then:
        noExceptionThrown()
    }

    @Test
    @Unroll
    def 'exception is thrown when an IntegrationObjectItem of a #type type provides an itemTypeMatch=ALL_SUB_AND_SUPER_TYPES'() {
        when: 'Order does not provide returnIntegrationObjectItem for user'
        IntegrationTestUtil.importImpEx(
                'INSERT_UPDATE IntegrationObjectItem; integrationObject(code)[unique = true]; code[unique = true]; type(code); itemTypeMatch(code)',
                "                                   ; $IO                                   ; $itemType          ; $itemType ; ALL_SUB_AND_SUPER_TYPES")

        then:
        def e = thrown AssertionError
        e.message.contains 'The permitted itemTypeMatch values for an item of this type are [ALL_SUBTYPES]'

        where:
        type       | itemType
        'enum'     | "TestEnum"
        'abstract' | "Formatter"
    }

    @Test
    def 'exception is thrown when reference type attribute does not provide returnIntegrationObjectItem'() {
        when: 'Order does not provide returnIntegrationObjectItem for user'
        IntegrationTestUtil.importImpEx(
                '$item = integrationObjectItem(integrationObject(code), code)',
                '$descriptor = attributeDescriptor(enclosingType(code), qualifier)',
                '$attributeType = returnIntegrationObjectItem(integrationObject(code), code)',
                'INSERT_UPDATE IntegrationObjectItemAttribute; $item[unique = true]; attributeName[unique = true]; $descriptor; $attributeType;',
                "                                            ; $IO:Order           ; user                        ; Order:user")

        then:
        def e = thrown AssertionError
        e.message.contains 'referenced type attribute [user]'
    }

    @Test
    def 'exception is thrown when map attribute has a non-primitive returntype'() {
        when: "SavedQuery has an attribute 'mapTypeAttribute' where the MapType has a non-primitive returntype"
        IntegrationTestUtil.importImpEx(
                '$item = integrationObjectItem(integrationObject(code), code)',
                '$descriptor = attributeDescriptor(enclosingType(code), qualifier)',
                'INSERT_UPDATE IntegrationObjectItemAttribute; $item[unique = true]; attributeName[unique = true]; $descriptor',
                "                                            ; $IO:SavedQuery      ; code                        ; SavedQuery:code",
                "                                            ; $IO:SavedQuery      ; mapTypeAttribute            ; SavedQuery:params"
        )

        then:
        def e = thrown AssertionError
        e.message.contains 'Map type attribute [mapTypeAttribute]'
    }
}
