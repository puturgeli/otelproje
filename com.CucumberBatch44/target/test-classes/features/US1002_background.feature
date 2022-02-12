Feature: US1002_basckground ile amazon search testi

Background: amazon sayfasina gidis
  Given kullanici amazon sayfasina gider
 # diyez ike yorum yazabiliriz

  @wip
  Scenario: TC02_Amazon iphone arama Testi

    And iPhone icin arama yapar
    Then sonuclarin Iphone icerdigini test eder

    @wip
  Scenario: TC03_Amazon teapot arama Testi
    And tea pot icin arama yapar
    Then sonuclarin tea pot icerdigini test eder


  Scenario: TC04_Amazon flower arama Testi

    And flower icin arama yapar
    Then sonuclarin flower icerdigini test eder
    Then kullanici sayfayi kapatir