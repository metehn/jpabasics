package inventory.test;

import inventory.entity.Product;
import jakarta.persistence.*;

import java.util.List;

public class QueryList {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String jpql = "select product from Product as product";

        //Query query = entityManager.createStoredProcedureQuery(jpql);
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);//Bunu yazmasak yukarıdakini direkt kullansak da olurdu ama böyle daha iyi. Handgi tipte nesne tutan bir liste döneceğini söylüyoruz

        List<Product> productList = query.getResultList(); //Veri bulamazsa boş liste döner

        entityManager.close();

        for (Product product : productList) {

            System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
        }

    }
}
