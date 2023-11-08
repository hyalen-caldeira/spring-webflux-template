package us.hyalen.webfluxtemplate.core.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import us.hyalen.webfluxtemplate.model.entity.Employee;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {
}