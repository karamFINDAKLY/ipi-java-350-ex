package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {

    //Exercice 1 : getNombreAnneeAnciennete
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

    //Exercice 2 : getPrimeAnnuelle
    /*
    matricule
    performance
    dateEmbauche
    tempsPartiel
     */
    @ParameterizedTest
    @CsvSource({
            "1, 'T12345', 0, 1.0, 1000.0",
            "1, 'T12345', 2, 0.5, 600.0",
            "1, 'T12345', 2, 1.0, 1200.0",
            "2, 'T12345', 0, 1.0, 2300.0",
            "2, 'T12345', 1, 1.0, 2400.0",
            "1, 'M12345', 0, 1.0, 1700.0",
            "1, 'M12345', 5, 1.0, 2200.0",
            "2, 'M12345', 0, 1.0, 1700.0",
            "2, 'M12345', 8, 1.0, 2500.0"
    })
    void testGetPrimeAnnuelle(Integer performance, String matricule, Long nbYearsAnciennete, Double tempsPartiel, Double primeAnnuelle) {
        //given
        Employe employe = new Employe("Doe", "John", matricule, LocalDate.now().minusYears(nbYearsAnciennete), Entreprise.SALAIRE_BASE, performance, tempsPartiel);

        //when
        Double prime = employe.getPrimeAnnuelle();

        //then
        Assertions.assertThat(prime).isEqualTo(primeAnnuelle);
    }
}