package com.pzobenko.testassignment.testassignment.e2e;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.pzobenko.testassignment.testassignment.TestAssignmentApplication;
import com.pzobenko.testassignment.testassignment.entitys.UserEntity;
import com.pzobenko.testassignment.testassignment.reposytories.UserRepo;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
   classes = TestAssignmentApplication.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@AutoConfigureMockMvc
public class UserRestControllerIntegrationTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private UserRepo repository;

  @Test
  public void getUserCheckAgeIs19()
      throws Exception {

    int expectedAge = 19;
    long idToCalculateAge = 1234L;

    UserEntity entityToTest = UserEntity.builder()
        .id(idToCalculateAge)
        .dateOfBirthday(LocalDate.of(2003, 12, 1))
        .firstName("SomeTestName")
        .lastName("SomeTestLastName")
        .build();

    Mockito.when(repository.findById(idToCalculateAge)).thenReturn(
        Optional.of(entityToTest));

    mvc.perform(get("/api/v1/user/{0}", idToCalculateAge)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.age").value(expectedAge));
  }

@Test
  public void getUserCheckAgeIs100()
      throws Exception {

    int expectedAge = 100;
    long idToCalculateAge = 1234L;

    UserEntity entityToTest = UserEntity.builder()
        .id(idToCalculateAge)
        .dateOfBirthday(LocalDate.of(1922, 12, 1))
        .firstName("SomeTestName")
        .lastName("SomeTestLastName")
        .build();

  Mockito.when(repository.findById(idToCalculateAge)).thenReturn(
      Optional.of(entityToTest));


    mvc.perform(get("/api/v1/user/{0}", idToCalculateAge)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.age").value(expectedAge));
  }

  @Test
  public void get404Status() throws Exception{
    long nonExistId = 6969;
    String notFoundMessage = "NOT_FOUND";
    mvc.perform(get("/api/v1/user/{0}", nonExistId)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.message").value(notFoundMessage));
  }
}