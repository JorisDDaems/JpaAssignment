package be.intecbrussel.Daos;

import be.intecbrussel.Entities.ProductLine;

public interface ProductLineDao {

        void createProductLine(ProductLine productLine);
        ProductLine readProductLine(String productLine);
        void updateProductLine(ProductLine productLine);
        void deleteProductline(ProductLine productLine);

}
