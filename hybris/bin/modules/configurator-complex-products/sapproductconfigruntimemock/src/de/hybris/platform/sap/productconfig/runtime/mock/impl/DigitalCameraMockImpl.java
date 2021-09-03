/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package de.hybris.platform.sap.productconfig.runtime.mock.impl;

import de.hybris.platform.sap.productconfig.runtime.interf.model.ConfigModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.CsticGroupModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.CsticModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.CsticValueModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.InstanceModel;
import de.hybris.platform.sap.productconfig.runtime.interf.model.PriceModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.util.CollectionUtils;


public class DigitalCameraMockImpl extends BaseRunTimeConfigMockImpl
{
	public static final String CONFIG_NAME = "Config Name";
	public static final String ROOT_INSTANCE_ID = ROOT_INST_ID;
	public static final String ROOT_INSTANCE_NAME = "CONF_CAMERA_SL";
	public static final String ROOT_INSTANCE_LANG_DEP_NAME = "Configurable System Camera";
	public static final String KB_ID = "23";



	private static final String APERTURE = "CAMERA_APERTURE";
	private static final String LANG_DEPENDENT_APERTURE = "Maximum Aperture";
	private static final String F17 = "F1.7";
	private static final String F17_DESCRIPTION = "f/1.7";
	private static final String F28 = "F2.8";
	private static final String F28_DESCRIPTION = "f/2.8";
	private static final String F35 = "F3.5";
	private static final String F35_DESCRIPTION = "f/3.5";
	private static final String CAMERA_COLOUR = "CAMERA_COLOR";
	private static final String LANG_DEPENDENT_CAMERA_COLOUR = "Body Color";
	private static final String BLACK = "BLACK";
	private static final String BLACK_DESCRIPTION = "Black";
	private static final String WHITE = "METALLIC";
	private static final String WHITE_DESCRIPTION = "Metallic";
	private static final String DISPLAY = "CAMERA_DISPLAY";
	private static final String PIXELS5 = "P5";
	private static final String PIXELS5_DESCRIPTION = "500 000 Pixels";
	private static final String PIXELS10 = "P10";
	private static final String PIXELS10_DESCRIPTION = "1 000 000 Pixels";
	private static final String FORMAT_PICTURE = "CAMERA_FORMAT_PICTURES";
	private static final String LANG_DEPENDENT_NAME_FORMAT_PICTURE = "Data Format for Pictures";
	private static final String FORMAT_JPEG = "JPEG";
	private static final String FORMAT_JPEG_DESCRIPTION = "jpeg";
	private static final String FORMAT_RAW = "RAW";
	private static final String FORMAT_RAW_DESCRIPTION = "raw";
	private static final String FORMAT_TIFF = "TIFF";
	private static final String FORMAT_TIFF_DESCRIPTION = "tiff";
	private static final String LENS_MANU = "CAMERA_LENS_MANUFACTURER";
	private static final String LANG_DEPENDENT_NAME_LENS_MANU = "Lens Manufacturer";
	private static final String LEICA = "LEICA";
	private static final String LEICA_DESCRIPTION = "Leica";
	private static final String CARL = "CARL_ZEISS";
	private static final String CARL_DESCRIPTION = "Carl Zeiss";
	private static final String LENS_TYPE = "CAMERA_LENS_TYPE";
	private static final String LANG_DEPENDENT_NAME_LENS_TYPE = "Lens Type";
	private static final String WIDE_ZOOM = "WIDE_ZOOM_17_35";
	private static final String WIDE_ZOOM_DESCRIPTION = "Wide Zoom (17-35 mm)";
	private static final String STANDARD_ZOOM = "STANDARD_ZOOM_24_70";
	private static final String STANDARD_ZOOM_DESCRIPTION = "Standard Zoom (24-70 mm)";
	private static final String TELEPHOTO_ZOOM = "TELEPHOTO_ZOOM_70_210";
	private static final String TELEPHOTO_ZOOM_DESCRIPTION = "Telephoto Zoom (70-210 mm)";
	private static final String TELEPHOTO_ZOOM_100 = "TELEPHOTO_ZOOM_120_300";
	private static final String TELEPHOTO_ZOOM_100_DESCRIPTION = "Telephoto Zoom (120-300 mm)";
	private static final String CAMERA_MAX_ISO = "CAMERA_MAX_ISO";
	private static final String LANG_DEPENDENT_NAME_CAMERA_MAX_ISO = "Maximum ISO";
	private static final String ISO_12800 = "12800";
	private static final String ISO_12800_DESCRIPTION = "12800";
	private static final String ISO_25600 = "25600";
	private static final String ISO_25600_DESCRIPTION = "25600";
	static final String CAMERA_MODE = "CAMERA_MODE";
	private static final String LANG_DEPENDENT_NAME_CAMERA_MODE = "Mode";
	static final String MODE_PROF = "P";
	private static final String MODE_PROF_DESCRIPTION = "Professional";
	static final String MODE_STANDARD = "S";
	private static final String MODE_STANDARD_DESCRIPTION = "Standard";
	private static final String C_OPTIONS = "CAMERA_OPTIONS";
	private static final String LANG_DEPENDENT_C_OPTIONS = "Additional Options";
	private static final String IMAGE_STABILIZATION = "I";
	private static final String IMAGE_STABILIZATION_DESCRIPTION = "Image Stabilization";
	private static final String WATERPROOF = "W";
	private static final String WATERPROOF_DESCRIPTION = "Waterproof and dust-tight";
	private static final String MOVIE = "M";
	private static final String MOVIE_DESCRIPTION = "Movie mode";
	private static final String WI_FI_NFC = "WI";
	private static final String WI_FI_NFC_DESCRIPTION = "Wi-Fi and NFC Connectivity";
	static final String CAMERA_PIXELS = "CAMERA_PIXELS";
	private static final String LANG_DEPENDENT_CAMERA_PIXELS = "Resolution (in MP)";
	static final String P8 = "P8";
	private static final String P8_DESCRIPTION = "8";
	private static final String P12 = "P12";
	private static final String P12_DESCRIPTION = "12";
	private static final String P16 = "P16";
	private static final String P16_DESCRIPTION = "16";
	private static final String P20 = "P20";
	private static final String P20_DESCRIPTION = "20";
	private static final String CAMERA_SD_CARD = "CAMERA_SD_CARD";
	private static final String LANG_DEPENDENT_CAMERA_SD_CARD = "SD Card Compatibility";
	private static final String SDHC = "SDHC";
	private static final String SDHC_DESCRIPTION = "SD High Capacity (SDHC)";
	private static final String SDXC = "SDXC";
	private static final String SDXC_DESCRIPTION = "SD Extended Capacity (SDXC)";
	private static final String CAMERA_SECOND_SLOT = "CAMERA_SECOND_SLOT";
	private static final String LANG_DEPENDENT_CAMERA_SECOND_SLOT = "Second Card Slot";
	private static final String YES = "Y";
	private static final String YES_DESCRIPTION = "Yes";
	private static final String NO = "N";
	private static final String NO_DESCRIPTION = "No";
	static final String CAMERA_SENSOR = "CAMERA_SENSOR";
	private static final String LANG_DEPENDENT_CAMERA_SENSOR = "Sensor Type";
	static final String COMPACT = "C";
	private static final String COMPACT_DESCRIPTION = "Compact Sensor";
	static final String FULL_FRAME = "F";
	private static final String FULL_FRAME_DESCRIPTION = "Full Frame Sensor";
	private static final String MICRO_FOUR_THIRDS = "M";
	private static final String MICRO_FOUR_THIRDS_DESCRIPTION = "Micro Four Thirds Sensor";
	private static final String CAMERA_TILTABLE = "CAMERA_TILTABLE";
	private static final String LANG_DEPENDENT_CAMERA_TILTABLE = "Tiltable";
	private static final String CAMERA_TOUCHSCREEN = "CAMERA_TOUCHSCREEN";
	private static final String LANG_DEPENDENT_CAMERA_TOUCHSCREEN = "Touchscreen";
	private static final String CAMERA_VIEWFINDER = "CAMERA_VIEWFINDER";
	private static final String LANG_DEPENDENT_CAMERA_VIEWFINDER = "Viewfinder";
	private static final String REAR_LCD_ONLY = "R";
	private static final String REAR_LCD_ONLY_DESCRIPTION = "Rear LCD only";
	private static final String ELECTRONIC = "E";
	private static final String ELECTRONIC_DESCRIPTION = "Electronic Viewfinder";
	private static final String OPTICAL = "O";
	private static final String OPTICAL_DESCRIPTION = "Optical Viewfinder";
	private static final String LANG_DEPENDENT_NAME_DISPLAY = "Display Resolution";

	private static final long SURCHARGE_F17 = 90;
	private static final long SURCHARGE_F28 = 60;
	private static final long SURCHARGE_STANDARD_ZOOM = 750;
	private static final long OBSOLETE_STANDARD_ZOOM = 800;
	private static final long SURCHARGE_TELEPHOTO_ZOOM = 25;
	private static final long SURCHARGE_TELEPHOTO_ZOOM_100 = 1300;
	private static final long SURCHARGE_IMAGE_STABILIZATION = 30;
	private static final long SURCHARGE_WATERPROOF = 70;
	private static final long OBSOLETE_WATERPROOF = 90;
	private static final long SURCHARGE_MOVIE = 20;
	private static final long SURCHARGE_WI_FI_NFC = 20;
	private static final long SURCHARGE_MAX_ISO_256 = 30;

	@Override
	public ConfigModel createDefaultConfiguration()
	{
		// Model
		final StringBuilder configurationText = new StringBuilder("Configuration for ");

		final ConfigModel model = createDefaultConfigModel(
				configurationText.append(ROOT_INSTANCE_NAME).append(",").append(getConfigId()).toString());
		setBasePrices(model);

		model.setKbId(KB_ID);

		// root instance
		final InstanceModel rootInstance = createDefaultRootInstance(model, ROOT_INSTANCE_NAME, ROOT_INSTANCE_LANG_DEP_NAME);

		// cstic groups:
		final List<CsticGroupModel> csticGroups = createCsticGroupList();
		rootInstance.setCsticGroups(csticGroups);

		// cstics and Values:
		final List<CsticModel> cstics = new ArrayList<>();
		cstics.add(createCsticAperture());
		cstics.add(createCsticColor());
		cstics.add(createCsticDisplayResolution());
		cstics.add(createCsticDataFormat());
		cstics.add(createCsticLensManufacture());
		cstics.add(createCsticLensType());
		cstics.add(createCsticMaxIso());
		cstics.add(createCsticMode());
		cstics.add(createCsticOptions());
		cstics.add(createCsticPixels());
		cstics.add(createCsticSD());
		cstics.add(createCsticSecondSlot());
		cstics.add(createCsticSensor());
		cstics.add(createCsticTiltable());
		cstics.add(createCsticTouch());
		cstics.add(createCsticViewfinder());

		rootInstance.setCstics(cstics);

		return model;
	}

	protected void setBasePrices(final ConfigModel model)
	{
		final PriceModel basePrice = createPrice(750);
		model.setBasePrice(basePrice);

		final PriceModel selectedOptionsPrice = createPrice(0);
		model.setSelectedOptionsPrice(selectedOptionsPrice);

		model.setCurrentTotalPrice(basePrice);
	}

	protected CsticModel createCsticViewfinder()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(CAMERA_VIEWFINDER, LANG_DEPENDENT_CAMERA_VIEWFINDER);
		builder.stringType().singleSelection();
		builder.addOption(REAR_LCD_ONLY, REAR_LCD_ONLY_DESCRIPTION).addOption(ELECTRONIC, ELECTRONIC_DESCRIPTION).addOption(OPTICAL,
				OPTICAL_DESCRIPTION);
		builder.withDefaultUIState();
		return builder.build();
	}

	protected CsticModel createCsticTouch()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(CAMERA_TOUCHSCREEN, LANG_DEPENDENT_CAMERA_TOUCHSCREEN);
		builder.stringType().singleSelection();
		builder.addOption(YES, YES_DESCRIPTION).addOption(NO, NO_DESCRIPTION);
		builder.withDefaultUIState();
		return builder.build();
	}

	protected CsticModel createCsticTiltable()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(CAMERA_TILTABLE, LANG_DEPENDENT_CAMERA_TILTABLE);
		builder.stringType().singleSelection();
		builder.addOption(YES, YES_DESCRIPTION).addOption(NO, NO_DESCRIPTION);
		builder.withDefaultUIState();
		return builder.build();
	}

	protected CsticModel createCsticSensor()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(CAMERA_SENSOR, LANG_DEPENDENT_CAMERA_SENSOR);
		builder.stringType().singleSelection();
		builder.addOption(COMPACT, COMPACT_DESCRIPTION).addOption(FULL_FRAME, FULL_FRAME_DESCRIPTION).addOption(MICRO_FOUR_THIRDS,
				MICRO_FOUR_THIRDS_DESCRIPTION);
		builder.withDefaultUIState();
		return builder.build();
	}

	protected CsticModel createCsticSecondSlot()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(CAMERA_SECOND_SLOT, LANG_DEPENDENT_CAMERA_SECOND_SLOT);
		builder.stringType().singleSelection();
		builder.addOption(YES, YES_DESCRIPTION).addOption(NO, NO_DESCRIPTION);
		builder.withDefaultUIState();
		return builder.build();
	}

	protected CsticModel createCsticSD()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(CAMERA_SD_CARD, LANG_DEPENDENT_CAMERA_SD_CARD);
		builder.stringType().multiSelection();
		builder.addOption(SDHC, SDHC_DESCRIPTION).addOption(SDXC, SDXC_DESCRIPTION);
		builder.withDefaultUIState();
		return builder.build();
	}

	protected CsticModel createCsticPixels()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(CAMERA_PIXELS, LANG_DEPENDENT_CAMERA_PIXELS);
		builder.stringType().singleSelection();
		builder.addOption(P8, P8_DESCRIPTION).addOption(P12, P12_DESCRIPTION).addOption(P16, P16_DESCRIPTION).addOption(P20,
				P20_DESCRIPTION);
		builder.withDefaultUIState();
		return builder.build();
	}

	protected CsticModel createCsticOptions()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(C_OPTIONS, LANG_DEPENDENT_C_OPTIONS);
		builder.stringType().multiSelection();
		builder.addOption(IMAGE_STABILIZATION, IMAGE_STABILIZATION_DESCRIPTION).addOption(WATERPROOF, WATERPROOF_DESCRIPTION)
				.addOption(MOVIE, MOVIE_DESCRIPTION).addOption(WI_FI_NFC, WI_FI_NFC_DESCRIPTION);
		builder.withDefaultUIState();
		return builder.build();
	}

	@Override
	public void checkCstic(final ConfigModel model, final InstanceModel instance, final CsticModel cstic)
	{
		super.checkCstic(model, instance, cstic);

		if (cstic.getName().equalsIgnoreCase(CAMERA_PIXELS))
		{
			checkPixels(instance, cstic);
		}
		if (cstic.getName().equalsIgnoreCase(CAMERA_SENSOR))
		{
			checkSensor(instance, cstic);
		}

		if (cstic.getName().equalsIgnoreCase(APERTURE))
		{
			resetValuePrices(cstic);
			handleValuePrice(model, cstic, F17, BigDecimal.valueOf(SURCHARGE_F17));
			handleValuePrice(model, cstic, F28, BigDecimal.valueOf(SURCHARGE_F28));
		}

		if (cstic.getName().equalsIgnoreCase(LENS_TYPE))
		{
			resetValuePrices(cstic);
			handleValuePrice(model, cstic, STANDARD_ZOOM, BigDecimal.valueOf(SURCHARGE_STANDARD_ZOOM),
					BigDecimal.valueOf(OBSOLETE_STANDARD_ZOOM));
			handleValuePrice(model, cstic, TELEPHOTO_ZOOM, BigDecimal.valueOf(SURCHARGE_TELEPHOTO_ZOOM));
			handleValuePrice(model, cstic, TELEPHOTO_ZOOM_100, BigDecimal.valueOf(SURCHARGE_TELEPHOTO_ZOOM_100));
		}

		if (cstic.getName().equalsIgnoreCase(C_OPTIONS))
		{
			resetValuePrices(cstic);
			handleValuePrice(model, cstic, IMAGE_STABILIZATION, BigDecimal.valueOf(SURCHARGE_IMAGE_STABILIZATION));
			handleValuePrice(model, cstic, WATERPROOF, BigDecimal.valueOf(SURCHARGE_WATERPROOF),
					BigDecimal.valueOf(OBSOLETE_WATERPROOF));
			handleValuePrice(model, cstic, MOVIE, BigDecimal.valueOf(SURCHARGE_MOVIE));
			handleValuePrice(model, cstic, WI_FI_NFC, BigDecimal.valueOf(SURCHARGE_WI_FI_NFC));
		}



		if (cstic.getName().equalsIgnoreCase(CAMERA_MAX_ISO))
		{
			resetValuePrices(cstic);
			handleValuePrice(model, cstic, ISO_25600, BigDecimal.valueOf(SURCHARGE_MAX_ISO_256));

		}
	}

	protected void checkSensor(final InstanceModel instance, final CsticModel cstic)
	{

		final List<CsticValueModel> assignedValues = instance.getCstic(CAMERA_MODE).getAssignedValues();


		if (!CollectionUtils.isEmpty(assignedValues))
		{
			setSensorCsticForMode(assignedValues.get(0).getName(), cstic);
		}
	}

	protected void setSensorCsticForMode(final String name, final CsticModel cstic)
	{
		final List<CsticValueModel> assignableValues = new ArrayList<>();

		if (MODE_PROF.equals(name))
		{
			final CsticValueModel valueFullFrame = new CsticValueModelBuilder().withName(FULL_FRAME, FULL_FRAME_DESCRIPTION).build();
			assignableValues.add(valueFullFrame);
			resetValueIfNeeded(cstic, COMPACT);
		}
		else
		{
			final CsticValueModel compactValue = new CsticValueModelBuilder().withName(COMPACT, COMPACT_DESCRIPTION).build();
			assignableValues.add(compactValue);
			resetValueIfNeeded(cstic, FULL_FRAME);
		}

		final CsticValueModel microValue = new CsticValueModelBuilder().withName(MICRO_FOUR_THIRDS, MICRO_FOUR_THIRDS_DESCRIPTION)
				.build();
		assignableValues.add(microValue);

		cstic.setAssignableValues(assignableValues);

	}

	protected void resetValueIfNeeded(final CsticModel cstic, final String valueToRemove)
	{
		final List<CsticValueModel> assignedValues = cstic.getAssignedValues();
		if (!CollectionUtils.isEmpty(assignedValues) && assignedValues.get(0).getName().equals(valueToRemove))
		{
			cstic.setAssignedValues(Collections.emptyList());
		}
	}

	@Override
	public void checkModel(final ConfigModel model)
	{
		setBasePrices(model);
		super.checkModel(model);
	}

	protected void checkPixels(final InstanceModel instance, final CsticModel cstic)
	{
		final List<CsticValueModel> assignedValues = instance.getCstic(CAMERA_MODE).getAssignedValues();


		if (!CollectionUtils.isEmpty(assignedValues))
		{
			if (assignedValues.get(0).getName().equals(MODE_PROF))
			{
				cstic.removeAssignableValue(P8);
				resetValueIfNeeded(cstic, P8);
			}
			else
			{
				resetPixelCstic(cstic);
			}
		}

	}

	protected void resetPixelCstic(final CsticModel cstic)
	{
		final CsticValueModel valueModel8 = new CsticValueModelBuilder().withName(P8, P8_DESCRIPTION).build();
		final CsticValueModel valueModel12 = new CsticValueModelBuilder().withName(P12, P12_DESCRIPTION).build();
		final CsticValueModel valueModel16 = new CsticValueModelBuilder().withName(P16, P16_DESCRIPTION).build();
		final CsticValueModel valueModel20 = new CsticValueModelBuilder().withName(P20, P20_DESCRIPTION).build();

		final List<CsticValueModel> assignableValues = new ArrayList<>();
		assignableValues.add(valueModel8);
		assignableValues.add(valueModel12);
		assignableValues.add(valueModel16);
		assignableValues.add(valueModel20);
		cstic.setAssignableValues(assignableValues);

	}

	protected CsticModel createCsticAperture()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(APERTURE, LANG_DEPENDENT_APERTURE);
		builder.stringType().singleSelection();
		builder.addOption(F17, F17_DESCRIPTION).addOption(F28, F28_DESCRIPTION).addOption(F35, F35_DESCRIPTION);
		builder.withDefaultUIState();
		return builder.build();
	}

	protected CsticModel createCsticColor()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(CAMERA_COLOUR, LANG_DEPENDENT_CAMERA_COLOUR);
		builder.stringType().singleSelection();
		builder.addOption(BLACK, BLACK_DESCRIPTION).addOption(WHITE, WHITE_DESCRIPTION);
		return builder.build();
	}

	protected CsticModel createCsticMode()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(CAMERA_MODE, LANG_DEPENDENT_NAME_CAMERA_MODE);
		builder.stringType().singleSelection();
		builder.addOption(MODE_PROF, MODE_PROF_DESCRIPTION).addOption(MODE_STANDARD, MODE_STANDARD_DESCRIPTION);
		builder.withDefaultUIState().required();
		return builder.build();
	}

	protected CsticModel createCsticMaxIso()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(CAMERA_MAX_ISO, LANG_DEPENDENT_NAME_CAMERA_MAX_ISO);
		builder.stringType().singleSelection();
		builder.addOption(ISO_12800, ISO_12800_DESCRIPTION).addOption(ISO_25600, ISO_25600_DESCRIPTION);
		builder.withDefaultUIState();
		return builder.build();
	}

	protected CsticModel createCsticLensType()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(LENS_TYPE, LANG_DEPENDENT_NAME_LENS_TYPE);
		builder.stringType().singleSelection();
		builder.addOption(WIDE_ZOOM, WIDE_ZOOM_DESCRIPTION).addOption(STANDARD_ZOOM, STANDARD_ZOOM_DESCRIPTION)
				.addOption(TELEPHOTO_ZOOM, TELEPHOTO_ZOOM_DESCRIPTION).addOption(TELEPHOTO_ZOOM_100, TELEPHOTO_ZOOM_100_DESCRIPTION);
		builder.withDefaultUIState();
		return builder.build();
	}

	protected CsticModel createCsticLensManufacture()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(LENS_MANU, LANG_DEPENDENT_NAME_LENS_MANU);
		builder.stringType().singleSelection();
		builder.addOption(LEICA, LEICA_DESCRIPTION).addOption(CARL, CARL_DESCRIPTION);

		builder.withDefaultUIState();
		return builder.build();
	}

	protected CsticModel createCsticDataFormat()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(FORMAT_PICTURE, LANG_DEPENDENT_NAME_FORMAT_PICTURE);
		builder.stringType().singleSelection();
		builder.addOption(FORMAT_JPEG, FORMAT_JPEG_DESCRIPTION).addOption(FORMAT_RAW, FORMAT_RAW_DESCRIPTION).addOption(FORMAT_TIFF,
				FORMAT_TIFF_DESCRIPTION);
		builder.withDefaultUIState().required();
		return builder.build();
	}

	protected CsticModel createCsticDisplayResolution()
	{
		final CsticModelBuilder builder = new CsticModelBuilder().withInstance(ROOT_INSTANCE_ID, ROOT_INSTANCE_NAME);
		builder.withName(DISPLAY, LANG_DEPENDENT_NAME_DISPLAY);
		builder.stringType().singleSelection();
		builder.addOption(PIXELS5, PIXELS5_DESCRIPTION).addOption(PIXELS10, PIXELS10_DESCRIPTION);
		builder.withDefaultUIState().required();
		return builder.build();
	}


	protected List<CsticGroupModel> createCsticGroupList()
	{
		final List<CsticGroupModel> groups = new ArrayList<>();


		addCsticGroup(groups, InstanceModel.GENERAL_GROUP_NAME, null, null);


		addCsticGroup(groups, "1", "Basics", CAMERA_MODE, CAMERA_COLOUR);


		addCsticGroup(groups, "2", "Specification", CAMERA_PIXELS, CAMERA_SENSOR, APERTURE, CAMERA_VIEWFINDER, CAMERA_SD_CARD,
				CAMERA_SECOND_SLOT, FORMAT_PICTURE, CAMERA_MAX_ISO);


		addCsticGroup(groups, "3", "Display", DISPLAY, CAMERA_TOUCHSCREEN, CAMERA_TILTABLE);

		addCsticGroup(groups, "4", "Lens", LENS_MANU, LENS_TYPE);

		addCsticGroup(groups, "5", "Options", C_OPTIONS);

		return groups;
	}
}
