package us.hyalen.webfluxtemplate.core.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class IncidentServiceImpl implements IncidentService {
    private final WebClient webClient;

    @Override
    public String retrieveIncidents() {
        return webClient.get()
                .uri("incident")
                .retrieve()
                .bodyToMono(String.class)
                .block(); // This is a simplified example; consider using non-blocking code in a real application
    }
}
