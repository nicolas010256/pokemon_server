package pokemon.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pokemon.server.exception.ResourceNotFoundException;

@RestController
public class TestController {

  @GetMapping("/test")
  public void teste() {
    throw new ResourceNotFoundException("Error teste");
  }

}