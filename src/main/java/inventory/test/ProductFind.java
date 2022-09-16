package inventory.test;

import inventory.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductFind {

    public static void main(String[] args) {

        long productId=1;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager =factory.createEntityManager();

        Product product = entityManager.find(Product.class, productId);

        System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());

        entityManager.close();
    }

}
