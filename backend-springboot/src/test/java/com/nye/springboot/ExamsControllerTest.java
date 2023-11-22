package com.nye.springboot;

import java.time.LocalDate;
import java.util.List;

//import org.assertj.core.util.Arrays;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.nye.springboot.controller.ExamsController;
import com.nye.springboot.controller.StudentController;
import com.nye.springboot.model.Exams;
import com.nye.springboot.repository.ExamRepository;
import com.nye.springboot.services.CustomServices;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ExamsController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExamsControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomServices customServices;

    @MockBean
    private ExamsController examsController;

    @MockBean
    private ExamRepository examRepository;

    @MockBean
    private StudentController studentController;

    @Test
    public void getAllExamsShouldReturnAllExams() throws Exception {

        //Given
        LocalDate examDate1 = LocalDate.of(2023, 01, 01);
        LocalDate examDate2 = LocalDate.of(2023, 02, 01);
        Exams exam1 = new Exams(1L, "testExam1", "testLocation1", "testLecturer1", examDate1, 20, 20);
        Exams exam2 = new Exams(2L, "testExam2", "testLocation2", "testLecturer2", examDate2, 10, 10);
        
        List<Exams> allExams = Arrays.asList(exam1, exam2);

        given(examRepository.findAll()).willReturn(allExams);

        //When and Then
        mockMvc.perform(get("/exams")).andDo(print())
            //.contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].id", is(exam1.getId().intValue())))
            .andExpect(jsonPath("$[0].examName", is(exam1.getExamName())))
            .andExpect(jsonPath("$[1].id", is(exam2.getId().intValue())))
            .andExpect(jsonPath("$[1].examName", is(exam2.getExamName())));

        //Verify
        verify(examRepository).findAll();
    }
}
