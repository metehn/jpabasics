package inventory.test;

import inventory.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductRemove {

    public static void main(String[] args) {

        long productId=2;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager =factory.createEntityManager();

        //Product product = entityManager.find(Product.class, productId);
        Product product = entityManager.getReference(Product.class, productId); // find() 'e göre daha performanslı. Büyük nesnelerde find yavaş kalabiliyor

        entityManager.getTransaction().begin();

        entityManager.remove(product);

        entityManager.getTransaction().commit();

        entityManager.close();

    }

}
