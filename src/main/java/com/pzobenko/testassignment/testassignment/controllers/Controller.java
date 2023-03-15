package com.pzobenko.testassignment.testassignment.controllers;

import com.pzobenko.testassignment.testassignment.dtos.UserDTO;
import com.pzobenko.testassignment.testassignment.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "Controller API", description = "This controller have one endpoint and"
    + " this endpoint give user info by id")
@RequiredArgsConstructor
public class Controller {

  private final UserService service;

  @GetMapping(value = "/{id}", produces = "application/json")
  @Operation(summary = "Get user by id", description = "this method for getting user by id")
  public EntityModel<UserDTO> getUserById(@PathVariable Long id) {
    return EntityModel.of(service.getUserByIdAndCalculateAge(id));
  }

}
