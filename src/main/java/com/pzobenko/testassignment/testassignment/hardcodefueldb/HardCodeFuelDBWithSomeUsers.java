package com.pzobenko.testassignment.testassignment.hardcodefueldb;

import com.pzobenko.testassignment.testassignment.entitys.UserEntity;
import com.pzobenko.testassignment.testassignment.reposytories.UserRepo;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class HardCodeFuelDBWithSomeUsers implements CommandLineRunner {

  private final UserRepo repo;

  @Override
  public void run(String... args) {
    repo.save(UserEntity.builder()
        .id(1L)
        .firstName("Pavlo")
        .lastName("Zobenko")
        .dateOfBirthday(LocalDate.of(2003, 7, 10))
        .build());

    repo.save(UserEntity.builder()
        .id(2L)
        .firstName("Anna")
        .lastName("Kuzmenko")
        .dateOfBirthday(LocalDate.of(2010, 9, 11))
        .build());

    repo.save(UserEntity.builder()
        .id(3L)
        .firstName("Andrii")
        .lastName("Kovalev")
        .dateOfBirthday(LocalDate.of(2000, 10, 10))
        .build());

    repo.save(UserEntity.builder()
        .id(4L)
        .firstName("Pavlo")
        .lastName("Kovalenko")
        .dateOfBirthday(LocalDate.of(1999, 12, 1))
        .build());

    repo.save(UserEntity.builder()
        .id(5L)
        .firstName("Oleksi")
        .lastName("Piskovii")
        .dateOfBirthday(LocalDate.of(2004, 1, 10))
        .build());

    repo.save(UserEntity.builder()
        .id(6L)
        .firstName("Oleksandr")
        .lastName("Zobenko")
        .dateOfBirthday(LocalDate.of(2008, 9, 18))
        .build());

    repo.save(UserEntity.builder()
        .id(7L)
        .firstName("Nikolai")
        .lastName("Zadorojnii")
        .dateOfBirthday(LocalDate.of(1891, 9, 18))
        .build());

    repo.save(UserEntity.builder()
        .id(8L)
        .firstName("Bob")
        .lastName("Jackson")
        .dateOfBirthday(LocalDate.of(1010, 9, 18))
        .build());
  }

}