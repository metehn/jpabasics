package human.test;

import human.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class RelationQuery {

    public static void main(String[] args) {
        long departmentId= 2;


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager entityManager = factory.createEntityManager();

        String jpql = "select employee from Employee as employee where employee.department.departmentId= :departmentId";

        TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);//Bunu yazmasak yukarıdakini direkt kullansak da olurdu ama böyle daha iyi. Handgi tipte nesne tutan bir liste döneceğini söylüyoruz
        query.setParameter("departmentId", departmentId);

        List<Employee> employeeList = query.getResultList(); //Veri bulamazsa boş liste döner

        entityManager.close();

        for (Employee employee : employeeList) {

            System.out.println(employee.getEmployeeId() + " " + employee.getEmployeeName() + " " + employee.getMonthlySalary() + " " + employee.getDepartment().getDepartmentName());
        }

    }

}
