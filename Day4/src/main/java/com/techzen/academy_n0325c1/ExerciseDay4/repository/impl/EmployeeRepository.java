package com.techzen.academy_n0325c1.ExerciseDay4.repository.impl;

import com.techzen.academy_n0325c1.ExerciseDay4.dto.employee.EmployeeSearchRequest;
import com.techzen.academy_n0325c1.ExerciseDay4.enums.Gender;
import com.techzen.academy_n0325c1.ExerciseDay4.model.Employee;
import com.techzen.academy_n0325c1.ExerciseDay4.repository.IEmployeeRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeRepository implements IEmployeeRepository {
    List<Employee> employees = new ArrayList<>(
            Arrays.asList(
                    new Employee(UUID.randomUUID(), "Hoàng Văn Hải", LocalDate.of(1990, 1, 15),
                            Gender.MALE, 15000000.00, "0975123542", 1),
                    new Employee(UUID.randomUUID(), "Trần Thị Hoài", LocalDate.of(1985, 5, 20),
                            Gender.FEMALE, 14500000.00, "096786968", 2),
                    new Employee(UUID.randomUUID(), "Lê Văn Sỹ", LocalDate.of(1992, 3, 10),
                            Gender.MALE, 15500000.00, "0988881110", 3),
                    new Employee(UUID.randomUUID(), "Phạm Duy Khánh", LocalDate.of(1988, 7, 5),
                            Gender.FEMALE, 14800000.00, "0986555333", 4),
                    new Employee(UUID.randomUUID(), "Hoàng Văn Hải", LocalDate.of(1995, 9, 25),
                            Gender.MALE, 15200000.00, "0973388668", 4)
            )
    );


    public List<Employee> findByAttributes(EmployeeSearchRequest request) {
        Session session = ConnectionUtil.sessionFactory.openSession();

        // sử dụng HQL
        String hql = "FROM Employee e LEFT JOIN FETCH e.department WHERE"
                + "(:name IS NULL OR lower(e.name) LIKE CONCAT('%', :name, '%')"
                + "AND (:dobFrom IS NULL OR e.dob >= dobFrom)"
                + "AND (:doTo IS NULL OR e.dob >= doTo)"
                + "AND (:gender IS NULL OR e.gender = :gender)"
                + "AND (:phone IS NULL OR e.phone >= LIKE CONCAT('%', :phone, '%'))"
                + "AND (:department IS NULL OR e.department.id = :departmentId)";

        // xử lý salary range
        if (request.getSalaryRange() != null) {
            hql += "AND (";
            switch (request.getSalaryRange()) {
                case "lt5":
                    hql += " e.salary < 5000000";
                    break;
                case "5-10":
                    hql = " e.salary >= 5000000 AND e.salary < 10000000";
                case "10-20":
                    hql = " e.salary >= 10000000 AND e.salary <= 20000000";
                case "20":
                    hql = " e.salary > 20000000 ";
                    break;
            }
            hql += ")";
        }

        Query<Employee> query = session.createQuery(hql, Employee.class);

        // Đặt giá trị cho tham số
        query.setParameter("name", request.getName());
        query.setParameter("dobFrom", request.getDobFrom());
        query.setParameter("dobTo", request.getDobTo());
        query.setParameter("gender", request.getGender());
        query.setParameter("phone", request.getPhone());
        query.setParameter("departmentId", request.getDepartmentID());

        return query.getResultList();
    }


    public Optional<Employee> findById(UUID id) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        String sql = "SELECT * FROM Student WHERE id = :id";
        Query<Employee> query = session.createNativeQuery(sql, Employee.class);

        query.setParameter("id", id); // Chuyển đổi UUID thành String

        return query.uniqueResultOptional();
    }

    public Employee save(Employee student) {
        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {

                session.saveOrUpdate(student);

                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback(); // Rollback nếu có lỗi
                }
                throw new RuntimeException(e);
            }
        }
        return student;
    }

    public void delete(UUID id) {
        findById(id).ifPresent(employees::remove);
    }
}
