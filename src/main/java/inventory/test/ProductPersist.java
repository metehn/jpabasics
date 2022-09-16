package inventory.test;

import inventory.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class ProductPersist {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager =factory.createEntityManager();

        Product product = new Product("Iphone12",25000);

        entityManager.getTransaction().begin();

        entityManager.persist(product);

        entityManager.getTransaction().commit();

        entityManager.close();

    }

}
