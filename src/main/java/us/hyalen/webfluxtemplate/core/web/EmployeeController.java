package us.hyalen.webfluxtemplate.core.web;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import us.hyalen.webfluxtemplate.core.dto.EmployeeDto;
import us.hyalen.webfluxtemplate.core.dto.ResponseDto;
import us.hyalen.webfluxtemplate.core.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

//    @GetMapping("{id}")
//    public Mono<EmployeeDto> getEmployee(@PathVariable("id") String employeeId) {
//        return employeeService.getEmployee(employeeId);
//    }

//    @GetMapping("{id}")
//    public ResponseEntity<ResponseDto<Mono<EmployeeDto>>> getEmployee(@PathVariable("id") String employeeId) {
//        // Get employee by id and save to employeeMono
//        Mono<EmployeeDto> employeeMono = employeeService.getEmployee(employeeId);
//
//        // Return employeeMono as ResponseEntity
//        return ResponseEntity.ok(ResponseDto.forSuccess(employeeMono));
//    }

    @GetMapping("{id}")
    public Mono<ResponseDto<EmployeeDto>> getEmployee(@PathVariable("id") String employeeId) {
        // Get employee by id and save to employeeMono
        return employeeService.getEmployee(employeeId).map(dto -> ResponseDto.forSuccess(dto));
    }

    @GetMapping
    public Flux<ResponseDto<EmployeeDto>> getAllEmployees() {
        // Return something similar to employeeService.updateEmployee(employeeDto, employeeId).map(dto -> ResponseDto.forSuccess(dto)); but using flux
        // Get all employees and save to employeeFlux
        return employeeService.getAllEmployees().map(dto -> ResponseDto.forSuccess(dto));
        // Flux<ResponseDto<EmployeeDto>> employeeFlux = employeeService.getAllEmployees().map(dto -> ResponseDto.forSuccess(dto));

        // Return employeeFlux as ResponseEntity
        // return ResponseEntity.ok(ResponseDto.forSuccess(employeeFlux));

        // Return employeeFlux as Flux<ResponseDto<EmployeeDto>>
        // return employeeService.getAllEmployees();
    }

    @PutMapping("{id}")
    public Mono<ResponseDto<EmployeeDto>> updateEmployee(@RequestBody EmployeeDto employeeDto,
                                            @PathVariable("id") String employeeId) {
        return employeeService.updateEmployee(employeeDto, employeeId).map(dto -> ResponseDto.forSuccess(dto));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployee(@PathVariable("id") String employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}