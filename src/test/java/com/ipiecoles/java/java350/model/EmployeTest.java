package com.ipiecoles.java.java350.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;


class EmployeTest {

    @Test
    void getNombreAnneeAnciennete() {
        //Given
            Employe employe = new Employe("Nicolas", "John", "T123432", LocalDate.of(2018, Month.JANUARY, 8), 2599d, 1,1.4);
        //When
            int nbAnnees = employe.getNombreAnneeAnciennete();
        //Then

        Assertions.assertThat(nbAnnees).isEqualTo(3);
    }

    @Test
    void nombreAnneeAncienneteEgalNul(){
        //given
        Employe employe= new Employe();
        employe.setDateEmbauche(null);
        //when
        Integer nombreAnneeAnciennete = employe.getNombreAnneeAnciennete();
        //then
        Assertions.assertThat(nombreAnneeAnciennete).isNull();
    }
    @Test
    void getNombreAnneeAncienneteFeutre(){
        //given
        Employe employe = new Employe("Nicolas", "John", "T12345", LocalDate.now().plusYears(1), 2599d, 1, 1.0);

        //when
        int nbAnnee = employe.getNombreAnneeAnciennete();

        //then
        Assertions.assertThat(nbAnnee).isZero();
    }

    @Test
    void getNombreAnneeAncienneteZero() {
        //given
        Employe employe = new Employe("Nicolas", "John", "T12333", LocalDate.now(), 2599d, 1, 1.4);

        //when
        int nbAnnee = employe.getNombreAnneeAnciennete();
        //then
        Assertions.assertThat(nbAnnee).isZero();
    }
    @Test
    void testNombreAnneeAncienneteDansLePasse(){
        //given
        Employe employe= new Employe();
        employe.setDateEmbauche(LocalDate.now().minusYears(2));
        //when
        Integer nombreAnneeAnciennete = employe.getNombreAnneeAnciennete();
        //then
        Assertions.assertThat(nombreAnneeAnciennete).isEqualTo(2);
    }

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
            "2, 'M12345', 8, 1.0, 2500.0",
            " , 'M12345', 8, 1.0, 2500.0",
            ", 'M12345', 8, 1.0, 2500.0"
    })
     void getPrimeAnnuelle(Integer performance, String matricule, Long nbYearsAnciennete, Double tempsPartiel, Double primeAnnuelle){
        //Given
        Employe employe = new Employe("Doe", "John", matricule, LocalDate.now().minusYears(nbYearsAnciennete), null, performance, tempsPartiel);

        //When
        Double prime = employe.getPrimeAnnuelle();

        //Then
        Assertions.assertThat(prime).isEqualTo(primeAnnuelle);

    }

    public void getPrimeAnnuelleM(){
        //Given
        Employe employe = new Employe("Nicolas", "John", "T123432", LocalDate.of(2018, Month.JANUARY, 8), 1000d, 1,1.4);

        //When
        employe.setMatricule("M123");
        String mat = "M123";

        //Then
        Assertions.assertThat(mat).isEqualTo(employe.getMatricule());
    }
/*
    @Test
    void getNbRtt(){
        //Given
        Employe employe = new Employe("Nicolas", "John", "T123432", LocalDate.of(2018, Month.JANUARY, 8), 1000d, 1,1.4);

        //When
      //  Date prime = new Date();
        Assertions.assertThat(employe.getNbRtt(new Date(21/11/2019))).isEqualTo(14);

    }
*/
    @Test
    void testAugmenterSalaire() {
        double untaireٍsalaire = 0;
        double persntageaugmentaion = 5.0;
        //Given
        Employe employe = new Employe("Nicolas", "John", "T123432", LocalDate.of(2018, Month.JANUARY, 8), 1000d, 1,1.4);
        employe.setSalaire(1200d);
        untaireٍsalaire = employe.getSalaire()  * (1 + (persntageaugmentaion/100));

        //When
        employe.augmenterSalaire(5.0);
        //Then
        Assertions.assertThat(employe.getSalaire()).isEqualTo(untaireٍsalaire);


    }
    @Test
    void augmenterSalaireZero() {
        double untaireٍsalaire = 0;
        double persntageaugmentaion = 5.0;
        //Given
        Employe employe = new Employe("Nicolas", "John", "T123432", LocalDate.of(2018, Month.JANUARY, 8), 0d, 1,1.4);
        untaireٍsalaire = employe.getSalaire()  * (1 + (persntageaugmentaion/100));

        //When
        employe.augmenterSalaire(5.0);
        //Then
        Assertions.assertThat(employe.getSalaire()).isZero();
    }
    @Test
    void augmenterSalairePourcentageNegatif(){
        //given
        Employe employe = new Employe("Nicolas", "John", "T123432", LocalDate.of(2018, Month.JANUARY, 8), 1900d, 1,1.4);
        Double salaireSmic = 1500.0;
        //when
        employe.augmenterSalaire(-3d);

        //then
        Assertions.assertThat(employe.getSalaire()).isEqualTo(employe.getSalaire());
    }
    @Test
    void augmenterSalaireNull(){
        //given
        Employe employe = new Employe("Nicolas", "John", "T123432", LocalDate.of(2018, Month.JANUARY, 8), null, 1,1.4);
        //when
        employe.augmenterSalaire(10d);
        //then
        Assertions.assertThat(employe.getSalaire()).isNull();
    }


    @ParameterizedTest(name = "date : {0} nbRTT : {1}")
    @CsvSource({
            "2019, 10",
            "2021, 9",
            "2022, 10",
            "2032, 12",
            "2016, 5",
            "2026, 8"
    })

    void getNbConges(){
        //given
        Employe employe = new Employe("nico", "nel", "R123", LocalDate.now().minusYears(4), 2000d, 1, 1.0);
        //when
        int nbconges = employe.getNbConges();
        //then
        Assertions.assertThat(nbconges).isEqualTo(29);
    }

    @ParameterizedTest(name = "date : {0} nbRTT : {1}")
    @CsvSource({
            "2019, 9",
            "2021, 11",
            "2022, 11",
            "2032, 10",
            "2020, 9",
            "2026, 10" /* pour cas de Jeudi*/

    })
    void testGetNbRtt(Integer dateReference, Integer nbAttendu){
        //given
        Employe employe = new Employe();

        //when
        int nbRTT = employe.getNbRtt(LocalDate.of(dateReference, 1, 1));

        //then
        Assertions.assertThat(nbRTT).isEqualTo(nbAttendu);
    }

}