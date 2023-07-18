package be.ipam.SpringSecuritySB2.model;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
  
    @GetMapping(value = "/hello-world", produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloWorld() {
        return "{\"message\": \"Hello World\"}";
    }
  
    @GetMapping(value = "/hello-spring-security", produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloSpringSecurity() {
        return "{\"message\": \"Hello Spring Security\"}";
    }
}