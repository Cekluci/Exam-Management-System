package com.nye.springboot.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.nye.springboot.model.Exams;
import com.nye.springboot.model.ExamsTable;
import com.nye.springboot.services.imp.ExamsServiceImp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class ExamsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private static ExamsServiceImp underTest;

    @Mock
    private ExamRepository examRepository;

    @Mock
    private ExamTableRepository examTableRepository;

 /*    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    } */

    @AfterAll
    public static void tearDown() {
        underTest = null;
    }

    @Test
    public void testGetAllExamsShouldReturnListOfExamsWhenCalled() {
        
        //given
        Collection<Exams> expected = List.of(createExam());
        given(examRepository.findAll()).willReturn(List.of(createExam()));

        //when
        Collection<Exams> actual = underTest.getAllExams();

        //then
        assertEquals(actual, expected);
        then(examRepository).should().findAll();
    }

    @Test
    public void testGetExamByIdShouldReturnExamWhenCalledWithExistingId() {
        //given
        ExamsTable expected = createExamTable();
        given(examTableRepository.findById(3L)).willReturn(createOptionalExamsTable());

        //when
        ExamsTable actual = underTest.getExamById(3L);

        //then
        assertEquals(actual, expected);
        then(examTableRepository).should().findById(3L);
    }

    @Test
    public void testAddExamShouldSaveTheExamWhenCalled() {
        //given
        ExamsTable expected = createExamTable();

        //when
        underTest.createExam(expected);

        //then
        then(examTableRepository).should().save(expected);
    }

    @Test
    public void testDeleteExamShouldDelegateToRepository() {
        //given
        ExamsTable exam = createExamTable();
        given(examTableRepository.findById(3L)).willReturn(createOptionalExamsTable());
        
        //when
        underTest.deleteExam(3L);

        //then
        then(examTableRepository).should().delete(exam);
    }


    private Optional<Exams> createOptionalExam() {
        return Optional.of(createExam());
    }

    private Optional<ExamsTable> createOptionalExamsTable() {
        return Optional.of(createExamTable());
    }

    private Exams createExam() {
        Exams exam = new Exams();
        exam.setId(3L);
        exam.setExamName("testExamName");
        exam.setExamLocation("testLocation");
        exam.setLecturer("testLecturer");
        exam.setExamDate(LocalDate.of(2023, 01, 01)); 
        exam.setExamLimit(20);
        exam.setExamFreeSpace(20);
        return exam;
    }

        private ExamsTable createExamTable() {
        ExamsTable examTable = new ExamsTable();
        examTable.setId(3L);
        examTable.setExamName("testExamName");
        examTable.setExamLocation("testLocation");
        examTable.setLecturer("testLecturer");
        examTable.setExamDate(LocalDate.of(2023, 01, 01)); 
        examTable.setExamLimit(20);
        examTable.setExamFreeSpace(20);
        return examTable;
    }
}
