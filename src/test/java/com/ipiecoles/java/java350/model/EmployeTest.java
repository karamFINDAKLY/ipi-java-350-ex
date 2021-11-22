package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {

    @Test
    void getNombreAnneeAnciennete() {
        //Given
            Employe employe = new Employe("Nicolas", "John", "T123432", LocalDate.of(2018, Month.JANUARY, 8), 2599d, 1,1.4);
        //When
            Integer nbAnnees = employe.getNombreAnneeAnciennete();
        //Then

        Assertions.assertThat(nbAnnees).isEqualTo(3);
    }
}