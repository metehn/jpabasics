package human.test;

import human.entity.Department;
import human.entity.Employee;
import inventory.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RelationFind {

    public static void main(String[] args) {

        long departmentId=1;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager =factory.createEntityManager();

        Department departmentA = entityManager.find(Department.class, departmentId);

        Department departmentB = entityManager.getReference(Department.class, departmentId);


        System.out.println( departmentA.getDepartmentId() + " " +departmentA.getDepartmentName() + " " + departmentA.getEmployeeList().size() );
        System.out.println( departmentB.getDepartmentId() + " " +departmentB.getDepartmentName() + " " + departmentB.getEmployeeList().size() );

        entityManager.close();

        for(Employee employee : departmentB.getEmployeeList()){

            System.out.println(employee.getEmployeeName());
        }


    }


}
