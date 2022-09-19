package inventory.test;

import inventory.entity.Product;
import jakarta.persistence.*;

import java.util.List;

public class QuerySingle {

    public static void main(String[] args) {

        double salesPriceMin = 1000;

        Product product = null;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String jpql = "select product from Product as product where product.salesPrice < :salesPriceMin";
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);//Bunu yazmasak yukarıdakini direkt kullansak da olurdu ama böyle daha iyi. Hangi tipte nesne tutan bir liste döneceğini söylüyoruz
        query.setParameter("salesPriceMin", salesPriceMin);

        try {

            product = query.getSingleResult(); //Veri bulamazsa hata döner bu yüzden try cath'e al. Birden fazla veri olursa yine hata döner bunun önlemini almak doğru değil ama cath ile yakalanabilir.
            System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
        } catch (NoResultException e) {

            product = null;
            System.out.println("Sonuç yok!");
        }

        entityManager.close();

    }

}
