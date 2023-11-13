package us.hyalen.webfluxtemplate.core.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import us.hyalen.webfluxtemplate.core.dto.EmployeeDto;

public interface EmployeeService {
    Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);
    Mono<EmployeeDto> getEmployee(String employeeId);
    Flux<EmployeeDto> getAllEmployees();
    Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String employeeId);
    Mono<Void> deleteEmployee(String employeeId);
}