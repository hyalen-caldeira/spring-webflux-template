package us.hyalen.webfluxtemplate.core.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import us.hyalen.webfluxtemplate.model.entity.Employee;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {
}