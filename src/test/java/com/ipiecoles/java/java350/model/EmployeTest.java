package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

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


    @Test
    void testSalaire() {
        double untaireٍsalaire = 0;
        double persntageaugmentaion = 5.0;
        //Given
        Employe employe = new Employe("Nicolas", "John", "T123432", LocalDate.of(2018, Month.JANUARY, 8), 1000d, 1,1.4);
         untaireٍsalaire = employe.getSalaire()  * (1 + (persntageaugmentaion/100));

        //When
        employe.augmenterSalaire(5.0);
        //Then
        Assertions.assertThat(employe.getSalaire()).isEqualTo(untaireٍsalaire);


    }
    @Test
    void testSalaireZero() {
        double untaireٍsalaire = 0;
        double persntageaugmentaion = 5.0;
        //Given
        Employe employe = new Employe("Nicolas", "John", "T123432", LocalDate.of(2018, Month.JANUARY, 8), 0d, 1,1.4);
        untaireٍsalaire = employe.getSalaire()  * (1 + (persntageaugmentaion/100));

        //When
        employe.augmenterSalaire(5.0);
        //Then
        Assertions.assertThat(employe.getSalaire()).isEqualTo(untaireٍsalaire);


    }



    @ParameterizedTest
    @CsvSource({
            "1, 'T12345', 0, 1.0, 1000.0",
            "1, 'T12345', 2, 0.5, 600.0",
            "1, 'T12345', 2, 1.0, 1200" +
                    ".0",
            "2, 'T12345', 0, 1.0, 2300.0",
            "2, 'T12345', 1, 1.0, 2400.0",
            "1, 'M12345', 0, 1.0, 1700.0",
            "1, 'M12345', 5, 1.0, 2200.0",
            "2, 'M12345', 0, 1.0, 1700.0",
            "2, 'M12345', 8, 1.0, 2500.0"
    })
    public void getPrimeAnnuelle(Integer performance, String matricule, Long nbYearsAnciennete, Double tempsPartiel, Double primeAnnuelle){
        //Given
        Employe employe = new Employe("Doe", "John", matricule, LocalDate.now().minusYears(nbYearsAnciennete), Entreprise.SALAIRE_BASE, performance, tempsPartiel);

        //When
        Double prime = employe.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(primeAnnuelle);

    }


        //Gigen

        //When

        //Then


    @Test
    public void getNombreAnneeAncienneteNull(){
        //Given
        Employe e = new Employe();
        e.setDateEmbauche(null);

        //When
        Integer anneeAnciennete = e.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat( anneeAnciennete).isZero();
    }



}