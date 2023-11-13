package us.hyalen.webfluxtemplate.core.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import us.hyalen.webfluxtemplate.core.service.IncidentService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IncidentControllerTest {
    @Autowired
    private IncidentService incidentService;

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void retrieveIncidents() {
        webTestClient.get().uri("/api/incidents")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.incidents").isArray()
                .jsonPath("$.incidents[0].number").isEqualTo("INC0000001")
                .jsonPath("$.incidents[0].short_description").isEqualTo("Can't read email");
    }
    // Use WebTestClient to test the endpoint
    // Use get() to get the response
    // Use uri() to set the uri
    // Use exchange() to get the response
    // Use expectStatus() to check the status
    // Use expectBody() to check the body
    // Use jsonPath() to check the body
    // Use isEqualTo() to check the body
}