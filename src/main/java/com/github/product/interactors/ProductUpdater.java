package com.github.product.interactors;

import com.github.product.entities.Product;
import com.github.product.exceptions.InternalServerError;

import java.lang.reflect.Field;

public class ProductUpdater {

    public static void updateProduct(Product productFounded, Product product) {
        try {
            Field[] fields = Product.class.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                Object newValue = field.get(product);
                Object existingValue = field.get(productFounded);

                if (newValue != null && !newValue.equals(existingValue)) {
                    field.set(productFounded, newValue);
                }
            }
        } catch (IllegalAccessException ex) {
            throw new InternalServerError("Cannot access this field");
        }

    }
}
