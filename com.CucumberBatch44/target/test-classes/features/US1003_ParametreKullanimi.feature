
@parametreliTest

Feature:US1003 parametre ile stepdefination oluşturma

  Scenario: TC05_Parametre Kullanımı

    Given kullanici amazon sayfasina gider
    And "teapot" icin arama yapar
    Then sonuclarin "teapot" icerdigini test eder
    And kullanici sayfayi kapatir


