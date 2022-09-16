package human.test;

import human.entity.Department;
import human.entity.Employee;
import inventory.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RelationPersist {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager =factory.createEntityManager();

        Department departmentA = new Department(0,"Yazilim");

        Employee employee1 = new Employee(0,"Calisan1",11000);
        employee1.setDepartment(departmentA);
        departmentA.getEmployeeList().add(employee1);

        Employee employee2 = new Employee(0,"Calisan2",9700);
        employee2.setDepartment(departmentA);
        departmentA.getEmployeeList().add(employee2);

        Employee employee3 = new Employee(0,"Calisan3",14000);
        employee3.setDepartment(departmentA);
        departmentA.getEmployeeList().add(employee3);


        entityManager.getTransaction().begin();

        entityManager.persist(departmentA);

        entityManager.getTransaction().commit();

        entityManager.close();

    }

}
