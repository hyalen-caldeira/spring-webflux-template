package us.hyalen.webfluxtemplate.core.web;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.hyalen.webfluxtemplate.core.service.IncidentService;

@RestController("IncidentController_v1")
@RequestMapping("api/incidents")
@AllArgsConstructor
public class IncidentController {
    private IncidentService incidentService;

    // Create method to retrieve incidents
    // Use getIncidents() method from IncidentService
    // Use WebClient to call the endpoint
    // Use retrieve() to get the response
    // Use bodyToMono() to get the body of the response
    // Use block() to block and return the body of the response

    @GetMapping
    public String retrieveIncidents() {
        return incidentService.retrieveIncidents();
    }
}
