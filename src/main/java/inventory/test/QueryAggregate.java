package inventory.test;

import inventory.entity.Product;
import jakarta.persistence.*;

public class QueryAggregate {

    public static void main(String[] args) {

        double salesPriceMin = 1000;

        Product product = null;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String jpql = "select count(product) from Product as product where product.salesPrice < :salesPriceMin";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        query.setParameter("salesPriceMin", salesPriceMin);

        long count = (Long) query.getSingleResult();

        System.out.println(count);

        entityManager.close();

    }
}
