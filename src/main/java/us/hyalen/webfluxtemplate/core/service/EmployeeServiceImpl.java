package us.hyalen.webfluxtemplate.core.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import us.hyalen.webfluxtemplate.core.NotFoundException;
import us.hyalen.webfluxtemplate.core.dto.EmployeeDto;
import us.hyalen.webfluxtemplate.core.mapper.EmployeeMapper;
import us.hyalen.webfluxtemplate.core.repository.EmployeeRepository;
import us.hyalen.webfluxtemplate.model.entity.Employee;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = employeeRepository.save(employee);

        return savedEmployee
                .map((employeeEntity) -> EmployeeMapper.mapToEmployeeDto(employeeEntity));
    }

    @Override
    public Mono<EmployeeDto> getEmployee(String employeeId) {
        Mono<Employee> employeeMono = employeeRepository.findById(employeeId);

        // Launch not found exception if employeeId not found
        // employeeMono.switchIfEmpty(Mono.error(new NotFoundException("Employee not found")));

        // Launch bad request exception if employeeId not found
        // employeeMono.switchIfEmpty(Mono.error(new BadRequestException("Employee not found")));

        // Return employeeMono if found

        return employeeMono.map((employee -> EmployeeMapper.mapToEmployeeDto(employee)));
    }

    @Override
    public Flux<EmployeeDto> getAllEmployees() {

        Flux<Employee> employeeFlux  = employeeRepository.findAll();

        return employeeFlux
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto, String employeeId) {

        Mono<Employee> employeeMono = employeeRepository.findById(employeeId);

        return employeeMono.flatMap((existingEmployee) -> {
            existingEmployee.setFirstName(employeeDto.getFirstName());
            existingEmployee.setLastName(employeeDto.getLastName());
            existingEmployee.setEmail(employeeDto.getEmail());
            return employeeRepository.save(existingEmployee);
        }).map((employee -> EmployeeMapper.mapToEmployeeDto(employee)));
    }

    @Override
    public Mono<Void> deleteEmployee(String employeeId) {
        return employeeRepository.deleteById(employeeId);
    }
}