package com.pzobenko.testassignment.testassignment.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import com.pzobenko.testassignment.testassignment.entitys.UserEntity;
import com.pzobenko.testassignment.testassignment.exceptions.TheUserNotFoundException;
import com.pzobenko.testassignment.testassignment.reposytories.UserRepo;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  private UserRepo repository;

  private UserService serviceToTest;

  @BeforeEach
  void setUp() {
    serviceToTest = new UserService(repository);
  }

  @Test
  void getUserByIdAndCalculateAgeWithExistUserAgeWill19() {
    int expectedResult = 19;

    UserEntity entity = UserEntity.builder()
        .id(1L)
        .firstName("Pavlo")
        .lastName("Zobenko")
        .dateOfBirthday(LocalDate.of(2003, 7, 10))
        .build();

    given(repository.findById(entity.getId()))
        .willReturn(Optional.of(entity));

    assertEquals(expectedResult, serviceToTest.getUserByIdAndCalculateAge(entity.getId()).getAge());
  }

  @Test
  void getUserByIdAndCalculateAgeWithExistUserAgeWill12() {
    int expectedResult = 12;

    UserEntity entity = UserEntity.builder()
        .id(2L)
        .firstName("Anna")
        .lastName("Kuzmenko")
        .dateOfBirthday(LocalDate.of(2010, 9, 11))
        .build();

    given(repository.findById(entity.getId()))
        .willReturn(Optional.of(entity));

    assertEquals(expectedResult, serviceToTest.getUserByIdAndCalculateAge(entity.getId()).getAge());
  }


  @Test
  void getUserByIdAndCalculateAgeWithoutExistUser() {
    assertThatThrownBy(() -> serviceToTest.getUserByIdAndCalculateAge(12345L))
        .isInstanceOf(TheUserNotFoundException.class)
        .hasMessageContaining("User with id " + 12345L + " not found!");
  }
}