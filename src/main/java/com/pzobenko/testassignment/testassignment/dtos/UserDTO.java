package com.pzobenko.testassignment.testassignment.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {

  Long id;
  String firstName;
  String lastName;
  int age;

  @Override
  public String toString() {
    return "UserDTO{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", age=" + age +
        '}';
  }
}
