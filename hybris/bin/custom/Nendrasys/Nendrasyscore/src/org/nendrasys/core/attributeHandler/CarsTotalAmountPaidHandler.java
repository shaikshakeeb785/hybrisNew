package org.nendrasys.core.attributeHandler;

import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.nendrasys.core.model.CarsModel;

public class CarsTotalAmountPaidHandler implements DynamicAttributeHandler<Double,CarsModel> {

    public static final Logger logger = LogManager.getLogger(CarsTotalAmountPaidHandler.class);

    @Override
    public Double get(CarsModel model) {

        BasicConfigurator.configure();

        double roundOffTotalAmountPaidValue=Math.round(Float.parseFloat(model.getPrice()));
        return roundOffTotalAmountPaidValue;
    }

    @Override
    public void set(CarsModel model, Double aDouble) {

    }

}
