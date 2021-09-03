/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.platform.odata2webservices.odata

import de.hybris.bootstrap.annotations.IntegrationTest
import de.hybris.platform.inboundservices.enums.AuthenticationType
import de.hybris.platform.inboundservices.model.InboundChannelConfigurationModel
import de.hybris.platform.integrationservices.model.IntegrationObjectModel
import de.hybris.platform.integrationservices.util.IntegrationTestUtil
import de.hybris.platform.servicelayer.ServicelayerSpockSpecification
import org.junit.Test
import spock.lang.Unroll

@IntegrationTest
class InboundChannelConfigurationPersistenceIntegrationTest extends ServicelayerSpockSpecification {
    private static final String EXISTING_IO = "InboundChannelConfigurationPersistenceIntegrationTest"

    def setupSpec() {
        IntegrationTestUtil.importImpEx(
                "INSERT_UPDATE IntegrationObject; code[unique = true]",
                "                               ; $EXISTING_IO"
        )
    }

    def cleanup() {
        IntegrationTestUtil.removeAll InboundChannelConfigurationModel
    }

    def cleanupSpec() {
        IntegrationTestUtil.removeAll IntegrationObjectModel
    }

    @Test
    @Unroll
    def "can create InboundChannelConfiguration when providing authenticationType #providedAuthType and integrationObject referencing an existing IntegrationObject"() {
        when:
        IntegrationTestUtil.importImpEx(
                'INSERT_UPDATE InboundChannelConfiguration; integrationObject(code)[unique = true]; authenticationType(code)',
                "                                         ; $EXISTING_IO                          ; $providedAuthType"
        )

        then:
        noExceptionThrown()
        def inboundChannelConfig = findExistingChannelConfigWithIO(EXISTING_IO)
        inboundChannelConfig.authenticationType == expectedAuthType

        where:
        providedAuthType | expectedAuthType
        "OAUTH"          | AuthenticationType.OAUTH
        "BASIC"          | AuthenticationType.BASIC
    }

    @Test
    def "can create InboundChannelConfiguration with the default authenticationType when existing integration object is provided"() {
        when:
        IntegrationTestUtil.importImpEx(
                'INSERT_UPDATE InboundChannelConfiguration; integrationObject(code)[unique = true]',
                "                                         ; $EXISTING_IO                           "
        )

        then:
        noExceptionThrown()
        def inboundChannelConfig = findExistingChannelConfigWithIO(EXISTING_IO)
        and: "authenticationType is set to the expected default value"
        inboundChannelConfig.authenticationType == AuthenticationType.BASIC
    }

    @Test
    def "cannot create an InboundChannelConfiguration without providing a integration object"() {
        when:
        IntegrationTestUtil.importImpEx(
                'INSERT_UPDATE InboundChannelConfiguration; integrationObject(code)[unique = true]; authenticationType(code)',
                "                                         ;                                       ; BASIC"
        )

        then:
        thrown(AssertionError)
        IntegrationTestUtil.findAll(InboundChannelConfigurationModel).isEmpty()
    }

    @Test
    def "cannot update InboundChannelConfiguration authentication to null"() {
        given: "an InboundChannelConfiguration exists"
        IntegrationTestUtil.importImpEx(
                'INSERT_UPDATE InboundChannelConfiguration; integrationObject(code)[unique = true]; authenticationType(code)',
                "                                         ; $EXISTING_IO                          ; OAUTH"
        )

        when: "an attempt is made to change the InboundChannelConfiguration authenticationType to null"
        IntegrationTestUtil.importImpEx(
                'INSERT_UPDATE InboundChannelConfiguration; integrationObject(code)[unique = true]; authenticationType',
                "                                         ; $EXISTING_IO                          ;"
        )

        then:
        thrown(AssertionError)
        def inboundChannelConfig = findExistingChannelConfigWithIO(EXISTING_IO)
        inboundChannelConfig.authenticationType == AuthenticationType.OAUTH
    }

    private static InboundChannelConfigurationModel findExistingChannelConfigWithIO(final String objectCode) {
        IntegrationTestUtil.findAny(InboundChannelConfigurationModel, {
            it.integrationObject.code == objectCode
        }).orElse(null)
    }
}