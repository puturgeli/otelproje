Feature: US1007 Scenario Outline ile Amazon Search

  Scenario Outline: TC12 amazonda bir liste deki tüm elementleri aratmak
    Given kullanici "AmazonUrl" sayfasina gider
    Then "<aranacakEleman>" icin arama yapar
    And sonuclarin "<aranacakEleman>" icerdigini test eder
    Then kullanici sayfayi kapatir






    Examples:
    |aranacakEleman|
    |java|
    |teapot|
    |samsung|
    |armut  |
    |nutella|
