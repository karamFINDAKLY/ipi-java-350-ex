package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {

    @Test
    void testGetNombreAnneeAncienneteZero() {
        //given
        Employe employe = new Employe("John", "Doe", "T12345", LocalDate.now(), 2500.0, 1, 1.0);

        //when
        int nbAnnee = employe.getNombreAnneeAnciennete();
        //then
        Assertions.assertThat(nbAnnee).isEqualTo(0);
    }

    @Test
    void testGetNombreAnneeAnciennete() {
        //given
        Employe employe = new Employe("John", "Doe", "T12345", LocalDate.now().minusYears(6), 2500.0, 1, 1.0);

        //when
        int nbAnnee = employe.getNombreAnneeAnciennete();
        //then
        Assertions.assertThat(nbAnnee).isEqualTo(6);
    }

    @Test
    void testGetNombreAnneeAncienneteNull(){
        //given
        Employe employe = new Employe("John", "Doe", "T12345", null, 2500.0, 1, 1.0);

        //when
        Integer nbAnnee = employe.getNombreAnneeAnciennete();

        //then
        Assertions.assertThat(nbAnnee).isNull();
    }

    @Test
    void testGetNombreAnneeAncienneteTomorrow(){
        //given
        Employe employe = new Employe("John", "Doe", "T12345", LocalDate.now().plusYears(1), 2500.0, 1, 1.0);

        //when
        int nbAnnee = employe.getNombreAnneeAnciennete();

        //then
        Assertions.assertThat(nbAnnee).isEqualTo(0);
    }
}