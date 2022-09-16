package inventory.test;

import inventory.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductMerge {

    public static void main(String[] args) {

        long productId=1;
        double newSalesPrice = 16000;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager =factory.createEntityManager();

        Product product = entityManager.find(Product.class, productId);
        product.setSalesPrice(newSalesPrice);

        entityManager.getTransaction().begin();

        entityManager.merge(product);

        entityManager.getTransaction().commit();

        entityManager.close();

    }

}
