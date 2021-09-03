package org.nendrasys.core.attributeHandler;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;

import java.util.Calendar;
import java.util.Date;

public class ElectronicsColorVariantProductHandler implements DynamicAttributeHandler<Boolean, ProductModel> {
    public static final Logger logger = LogManager.getLogger(ElectronicsColorVariantProductHandler.class);

    @Override
    public Boolean get(final ProductModel model)

    {
        BasicConfigurator.configure();
        int productAge = 0;

            final Date customerRegisteredDate = model.getCreationtime();
            System.out.println("PRODUCT ADDED TO DATA BASE IN "+customerRegisteredDate);
            final Calendar cal = Calendar.getInstance();
            System.out.println("Calender inStance:"+cal);

            cal.setTime(customerRegisteredDate);
            final int registeredDATE = cal.get(Calendar.DATE);
            System.out.println("product added into database on"+registeredDATE);

            final int currentDATE = Calendar.getInstance().get(Calendar.DATE);
            productAge = currentDATE - registeredDATE;
            System.out.println("How many days till today the product is on database :"+productAge);

            if(productAge>=20)
            {
                return false;
            }
            else {
                return true;
            }

    }
    @Override
    public void set(ProductModel model, Boolean aBoolean) {

    }
}
