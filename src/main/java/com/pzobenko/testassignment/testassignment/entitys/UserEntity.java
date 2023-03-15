package com.pzobenko.testassignment.testassignment.entitys;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

  @Id
  @NotNull
  @GeneratedValue
  Long id;
  @NotNull
  String firstName;
  @NotNull
  String lastName;
  @Past
  @NotNull
  LocalDate dateOfBirthday;

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", dateOfBirthday=" + dateOfBirthday +
        '}';
  }
}
