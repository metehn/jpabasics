package jpabasics;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager =factory.createEntityManager();

        Data data = new Data();
        data.setDataName("Ersoy");
        data.setDataValue(323);

        entityManager.getTransaction().begin();

        entityManager.persist(data);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

}
