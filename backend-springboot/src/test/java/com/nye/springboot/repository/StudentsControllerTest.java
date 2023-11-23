package com.nye.springboot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.nye.springboot.exception.NoFreeSpaceException;
import com.nye.springboot.model.Exams;
import com.nye.springboot.model.StudentReg;
import com.nye.springboot.services.imp.StudentsServiceImp;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class StudentsControllerTest {

    @InjectMocks
    private static StudentsServiceImp underTest;

    @Mock
    private StudentRegRepository studentRepository;

    @Mock
    private ExamRepository examRepository;

    @AfterAll
    public static void tearDown() {
        underTest = null;
    }

    @Test
    public void testGetAllRegistrationsShouldReturnListOfRegsWhenCalled() {

        //given
        Collection<StudentReg> expected = List.of(createReg());
        given(studentRepository.findAll()).willReturn(List.of(createReg()));

        //when
        Collection<StudentReg> actual = underTest.getAllRegistrations();

        //then
        assertEquals(actual, expected);
        then(studentRepository).should().findAll();

    }

    @Test
    public void testWhenThereIsFreeSpaceThenRegister() {

        //given
        Long examId = 3L;
        Exams exam = mock(Exams.class);
        when(exam.getExamFreeSpace()).thenReturn(2);
        when(examRepository.findById(examId)).thenReturn(Optional.of(exam));

        StudentReg expected = new StudentReg();

        //when
        underTest.newRegistration(examId, expected);

        //then
        then(studentRepository).should().save(expected);
    }

    @Test
    public void testWhenNoFreeSpaceThenThrowNoFreeSpaceException() {

        //given
        Long examId = 3L;
        Exams exam = mock(Exams.class);
        when(exam.getExamFreeSpace()).thenReturn(0);
        when(examRepository.findById(examId)).thenReturn(Optional.of(exam));

        StudentReg reg = new StudentReg();

        //When and Then
        assertThrows(NoFreeSpaceException.class, () -> underTest.newRegistration(examId, reg),
            "Expected newReg to throw, but it didn't");

        verify(studentRepository, never()).save(any(StudentReg.class));
    }

    @Test
    public void testDeleteRegistrationShouldDelegateToRepository() {

        //given
        StudentReg reg = createReg();
        given(studentRepository.findById(3L)).willReturn(createOptionalReg());

        //when
        underTest.deleteRegistration(3L);

        //then
        then(studentRepository).should().delete(reg);
    }

    private Optional<StudentReg> createOptionalReg() {
        return Optional.of(createReg());
    }

    private StudentReg createReg() {
        StudentReg reg = new StudentReg();
        reg.setId(3L);
        reg.setStudentName("testStudentName");
        reg.setRegisteredTo("testExam");
        reg.setExamId(5);
        return reg;
    }
}
