package be.intecbrussel.Daos;

import be.intecbrussel.Entities.Product;

public interface ProductDao {

        void createProduct(Product product);
        Product readProduct (String productCode);
        void updateProduct (Product product);
        void deleteProduct (Product product);

}
