package com.pzobenko.testassignment.testassignment.services;

import com.pzobenko.testassignment.testassignment.dtos.UserDTO;
import com.pzobenko.testassignment.testassignment.entitys.UserEntity;
import com.pzobenko.testassignment.testassignment.exceptions.TheUserNotFoundException;
import com.pzobenko.testassignment.testassignment.reposytories.UserRepo;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepo repository;

  public UserDTO getUserByIdAndCalculateAge(Long id) {
    UserEntity userFromDB = getUserEntityFromDB(id);
    UserDTO userWithCalculatedAge = mapEntityToDTO(userFromDB);
    userWithCalculatedAge.setAge(calculateAge(userFromDB.getDateOfBirthday()));
    return userWithCalculatedAge;
  }

  private UserEntity getUserEntityFromDB(Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new TheUserNotFoundException(id));
  }

  private UserDTO mapEntityToDTO(UserEntity userEntityFromDB) {
    return UserDTO.builder()
        .id(userEntityFromDB.getId())
        .firstName(userEntityFromDB.getFirstName())
        .lastName(userEntityFromDB.getLastName())
        .build();
  }

  private int calculateAge(LocalDate dateOfBirthday) {
    LocalDate dateNow = LocalDate.now();
    int age = dateNow.getYear() - dateOfBirthday.getYear();
    if (dateNow.getMonth().getValue() < dateOfBirthday.getMonth().getValue()) {
      return age - 1;
    } else if (dateNow.getMonth().getValue() == dateOfBirthday.getMonth().getValue()
        && dateNow.getDayOfMonth() < dateOfBirthday.getDayOfMonth()) {
      return age - 1;
    } else {
      return age;
    }
  }
}
